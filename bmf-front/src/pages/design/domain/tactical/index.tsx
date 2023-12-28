import React from "react";
import { Graph } from "@antv/x6";
import { Dnd } from "@antv/x6-plugin-dnd";
import { Snapline } from "@antv/x6-plugin-snapline";
import Cell from "./components/cell";
import "./index.less";
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

// export default class Example extends React.Component {
//   private container: HTMLDivElement;

//   componentDidMount() {
//     const graph = new Graph({
//       container: this.container,
//       background: {
//         color: "#F2F7FA",
//       },
//       grid: {
//         visible: true,
//         type: "doubleMesh",
//         args: [
//           {
//             color: "#eee", // 主网格线颜色
//             thickness: 1, // 主网格线宽度
//           },
//           {
//             color: "#ddd", // 次网格线颜色
//             thickness: 1, // 次网格线宽度
//             factor: 4, // 主次网格线间隔
//           },
//         ],
//       },
//       panning: true,
//       mousewheel: {
//         enabled: true,
//         modifiers: "Ctrl",
//         maxScale: 4,
//         minScale: 0.2,
//       },
//     });

//     graph.fromJSON(data);
//     graph.centerContent();
//   }

//   refContainer = (container: HTMLDivElement) => {
//     this.container = container;
//   };

//   render() {
//     return (
//       <div className="panning-mousewheel-app">
//         <div style={{ display: "flex", marginBottom: 16 }}>
//           <Select
//             placeholder="请选择领域"
//             options={[{ label: "仓储", value: 1 }]}
//           ></Select>
//           <div className="domain-service" style={{ marginLeft: 10 }}>
//             <Space size={[0, 8]} wrap>
//               <Tag className="domain-service-tag">magenta</Tag>
//               <Tag className="domain-service-tag">red</Tag>
//               <Tag className="domain-service-tag">volcano</Tag>
//             </Space>
//           </div>
//         </div>
//         <div className="base-cell">
//           <Cell />
//           <div className="app-content" ref={this.refContainer} />
//         </div>
//       </div>
//     );
//   }
// }

export default class Example extends React.Component {
  private graph: Graph;
  private container: HTMLDivElement;
  private dndContainer: HTMLDivElement;
  private dnd: Dnd;

  componentDidMount() {
    const graph = new Graph({
      container: this.container,
      background: {
        color: "#F2F7FA",
      },
      mousewheel: {
        enabled: true,
        modifiers: ["ctrl", "meta"],
      },
    });

    graph.use(
      new Snapline({
        enabled: true,
        sharp: true,
      })
    );

    const source = graph.addNode({
      x: 130,
      y: 30,
      width: 100,
      height: 40,
      label: "Hello",
      attrs: {
        body: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
          fill: "#fff",
          rx: 6,
          ry: 6,
        },
      },
    });

    const target = graph.addNode({
      x: 180,
      y: 160,
      width: 100,
      height: 40,
      label: "World",
      attrs: {
        body: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
          fill: "#fff",
          rx: 6,
          ry: 6,
        },
      },
    });

    graph.addEdge({
      source,
      target,
      attrs: {
        line: {
          stroke: "#8f8f8f",
          strokeWidth: 1,
        },
      },
    });
    graph.centerContent();

    this.dnd = new Dnd({
      target: graph,
      scaled: false,
      dndContainer: this.dndContainer,
    });
    this.graph = graph;
  }

  startDrag = (e: React.MouseEvent<HTMLDivElement, MouseEvent>) => {
    const target = e.currentTarget;
    const type = target.getAttribute("data-type");
    const node =
      type === "rect"
        ? this.graph.createNode({
            width: 100,
            height: 40,
            label: "Rect",
            attrs: {
              body: {
                stroke: "#8f8f8f",
                strokeWidth: 1,
                fill: "#fff",
                rx: 6,
                ry: 6,
              },
            },
          })
        : this.graph.createNode({
            width: 60,
            height: 60,
            shape: "circle",
            label: "Circle",
            attrs: {
              body: {
                stroke: "#8f8f8f",
                strokeWidth: 1,
                fill: "#fff",
              },
            },
          });

    this.dnd.start(node, e.nativeEvent as any);
  };

  refContainer = (container: HTMLDivElement) => {
    this.container = container;
  };

  dndContainerRef = (container: HTMLDivElement) => {
    this.dndContainer = container;
  };

  render() {
    return (
      <div className="dnd-app">
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
        <div></div>
        <div className="dnd-wrap" ref={this.dndContainerRef}>
          <div
            data-type="rect"
            className="dnd-rect"
            onMouseDown={this.startDrag}
          >
            Rect
          </div>
          <div
            data-type="circle"
            className="dnd-circle"
            onMouseDown={this.startDrag}
          >
            Circle
          </div>
        </div>
        <div className="app-content" ref={this.refContainer} />
      </div>
    );
  }
}
