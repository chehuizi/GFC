import { RouteObject } from "react-router-dom";
import Login from "../pages/login";
import Layout from "../layout";
import Business from "../pages/design/business";
import Domain from "../pages/design/domain";
import Process from "../pages/process";
import Maintenance from "../pages/maintenance";
import Home from "../pages/home";

type RouteItemObj = RouteObject & { root?: boolean; label?: string };

const rootRouter: Array<Object> = [
  {
    // label: "登录",
    path: "/login",
    element: <Login />,
  },
  {
    label: "根",
    path: "/",
    element: <Layout />,
    root: true,
    // meta: {
    //   requiresAuth: false,
    //   title: "layout",
    //   key: "layout",
    // },
    children: [
      {
        key: "/",
        label: "首页",
        path: "/",
        element: <Home />,
      },
      {
        key: "/design",
        label: "设计",
        path: "/design",
        children: [
          {
            label: "业务设计",
            key: "/design/business",
            path: "/design/business",
            element: <Business />,
          },
          {
            label: "领域设计",
            key: "/design/domain",
            path: "/design/domain",
            element: <Domain />,
          },
        ],
      },
      {
        label: "开发",
        path: "/dev",
        key: "/dev",
        element: <>标准</>,
      },
      {
        label: "维护",
        path: "/maintenance",
        key: "/maintenance",
        element: <Maintenance />,
        // meta: {
        //   requiresAuth: true,
        //   title: "数据可视化",
        //   key: "dataVisualize",
        // },
      },
      // {
      //   path: "/business/process",
      //   element: <Process />,
      //   // meta: {
      //   //   requiresAuth: true,
      //   //   title: "数据可视化",
      //   //   key: "dataVisualize",
      //   // },
      // },
    ],
  },
  //   {
  //     path: "*",
  //     element: <Navigate to="/404" />,
  //   },
];

export default rootRouter;
