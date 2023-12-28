import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import React from "react";
import { AndroidOutlined, MailOutlined } from "@ant-design/icons";
import { Tabs } from "antd";
import Strategy from "./strategy";
import Tactical from "./tactical";

const Domain: React.FC = () => (
  <Tabs
    defaultActiveKey="1"
    items={[
      {
        label: "战略设计",
        key: "1",
        children: (
          <>
            <Strategy />
          </>
        ),
      },
      {
        label: "战术设计",
        key: "2",
        children: (
          <>
            <Tactical />
          </>
        ),
      },
      // {
      //   label: "应用 2",
      //   key: "2",
      //   children: "领域 2",
      // },
      // {
      //   label: "领域 3",
      //   key: "3",
      //   children: "领域 3",
      // },
    ]}
  />
);

export default Domain;
