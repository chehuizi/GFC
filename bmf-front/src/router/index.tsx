import { RouteObject } from "react-router-dom";
import Login from "../pages/login";
import Layout from "../layout";
import Domain from "../pages/domain";
import Process from "../pages/process";
import Home from "../pages/home";

const rootRouter: RouteObject[] = [
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/",
    element: <Layout />,
    // meta: {
    //   requiresAuth: false,
    //   title: "layout",
    //   key: "layout",
    // },
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/business/industryStandard",
        element: <>行业标准</>,
      },
      {
        path: "/business/domain",
        element: <Domain />,
        // meta: {
        //   requiresAuth: true,
        //   title: "数据可视化",
        //   key: "dataVisualize",
        // },
      },
      {
        path: "/business/process",
        element: <Process />,
        // meta: {
        //   requiresAuth: true,
        //   title: "数据可视化",
        //   key: "dataVisualize",
        // },
      },
    ],
  },
  //   {
  //     path: "*",
  //     element: <Navigate to="/404" />,
  //   },
];

export default rootRouter;
