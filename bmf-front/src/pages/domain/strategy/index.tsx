import React, { useCallback, useRef, useEffect, useState } from "react";
import ReactFlow, {
  useNodesState,
  useEdgesState,
  addEdge,
  useReactFlow,
  ReactFlowProvider,
} from "reactflow";
import { Button } from "antd";
import axios, { get, post } from "../../../utils/axios";
import "reactflow/dist/style.css";

import "./index.css";

const initialNodes = [
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

const AddNodeOnEdgeDrop = () => {
  const reactFlowWrapper = useRef(null);
  const connectingNodeId = useRef(null);
  const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);
  const [nodeName, setNodeName] = useState("Node 1");
  const [nodeBg, setNodeBg] = useState("#fff");
  const [nodeLabel, setNodeLabel] = useState("");
  const [hasStrategy, setHasStrategy] = useState(false);

  const { project } = useReactFlow();

  useEffect(() => {
    axios.get("/sds").then(() => {
      setHasStrategy(true);
      //
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
        if (node.selected) {
          node.type = "custom";
          if (!node.data) {
            node.data = {};
          }
          node.data.label = nodeLabel;
        }
        return node;
      })
    );
  }, [nodeLabel, setEdges]);

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
    //
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
              <div>
                <label>节点文案:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeName}
                  onChange={(evt) => setNodeName(evt.target.value)}
                />
              </div>
              <div>
                <label className="updatenode__bglabel">节点背景色:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeBg}
                  onChange={(evt) => setNodeBg(evt.target.value)}
                />
              </div>
              <div>
                <label className="updatenode__bglabel">节点关系:</label>
                <input
                  style={{ marginLeft: 10 }}
                  value={nodeLabel}
                  onChange={(evt) => setNodeLabel(evt.target.value)}
                />
              </div>
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
          <div style={{ position: "fixed", bottom: 100, right: 100 }}>
            <Button size="large" type="primary" onClick={() => onSave()}>
              保存
            </Button>
          </div>
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
