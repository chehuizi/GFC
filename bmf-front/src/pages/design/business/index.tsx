import { useState } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import React from "react";
import { AndroidOutlined, MailOutlined } from "@ant-design/icons";
import { Tabs } from "antd";

const Domain: React.FC = () => {
  const onChange = (key: string) => {
    console.log(key);
  };

  return (
    <Tabs
      onChange={onChange}
      defaultActiveKey="0"
      items={[
        {
          label: "业务场景管理",
          key: "0",
          children: <>业务场景管理</>,
        },
        {
          label: "业务角色管理",
          key: "1",
          children: <>业务角色管理</>,
        },
        {
          label: "业务流程管理",
          key: "2",
          children: <>业务流程管理</>,
        },
        {
          label: "业务规则管理",
          key: "3",
          children: <>业务规则管理</>,
        },
      ]}
    />
  );
};

export default Domain;
