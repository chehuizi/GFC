import React from "react";
import { Graph } from "@antv/x6";
import "./index.css";

const commonAttrs = {
  body: {
    fill: "#fff",
    stroke: "#8f8f8f",
    strokeWidth: 1,
  },
  label: {
    refX: 0.5,
    refY: "100%",
    refY2: 4,
    textAnchor: "middle",
    textVerticalAnchor: "top",
  },
};

export default class Example extends React.Component {
  private container: HTMLDivElement;

  componentDidMount() {
    const graph = new Graph({
      container: this.container,
      background: {
        color: "#F2F7FA",
      },
    });

    graph.addNode({
      shape: "rect",
      x: 40,
      y: 40,
      width: 80,
      height: 40,
      label: "rect",
      attrs: commonAttrs,
    });

    graph.addNode({
      shape: "circle",
      x: 0,
      y: 130,
      width: 160,
      height: 50,
      label: "circle",
      attrs: commonAttrs,
    });

    graph.addNode({
      shape: "rect",
      x: 40,
      y: 230,
      width: 80,
      height: 40,
      label: "rect",
      attrs: commonAttrs,
    });

    graph.addNode({
      shape: "ellipse",
      x: 40,
      y: 330,
      width: 80,
      height: 40,
      label: "ellipse",
      attrs: commonAttrs,
    });
  }

  refContainer = (container: HTMLDivElement) => {
    this.container = container;
  };

  render() {
    return (
      <div className="shapes-app">
        <div className="app-content" ref={this.refContainer} />
      </div>
    );
  }
}
