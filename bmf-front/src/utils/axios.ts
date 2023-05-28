import axios from "axios";
import qs from "qs";

const instance = axios.create({
  timeout: 10000,
  baseURL: "https://some-domain.com/api/",
  // headers: {},
});

instance.interceptors.request.use(
  (config) => {
    if (config.url !== "/login") {
      // 判断请求是否是登录接口，或者判断token是否存在
      // 如果不是登录接口，就给请求头里面设置token
      config.headers.token = localStorage.getItem("token");
    }
    // post请求需要序列化
    if (config.method === "post") {
      config.data = qs.stringify(config.data);
    }
    return config;
  },
  (err) => Promise.reject(err)
);

instance.interceptors.response.use(
  (res) => {
    // 成功时返回数据
    // let code = res.data.code;
    // if (code === 200) {
    //   return res.data;
    // } else if (code === 401) {
    //   // token失效
    //   // router.push("/login"); // 跳转登录页
    // }
    return Promise.resolve(res.data);
  },
  (err) => Promise.reject(err)
);

/* 统一封装get请求 */
export const get = (url, params, config = {}) => {
  return new Promise((resolve, reject) => {
    instance({
      method: "get",
      url,
      params,
      ...config,
    })
      .then((response) => {
        resolve(response);
      })
      .catch((error) => {
        reject(error);
      });
  });
};

/* 统一封装post请求  */
export const post = (url, data, config = {}) => {
  return new Promise((resolve, reject) => {
    instance({
      method: "post",
      url,
      data,
      ...config,
    })
      .then((response) => {
        resolve(response);
      })
      .catch((error) => {
        reject(error);
      });
  });
};

export default instance;
