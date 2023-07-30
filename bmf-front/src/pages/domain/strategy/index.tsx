import { useCallback, useRef, useEffect, useState } from "react";
import ReactFlow, {
  useNodesState,
  useEdgesState,
  addEdge,
  useReactFlow,
  ReactFlowProvider,
  EdgeTypes,
  Node,
  Edge,
} from "reactflow";
import { Button, Form, Input, Select, message } from "antd";
import RelationEdge from "./relationEdge";
import axios from "../../../utils/axios";
import "reactflow/dist/style.css";

import "./index.css";
import { useForm } from "antd/es/form/Form";

const relationDefaultOptions = [
  {
    label: "合作伙伴",
    value: "partnership",
  },
  {
    label: "共享内核",
    value: "shared-Kernel",
  },
  {
    label: "上下游",
    value: "upstream-downstream",
  },
  {
    label: "客户/供应商",
    value: "customer-supplier",
  },
  {
    label: "被包含/包含",
    value: "kernel-shell",
  },
];

const relationRoleMap = {
  partnership: {
    options: [
      {
        label: "合作伙伴",
        value: "PARTNER",
      },
    ],
  },
  "shared-Kernel": {
    options: [
      {
        label: "合作伙伴",
        value: "PARTNER",
      },
    ],
  },
  "upstream-downstream": {
    options: [
      {
        label: "发布语言/开放主机",
        value: "PL/OHS",
      },
      {
        label: "防腐层/遵从者",
        value: "ACL/CF",
      },
    ],
  },
  "customer-supplier": {
    options: [
      {
        label: "客户",
        value: "CUSTOMER",
      },
      {
        label: "供应商",
        value: "SUPPLIER",
      },
    ],
  },
  "kernel-shell": {
    options: [
      {
        label: "被包含",
        value: "KERNEL",
      },
      {
        label: "包含",
        value: "SHELL",
      },
    ],
  },
};
const relationRoleOptions = [
  {
    label: "发布语言",
    value: "PL",
  },
  {
    label: "开放主机服务",
    value: "OHS",
  },
  {
    label: "供应商",
    value: "SUPPLIER",
  },
  {
    label: "防腐层",
    value: "ACL",
  },
  {
    label: "遵从者",
    value: "CF",
  },
  {
    label: "客户",
    value: "CUSTOMER",
  },
  {
    label: "合作伙伴",
    value: "partne",
  },
  {
    label: "被包含",
    value: "KERNEL",
  },
  {
    label: "包含",
    value: "SHELL",
  },
];
const domainTypeOptions = [
  {
    label: "核心域",
    value: "core",
  },
  {
    label: "通用域",
    value: "generic",
  },
  {
    label: "支撑域",
    value: "supporting",
  },
];
const domainLevelOptions = [
  {
    label: "一级域",
    value: 1,
  },
  {
    label: "二级域",
    value: 2,
  },
  {
    label: "三级域",
    value: 3,
  },
];

const initialNodes: Node[] = [
  {
    id: "0",
    type: "input",
    data: { label: "Node 1" },
    position: { x: 500, y: 0 },
  },
];

let id = 1;
const getId = () => `${id++}`;

const fitViewOptions = {
  padding: 3,
};

const edgeTypes: EdgeTypes = {
  relation: RelationEdge,
};

const AddNodeOnEdgeDrop = () => {
  const reactFlowWrapper = useRef(null);
  const connectingNodeId = useRef(null);
  const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);
  const [domainName, setDomainName] = useState("");
  const [domainAlias, setDomainAlias] = useState("");
  const [nodeBg, setNodeBg] = useState("#fff");
  const [nodeStartLabel, setNodeStartLabel] = useState("");
  const [nodeCenterLabel, setNodeCenterLabel] = useState("");
  const [nodeEndLabel, setNodeEndLabel] = useState("");
  const [hasStrategy, setHasStrategy] = useState(true);

  const [form] = useForm();
  // const [relationOptions, setRelationOptions] = useState<any[]>(
  //   relationDefaultOptions
  // );
  const [roleAOptions, setRoleAOptions] = useState<any[]>([]);
  const [roleBOptions, setRoleBOptions] = useState<any[]>([]);

  const [domainType, setDomainType] = useState<string>("");
  const [domainLevel, setDomainLevel] = useState<number>();
  const [selectedDomain, setSelectedDomain] = useState<boolean>(false);

  const { project } = useReactFlow();

  useEffect(() => {
    axios
      .get("/business/detail", {
        params: { business_code: 101, include_all: true },
      })
      .then((res) => {
        return;
        const { businessDomainList = [], businessDomainRelationList = [] } =
          res?.data?.business;
        if (businessDomainList?.length && businessDomainRelationList?.length) {
          const nodes = businessDomainList.map((item: any, index: number) => {
            const {
              domainCode,
              domainName,
              domainType,
              domainAlias,
              domainPosition,
              extMap,
            } = item;
            return {
              // type: "input",
              id: String(domainCode),
              data: {
                label: domainName,
              },
              position: JSON.parse(domainPosition),
              // extInfo: {
              //   domainType,
              //   domainAlias,
              //   extMap,
              // },
            };
          });
          setNodes(nodes);
          const edges = businessDomainRelationList.map((item: any) => {
            const {
              domainARole,
              domainACode,
              domainRelation,
              domainBRole,
              domainBCode,
            } = item;
            return {
              id: `e${domainACode}-${domainBCode}`,
              source: String(domainACode),
              target: String(domainBCode),
              animated: true,
              type: "relation",
              data: {
                domainRelation,
                domainARole,
                domainBRole,
              },
              // data: {
              //   domainRelation,
              //   domainARole,
              //   domainBRole,
              // },
              // type: "custom",
            };
          });
          // console.log(edges, "edges");
          setEdges(edges);
          setHasStrategy(true);
        } else {
          setHasStrategy(false);
        }
      })
      .catch(() => {
        setHasStrategy(false);
      });
  }, []);

  useEffect(() => {
    setNodes((nds) => {
      return nds.map((node) => {
        if (node.selected) {
          node.data = {
            ...node.data,
            label: domainName,
            domainAlias,
            domainType,
            domainLevel,
          };
        }
        return node;
      });
    });
  }, [domainName, domainAlias, domainType, domainLevel, setNodes]);

  useEffect(() => {
    setNodes((nds) =>
      nds.map((node) => {
        if (node.selected) {
          node.style = { ...node.style, backgroundColor: nodeBg };
        }
        return node;
      })
    );
  }, [nodeBg, setNodes]);

  useEffect(() => {
    setEdges((edges) =>
      edges.map((node) => {
        if (node.selected) {
          node.type = "relation";
          // node.animated = true;
          if (!node.data) {
            node.data = {};
          }
          node.data.domainARole = nodeStartLabel;
          node.data.domainRelation = nodeCenterLabel;
          node.data.domainBRole = nodeEndLabel;
        }
        return node;
      })
    );
  }, [nodeStartLabel, nodeCenterLabel, nodeEndLabel, setEdges]);

  useEffect(() => {
    setEdges((edges) =>
      JSON.parse(
        JSON.stringify(
          edges.map((node) => {
            if (node.selected) {
              node.type = "relation";
              if (!node.data) {
                node.data = {};
              }
              // if (domainType) {
              //   node.data.domainType = domainType;
              // }
              // if (domainLevel) {
              //   node.data.domainLevel = domainLevel;
              // }
              if (nodeStartLabel) {
                node.data.domainARole = nodeStartLabel;
              }
              if (nodeCenterLabel) {
                node.data.domainRelation = nodeCenterLabel;
              }
              if (nodeEndLabel) {
                node.data.domainBRole = nodeEndLabel;
              }
            }
            return node;
          })
        )
      )
    );
  }, [
    nodeStartLabel,
    nodeCenterLabel,
    nodeEndLabel,
    // domainType,
    // domainLevel,
    setEdges,
  ]);

  const onConnect = useCallback((params) => {
    return setEdges((eds) => addEdge(params, eds));
  }, []);

  const onConnectStart = useCallback((_, { nodeId }) => {
    connectingNodeId.current = nodeId;
  }, []);

  const onConnectEnd = useCallback(
    (event) => {
      const targetIsPane = event.target.classList.contains("react-flow__pane");
      if (targetIsPane) {
        // we need to remove the wrapper bounds, in order to get the correct position
        const { top, left } = reactFlowWrapper.current.getBoundingClientRect();
        const id = getId();
        const newNode = {
          id,
          // we are removing the half of the node width (75) to center the new node
          position: project({
            x: event.clientX - left - 75,
            y: event.clientY - top,
          }),
          data: { label: `Node ${id}` },
        };

        setNodes((nds) => nds.concat(newNode));
        setEdges((eds) => {
          return eds.concat({
            id,
            source: connectingNodeId.current,
            target: id,
          });
        });
      }
    },
    [project]
  );

  const onSave = () => {
    const params = {
      business: {
        businessCode: 101,
      },
      domainList: nodes.map((node: any) => {
        const { id, data, position, extInfo = {} } = node;
        const { label: domainName, ...rest } = data;
        if (position.x) {
          position.x = parseInt(position.x);
        }
        if (position.y) {
          position.y = parseInt(position.y);
        }
        return {
          domainCode: id,
          domainName,
          ...rest,
          ...extInfo,
          domainPosition: JSON.stringify(position),
        };
      }),
      relationshipList: edges.map((node: any) => {
        const { source, target, data = {} } = node;
        const { domainRelation, domainARole, domainBRole } = data;
        return {
          relationship: domainRelation,
          roleA: {
            domain: {
              domainCode: source,
            },
            role: domainARole,
          },
          roleB: {
            domain: {
              domainCode: target,
            },
            role: domainBRole,
          },
          // domainRelation,
          // domainARole,
          // domainBRole,
          // domainACode: source,
          // domainBCode: target,
        };
      }),
    };
    axios
      .post("/business/strategy/design/save", params)
      .then((res) => {
        message.success("保存成功!");
      })
      .catch((error) => {
        message.success(error);
      });
  };

  return (
    <div
      style={{ width: "100%", height: "100vh" }}
      className="wrapper"
      ref={reactFlowWrapper}
    >
      {!hasStrategy ? (
        <div
          style={{
            width: "100%",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            flexDirection: "column",
            marginTop: 100,
          }}
        >
          <h3>您还没有进行战略设计...</h3>
          <Button
            size="large"
            type="primary"
            style={{ marginTop: 20 }}
            onClick={() => setHasStrategy(true)}
          >
            马上开始
          </Button>
        </div>
      ) : (
        <>
          <ReactFlow
            nodes={nodes}
            edges={edges}
            edgeTypes={edgeTypes}
            onNodesChange={(e) => {
              onNodesChange(e);
            }}
            onEdgesChange={(e) => {
              onEdgesChange(e);
            }}
            onConnect={onConnect}
            onConnectStart={onConnectStart}
            onConnectEnd={onConnectEnd}
            fitViewOptions={fitViewOptions}
          >
            <div className="updatenode__controls">
              <div style={{ display: "flex" }}>
                <Form form={form}>
                  <Form.Item
                    label="领域名称"
                    name="domainName"
                    rules={[{ required: true }]}
                  >
                    <Input
                      size="small"
                      style={{ width: 130 }}
                      value={domainName}
                      onChange={(evt) => setDomainName(evt.target.value)}
                      placeholder="请输入领域名称"
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item
                    rules={[{ required: true }]}
                    label="领域别名"
                    name="domainAlias"
                  >
                    <Input
                      size="small"
                      style={{ width: 130 }}
                      value={domainName}
                      onChange={(evt) => setDomainAlias(evt.target.value)}
                      placeholder="请输入领域别名"
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item label="节点背景色" name="nodeBg">
                    <Input
                      style={{ width: 130 }}
                      value={nodeBg}
                      size="small"
                      onChange={(evt) => setNodeBg(evt.target.value)}
                      placeholder="请输入节点背景色"
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item
                    rules={[{ required: true }]}
                    label="领域类型"
                    name="domainType"
                  >
                    <Select
                      style={{ width: 130 }}
                      onChange={(evt) => setDomainType(evt)}
                      options={domainTypeOptions}
                      size="small"
                      placeholder="请输入领域类型"
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item
                    rules={[{ required: true }]}
                    label="领域等级"
                    name="domainLevel"
                  >
                    <Select
                      style={{ width: 130 }}
                      options={domainLevelOptions}
                      size="small"
                      onChange={(evt) => setDomainLevel(evt)}
                      placeholder="请输入领域等级"
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item>
                    <Button type="primary" htmlType="submit" onClick={onSave}>
                      保存
                    </Button>
                  </Form.Item>
                </Form>
                <Form style={{ marginLeft: 10 }}>
                  <Form.Item
                    rules={[{ required: true }]}
                    label="领域关系"
                    name="domainRelation"
                  >
                    <Select
                      size="small"
                      style={{ width: 130 }}
                      options={relationDefaultOptions}
                      onChange={(value) => {
                        setRoleAOptions(relationRoleMap[value].options);
                        setRoleBOptions(relationRoleMap[value].options);
                        setNodeCenterLabel(value);
                      }}
                      placeholder="请选择领域关系"
                    />
                  </Form.Item>
                  <Form.Item label="领域角色A" name="domainRelationA">
                    <Select
                      size="small"
                      style={{ width: 130 }}
                      options={roleAOptions}
                      onChange={(value) => setNodeStartLabel(value)}
                      allowClear
                    />
                  </Form.Item>
                  <Form.Item label="领域角色B" name="domainRelationB">
                    <Select
                      size="small"
                      style={{ width: 130 }}
                      options={roleBOptions}
                      onChange={(value) => setNodeEndLabel(value)}
                      allowClear
                    />
                  </Form.Item>
                </Form>
              </div>

              {/* <div>
                <label>节点文案:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={domainName}
                  onChange={(evt) => setDomainName(evt.target.value)}
                />
              </div> */}
              {/* <div>
                <label className="updatenode__bglabel">节点背景色:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeBg}
                  onChange={(evt) => setNodeBg(evt.target.value)}
                />
              </div>
              <div>
                <label className="updatenode__bglabel">起始节点关系:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeStartLabel}
                  onChange={(evt) => setNodeStartLabel(evt.target.value)}
                />
              </div>
              <div>
                <label className="updatenode__bglabel">中间节点关系:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeCenterLabel}
                  onChange={(evt) => setNodeCenterLabel(evt.target.value)}
                />
              </div>
              <div>
                <label className="updatenode__bglabel">结尾节点关系:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeEndLabel}
                  onChange={(evt) => setNodeEndLabel(evt.target.value)}
                />
              </div> */}
              {/* <div className="updatenode__checkboxwrapper">
            <label>hidden:</label>
            <input
              type="checkbox"
              checked={nodeHidden}
              onChange={(evt) => setNodeHidden(evt.target.checked)}
            />
          </div> */}
            </div>
          </ReactFlow>
          {/* <div style={{ position: "fixed", bottom: 100, right: 100 }}>
            <Button size="large" type="primary" onClick={() => onSave()}>
              保存
            </Button>
          </div> */}
        </>
      )}
    </div>
  );
};

export default () => (
  <ReactFlowProvider>
    <AddNodeOnEdgeDrop />
  </ReactFlowProvider>
);
