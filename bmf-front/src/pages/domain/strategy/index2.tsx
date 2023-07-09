import React, { useCallback, useEffect, useState } from "react";
import ReactFlow, {
  useNodesState,
  useEdgesState,
  addEdge,
  MiniMap,
  Controls,
} from "reactflow";
import "reactflow/dist/style.css";
import "./index.css";

const initialNodes = [
  {
    id: "hidden-1",
    data: { label: "Node 1" },
    position: { x: 250, y: 5 },
  },
  {
    id: "hidden-2",
    data: { label: "Node 2" },
    position: { x: 100, y: 100 },
  },
  {
    id: "hidden-3",
    data: { label: "Node 3" },
    position: { x: 400, y: 100 },
  },
  {
    id: "hidden-4",
    data: { label: "Node 4" },
    position: { x: 400, y: 200 },
  },
];

const initialEdges = [
  { source: "hidden-1", target: "hidden-2" },
  { source: "hidden-1", target: "hidden-3" },
  { source: "hidden-3", target: "hidden-4" },
];

const HiddenFlow = () => {
  const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState([]);
  const [hidden, setHidden] = useState(false);

  const onConnect = useCallback(
    (params) => setEdges((els) => addEdge(params, els)),
    []
  );

  useEffect(() => {
    setTimeout(() => {
      setEdges(initialEdges);
    }, 2000);
  }, []);

  return (
    <div style={{ width: "100vw", height: "100vh" }}>
      <ReactFlow
        nodes={nodes}
        edges={edges}
        onNodesChange={onNodesChange}
        onEdgesChange={onEdgesChange}
        onConnect={onConnect}
      >
        <MiniMap />
        <Controls />
      </ReactFlow>
    </div>
  );
};

export default HiddenFlow;
