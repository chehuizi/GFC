import React, { useEffect, useState } from "react";
import rootRouter from "../router";
import { useNavigate, Outlet, useLocation } from "react-router-dom";
import { MenuFoldOutlined, MenuUnfoldOutlined } from "@ant-design/icons";
import { Layout, Menu, theme, Select } from "antd";
import axios from "../utils/axios";
import "./index.css";

// import React, { useState } from "react";
import {
  AppstoreOutlined,
  MailOutlined,
  SettingOutlined,
} from "@ant-design/icons";
import type { MenuProps, MenuTheme } from "antd";
// import { Menu, Switch } from "antd";

type MenuItem = Required<MenuProps>["items"][number];

function getItem(
  label: React.ReactNode,
  key?: React.Key | null,
  icon?: React.ReactNode,
  children?: MenuItem[],
  type?: "group"
): MenuItem {
  return {
    key,
    icon,
    children,
    label,
    type,
  } as MenuItem;
}

const items: MenuItem[] = [
  getItem("Navigation One", "sub1", <MailOutlined />, [
    getItem("Option 1", "1"),
    getItem("Option 2", "2"),
    getItem("Option 3", "3"),
    getItem("Option 4", "4"),
  ]),

  getItem("Navigation Two", "sub2", <AppstoreOutlined />, [
    getItem("Option 5", "5"),
    getItem("Option 6", "6"),
    getItem("Submenu", "sub3", null, [
      getItem("Option 7", "7"),
      getItem("Option 8", "8"),
    ]),
  ]),

  getItem("Navigation Three", "sub4", <SettingOutlined />, [
    getItem("Option 9", "9"),
    getItem("Option 10", "10"),
    getItem("Option 11", "11"),
    getItem("Option 12", "12"),
  ]),
];

const getPerItem = (item: any) => {
  const { label, key, children = [] } = item;
  return getItem(
    label,
    key,
    <SettingOutlined />,
    children?.length ? children?.map((route: any) => getPerItem(route)) : null
  );
};

const getItmes = (rootRouter: any[]) => {
  return rootRouter
    .find((route) => route.root)
    .children.map((route: any) => getPerItem(route));
};

// const [theme, setTheme] = useState<MenuTheme>("dark");
// const [current, setCurrent] = useState("1");

// const changeTheme = (value: boolean) => {
//   setTheme(value ? "dark" : "light");
// };

// const onClick: MenuProps["onClick"] = (e) => {
//   console.log("click ", e);
//   setCurrent(e.key);
// };

const { Header, Sider, Content } = Layout;

const App: React.FC = () => {
  const { pathname } = useLocation();
  `// 2、存储当前路由地址`;
  const [collapsed, setCollapsed] = useState(false);
  const {
    token: { colorBgContainer },
  } = theme.useToken();
  const navigate = useNavigate();
  const [businesses, setBusinesses] = useState<any[]>([]);
  const [defaultValue, setDefaultValue] = useState<string>("");

  // useEffect(() => {
  //   navigate("/");
  // }, []);

  useEffect(() => {
    axios
      .get("/user/business/detail", { params: { user_id: "100001" } })
      .then((res) => {
        const options = res.data?.userBusinessList || [];
        setBusinesses(options);
        setDefaultValue(options[0]?.businessCode);
      });
  }, []);

  const onChange = () => {
    //
  };

  const [current, setCurrent] = useState("/");

  const onClick: MenuProps["onClick"] = (e) => {
    console.log("click ", e);
    setCurrent(e.key);
    navigate(e.key);
  };

  useEffect(() => {
    navigate(pathname);
    setCurrent(pathname);
  }, [pathname]);

  // debugger;
  // console.log(getItmes(rootRouter));

  return (
    <Layout style={{ width: "100vw", height: "100vh", overflow: "hidden" }}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo">BMF</div>
        {/* <Menu
          theme="dark"
          mode="inline"
          defaultSelectedKeys={["/business/domain"]}
          openKeys={["/business"]}
          onOpenChange={() => {
            //
          }}
          items={getItmes(rootRouter)}
          onClick={({ key }) => {
            navigate(key);
          }}
        /> */}
        <Menu
          theme={"dark"}
          onClick={onClick}
          defaultOpenKeys={["/"]}
          selectedKeys={[current]}
          mode="inline"
          items={getItmes(rootRouter)}
        />
      </Sider>
      <Layout className="site-layout">
        <Header className="header" style={{ background: colorBgContainer }}>
          <div className="trigger" onClick={() => setCollapsed(!collapsed)}>
            {collapsed ? <MenuUnfoldOutlined /> : <MenuFoldOutlined />}
          </div>
          <div style={{ marginLeft: 10 }}>
            <Select
              value={defaultValue}
              defaultActiveFirstOption
              className="business"
              fieldNames={{ label: "businessName", value: "businessCode" }}
              onChange={onChange}
              options={businesses}
              placeholder="请选择"
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
