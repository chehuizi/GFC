import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import React from "react";
import { AndroidOutlined, MailOutlined } from "@ant-design/icons";
import { Tabs } from "antd";

const Domain: React.FC = () => (
  <Tabs
    defaultActiveKey="1"
    items={[
      {
        label: "领域 1",
        key: "1",
        children: "领域 1",
      },
      {
        label: "领域 2",
        key: "2",
        children: "领域 2",
      },
      {
        label: "领域 3",
        key: "3",
        children: "领域 3",
      },
    ]}
  />
);

export default Domain;
