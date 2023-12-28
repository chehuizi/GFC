import React, { FC } from "react";
import { EdgeProps, getBezierPath, EdgeLabelRenderer } from "reactflow";

// this is a little helper component to render the actual edge label
function EdgeLabel({ transform, label }: { transform: string; label: string }) {
  return (
    <div
      style={{
        position: "absolute",
        background: "transparent",
        padding: 10,
        color: "#ff5050",
        fontSize: 12,
        fontWeight: 700,
        transform,
      }}
      className="nodrag nopan"
    >
      {label}
    </div>
  );
}

const CustomEdge: FC<EdgeProps> = ({
  id,
  sourceX,
  sourceY,
  targetX,
  targetY,
  sourcePosition,
  targetPosition,
  data,
}) => {
  const [edgePath] = getBezierPath({
    sourceX,
    sourceY,
    sourcePosition,
    targetX,
    targetY,
    targetPosition,
  });

  return (
    <>
      <path id={id} className="react-flow__edge-path" d={edgePath} />
      <EdgeLabelRenderer>
        {data.domainARole && (
          <EdgeLabel
            transform={`translate(-50%, 0%) translate(${sourceX}px,${sourceY}px)`}
            label={data.domainARole}
          />
        )}
        {data.domainRelation && (
          <EdgeLabel
            transform={`translate(-50%, 0%) translate(${
              (sourceX + targetX) / 2
            }px,${(sourceY + targetY) / 2}px)`}
            label={data.domainRelation}
          />
        )}
        {data.domainBRole && (
          <EdgeLabel
            transform={`translate(-50%, -100%) translate(${targetX}px,${targetY}px)`}
            label={data.domainBRole}
          />
        )}
      </EdgeLabelRenderer>
    </>
  );
};

export default CustomEdge;
