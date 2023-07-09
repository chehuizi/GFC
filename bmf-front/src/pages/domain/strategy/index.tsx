import React, { useCallback, useRef, useEffect, useState } from "react";
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
import { Button, Form, Input, Select } from "antd";
import RelationEdge from "./relationEdge";
import axios, { get, post } from "../../../utils/axios";
import "reactflow/dist/style.css";

import "./index.css";
import { useForm } from "antd/es/form/Form";

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
  const [nodeName, setNodeName] = useState("Node 1");
  const [nodeBg, setNodeBg] = useState("#fff");
  const [nodeStartLabel, setNodeStartLabel] = useState("");
  const [nodeCenterLabel, setNodeCenterLabel] = useState("");
  const [nodeEndLabel, setNodeEndLabel] = useState("");
  const [hasStrategy, setHasStrategy] = useState(true);
  const [form] = useForm();
  const opiotns = [
    {
      label: "合作伙伴",
      value: "PS",

      //       PS("partnership", "合作伙伴"),
      // SK("shared-Kernel", "共享内核"),
      // UD("upstream-downstream", "上下游"),
      // CS("customer-supplier", "客户/供应商"),
      // KS("kernel-shell", "被包含/包含")
    },
    {
      label: "共享内核",
      value: "SK",
    },
    {
      label: "上下游",
      value: "UD",
    },
    {
      label: "客户/供应商",
      value: "CS",
    },
    {
      label: "被包含/包含",
      value: "KS",
    },
  ];
  const [relationOptions, setRelationOptions] = useState<any[]>(opiotns);

  const { project } = useReactFlow();

  useEffect(() => {
    axios
      .get("/business/detail", {
        params: { business_code: 101, include_all: true },
      })
      .then((res) => {
        res = {
          code: 200,
          data: {
            business: {
              businessAlias: "sharing-bike",
              businessCode: 101,
              businessDesc: "共享单车、电单车",
              businessDomainList: [
                {
                  domainAlias: "ims",
                  domainCode: 101,
                  domainLevel: 3,
                  domainName: "库存域",
                  domainPosition: '{"x": 400, "y": 0}',
                  domainType: "core",
                  extMap: { domainTypeDesc: "核心域" },
                },
                {
                  domainAlias: "wms",
                  domainCode: 102,
                  domainLevel: 3,
                  domainName: "仓库管理域",
                  domainPosition: '{"x": 200, "y": 100}',
                  domainType: "core",
                  extMap: { domainTypeDesc: "核心域" },
                },
                {
                  domainAlias: "tms",
                  domainCode: 103,
                  domainLevel: 3,
                  domainName: "运输管理域",
                  domainPosition: '{"x": 500, "y": 100}',
                  domainType: "core",
                  extMap: { domainTypeDesc: "核心域" },
                },
                {
                  domainAlias: "ofc",
                  domainCode: 104,
                  domainLevel: 3,
                  domainName: "履约域",
                  domainPosition: '{"x": 400, "y": 300}',
                  domainType: "core",
                  extMap: { domainTypeDesc: "核心域" },
                },
              ],
              businessDomainRelationList: [
                {
                  businessCode: 101,
                  domainACode: 101,
                  domainARole: "OHS",
                  domainBCode: 102,
                  domainBRole: "CF",
                  domainRelation: "upstream-downstream",
                  extMap: {
                    domainARoleDesc: "开放主机服务",
                    domainRelationDesc: "上下游",
                    domainBRoleDesc: "遵从者",
                  },
                },
                {
                  businessCode: 101,
                  domainACode: 101,
                  domainARole: "OHS",
                  domainBCode: 103,
                  domainBRole: "CF",
                  domainRelation: "upstream-downstream",
                  extMap: {
                    domainARoleDesc: "开放主机服务",
                    domainRelationDesc: "上下游",
                    domainBRoleDesc: "遵从者",
                  },
                },
                {
                  businessCode: 101,
                  domainACode: 101,
                  domainARole: "OHS",
                  domainBCode: 104,
                  domainBRole: "CF",
                  domainRelation: "upstream-downstream",
                  extMap: {
                    domainARoleDesc: "开放主机服务",
                    domainRelationDesc: "上下游",
                    domainBRoleDesc: "遵从者",
                  },
                },
                {
                  businessCode: 101,
                  domainACode: 102,
                  domainARole: "partner",
                  domainBCode: 103,
                  domainBRole: "partner",
                  domainRelation: "partnership",
                  extMap: {
                    domainARoleDesc: "合作伙伴",
                    domainRelationDesc: "合作伙伴",
                    domainBRoleDesc: "合作伙伴",
                  },
                },
                {
                  businessCode: 101,
                  domainACode: 102,
                  domainARole: "partner",
                  domainBCode: 104,
                  domainBRole: "partner",
                  domainRelation: "partnership",
                  extMap: {
                    domainARoleDesc: "合作伙伴",
                    domainRelationDesc: "合作伙伴",
                    domainBRoleDesc: "合作伙伴",
                  },
                },
                {
                  businessCode: 101,
                  domainACode: 103,
                  domainARole: "partner",
                  domainBCode: 104,
                  domainBRole: "partner",
                  domainRelation: "partnership",
                  extMap: {
                    domainARoleDesc: "合作伙伴",
                    domainRelationDesc: "合作伙伴",
                    domainBRoleDesc: "合作伙伴",
                  },
                },
              ],
              businessName: "共享两轮业务",
              businessPrefix: "B",
            },
            pageIndex: 0,
            pageSize: 0,
            total: 0,
          },
          msg: "成功",
        };
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
            label: nodeName,
          };
        }
        return node;
      });
    });
  }, [nodeName, setNodes]);

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
        debugger;
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
              node.data.domainARole = nodeStartLabel;
              node.data.domainRelation = nodeCenterLabel;
              node.data.domainBRole = nodeEndLabel;
            }
            return node;
          })
        )
      )
    );
  }, [nodeStartLabel, nodeCenterLabel, nodeEndLabel, setEdges]);

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
        return {
          domainCode: id,
          domainName: data.label,
          ...extInfo,
          domainPosition: JSON.stringify(position),
        };
      }),
      // relationshipList: edges.map((node: any) => {
      //   const { source, target, data = {} } = node;
      //   const { domainRelation, domainARole, domainBRole } = data;
      //   return {
      //     domainRelation,
      //     domainARole,
      //     domainBRole,
      //     domainACode: source,
      //     domainBCode: target,
      //     businessCode: "",
      //   };
      // }),
    };
    axios
      .post("/business/strategy/design/save", params)
      .then((res) => {
        //
      })
      .catch((error) => {
        //
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
              <Form form={form}>
                <Form.Item label="节点文案" name="domainName">
                  <Input
                    style={{ marginLeft: 10 }}
                    value={nodeName}
                    onChange={(evt) => setNodeName(evt.target.value)}
                  />
                </Form.Item>
                <Form.Item label="节点背景色" name="nodeBg">
                  <Input
                    style={{ marginLeft: 10 }}
                    value={nodeBg}
                    onChange={(evt) => setNodeBg(evt.target.value)}
                  />
                </Form.Item>
                {/* <Form.Item label="上下游关系" name="domainRelation">
                  <Select
                    options={relationOptions}
                    style={{ marginLeft: 10 }}
                    // onChange={(evt) => setNodeBg(evt.target.value)}
                  />
                </Form.Item> */}
                <Form.Item label="关系A" name="domainRelationA">
                  <Select
                    style={{ marginLeft: 10 }}
                    options={relationOptions}
                    onChange={(value) => setNodeStartLabel(value)}
                  />
                </Form.Item>
                <Form.Item label="关系B" name="domainRelation">
                  <Select
                    style={{ marginLeft: 10 }}
                    options={relationOptions}
                    onChange={(value) => setNodeCenterLabel(value)}
                  />
                </Form.Item>
                <Form.Item label="关系C" name="domainRelationB">
                  <Select
                    style={{ marginLeft: 10 }}
                    options={relationOptions}
                    onChange={(value) => setNodeEndLabel(value)}
                  />
                </Form.Item>
                <Form.Item>
                  <Button type="primary" onClick={onSave}>
                    保存
                  </Button>
                </Form.Item>
              </Form>
              {/* <div>
                <label>节点文案:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeName}
                  onChange={(evt) => setNodeName(evt.target.value)}
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
