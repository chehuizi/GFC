import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    proxy: {
      "/api": {
        target: "http://120.46.150.249:8080", //替换的服务端地址
        changeOrigin: true, //开启代理，允许跨域
        rewrite: (path) => path.replace(/^\/api/, ""), //设置重写的路径
      },
    },
  },
});
