import React, { useEffect, useState } from "react";
import { useNavigate, Outlet } from "react-router-dom";
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  VideoCameraOutlined,
} from "@ant-design/icons";
import { Layout, Menu, theme, Select } from "antd";
import axios from "../utils/axios";
import "./index.css";

const { Header, Sider, Content } = Layout;

const App: React.FC = () => {
  const [collapsed, setCollapsed] = useState(false);
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  const navigate = useNavigate();
  const [businesses, setBusinesses] = useState<any[]>([]);

  useEffect(() => {
    navigate("/business/domain");
  }, []);

  useEffect(() => {
    axios.get("/1212", { params: { userId: "" } }).then((res) => {
      setBusinesses(res.data || []);
    });
  }, []);

  const onChange = () => {
    //
  };

  return (
    <Layout style={{ width: "100vw", height: "100vh", overflow: "hidden" }}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo">BMF</div>
        <Menu
          theme="dark"
          mode="inline"
          defaultSelectedKeys={["/business/domain"]}
          openKeys={["/business"]}
          onOpenChange={() => {
            //
          }}
          items={[
            {
              key: "/business/industryStandard",
              label: "标准",
            },
            {
              key: "/business/process",
              label: "流程",
            },
            {
              key: "/business/domain",
              label: "领域",
            },
          ]}
          onClick={({ key }) => {
            navigate(key);
          }}
        />
      </Sider>
      <Layout className="site-layout">
        <Header className="header" style={{ background: colorBgContainer }}>
          <div className="trigger" onClick={() => setCollapsed(!collapsed)}>
            {collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
          </div>
          <div style={{ marginLeft: 10 }}>
            <Select
              defaultActiveFirstOption
              className="business"
              onChange={onChange}
              options={businesses}
            />
          </div>
        </Header>
        <Content
          className="content"
          style={{
            background: colorBgContainer,
          }}
        >
          <Outlet />
        </Content>
      </Layout>
    </Layout>
  );
};

export default App;
