import { BrowserRouter, useRoutes } from "react-router-dom";
import rootRouter from "./router";

import "./App.css";

function App() {
  const Router = () => useRoutes(rootRouter);
  return (
    <BrowserRouter>
      <Router />
    </BrowserRouter>
  );
}

export default App;
