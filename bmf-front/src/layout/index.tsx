import React, { useEffect, useState } from "react";
import { useNavigate, Outlet } from "react-router-dom";
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  VideoCameraOutlined,
} from "@ant-design/icons";
import { Layout, Menu, theme, Select } from "antd";
import "./index.css";

const { Header, Sider, Content } = Layout;

const App: React.FC = () => {
  const [collapsed, setCollapsed] = useState(false);
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  const navigate = useNavigate();

  useEffect(() => {
    navigate("/business/domain");
  }, []);

  const onChange = () => {
    //
  };

  return (
    <Layout style={{ width: "100vw", height: "100vh" }}>
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
              key: "/business",
              label: "business",
              children: [
                {
                  key: "/business/industryStandard",
                  label: "行业标准",
                },
                {
                  key: "/business/process",
                  label: "流程",
                },
                {
                  key: "/business/domain",
                  label: "领域",
                },
              ],
            },
          ]}
          onClick={({ key }) => {
            navigate(key);
          }}
        />
      </Sider>
      <Layout className="site-layout">
        <Header className="header" style={{ background: colorBgContainer }}>
          {/* <div className="trigger" onClick={() => setCollapsed(!collapsed)}>
            {collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
          </div> */}
          {/* business： */}
          <Select
            className="business"
            defaultValue="business"
            onChange={onChange}
            options={[
              { value: "business", label: "business" },
              { value: "business1", label: "business2" },
            ]}
          />
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
