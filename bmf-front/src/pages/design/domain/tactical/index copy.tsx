import React from "react";
import { Graph } from "@antv/x6";

import Cell from "./components/cell";
import "./index.css";
import { Select, Space, Tag } from "antd";

const data = {
  nodes: [
    {
      id: "node1",
      shape: "rect",
      x: 40,
      y: 40,
      width: 100,
      height: 40,
      label: "hello",
      attrs: {
        body: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
          fill: "#fff",
          rx: 6,
          ry: 6,
        },
      },
    },
    {
      id: "node2",
      shape: "rect",
      x: 160,
      y: 180,
      width: 100,
      height: 40,
      label: "world",
      attrs: {
        body: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
          fill: "#fff",
          rx: 6,
          ry: 6,
        },
      },
    },
  ],
  edges: [
    {
      shape: "edge",
      source: "node1",
      target: "node2",
      label: "x6",
      attrs: {
        line: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
        },
      },
    },
  ],
};

export default class Example extends React.Component {
  private container: HTMLDivElement;

  componentDidMount() {
    const graph = new Graph({
      container: this.container,
      background: {
        color: "#F2F7FA",
      },
      grid: {
        visible: true,
        type: "doubleMesh",
        args: [
          {
            color: "#eee", // 主网格线颜色
            thickness: 1, // 主网格线宽度
          },
          {
            color: "#ddd", // 次网格线颜色
            thickness: 1, // 次网格线宽度
            factor: 4, // 主次网格线间隔
          },
        ],
      },
      panning: true,
      mousewheel: {
        enabled: true,
        modifiers: "Ctrl",
        maxScale: 4,
        minScale: 0.2,
      },
    });

    graph.fromJSON(data);
    graph.centerContent();
  }

  refContainer = (container: HTMLDivElement) => {
    this.container = container;
  };

  render() {
    return (
      <div className="panning-mousewheel-app">
        <div style={{ display: "flex", marginBottom: 16 }}>
          <Select
            placeholder="请选择领域"
            options={[{ label: "仓储", value: 1 }]}
          ></Select>
          <div className="domain-service" style={{ marginLeft: 10 }}>
            <Space size={[0, 8]} wrap>
              <Tag className="domain-service-tag">magenta</Tag>
              <Tag className="domain-service-tag">red</Tag>
              <Tag className="domain-service-tag">volcano</Tag>
            </Space>
          </div>
        </div>
        <div className="base-cell">
          <Cell />
          <div className="app-content" ref={this.refContainer} />
        </div>
      </div>
    );
  }
}
