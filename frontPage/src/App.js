import {
  Layout,
  Typography,
  Select,
  Space,
  Row,
  Input,
  Button,
  TimePicker,
  DatePicker,
  Col,
  Form,
} from "antd";
import { CarFilled, CalendarFilled } from "@ant-design/icons";
import LoginForm from "./components/LoginForm";
import SignupForm from "./components/SignupForm";
import Profile from "./components/Profile";
import { useState } from "react";
import SearchForm from "./components/SearchForm";
import Face from "./components/Face";
const { Header, Content, Footer } = Layout;
const { Title } = Typography;

const App = () => {
  const [authed, setAuthed] = useState(false);
  const [searched, setSearched] = useState(false);
  return (
    <Layout style={{ height: "100vh" }}>
      <Header style={{ background: "#605DE4", height: "70px" }}>
        <div
          className="header"
          style={{ display: "flex", justifyContent: "space-between" }}
        >
          <Title
            level={2}
            style={{ color: "white", lineHeight: "inherit", marginBottom: 0 }}
          >
            Eclipse Parking
          </Title>
          <div
            style={{
              display: "flex",
              justifyContent: "space-between",
              width: "180px",
            }}
          >
            <div>{authed ? null : <LoginForm />}</div>
            <div>{authed ? <Profile /> : <SignupForm />}</div>
          </div>
        </div>
      </Header>
      <Content className="site-layout">
        {searched ? (
          <div>
            <SearchForm />
          </div>
        ) : (
          <div
            onClick={() => {
              setSearched(true);
            }}
          >
            <Face />
          </div>
        )}
      </Content>
      <Footer
        style={{
          textAlign: "center",
        }}
      >
        Eclipse Smart Parking ©2023 Created by Eclipse
      </Footer>
    </Layout>
  );
};
export default App;
