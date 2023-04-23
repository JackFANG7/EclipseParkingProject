import React, { useState, useEffect } from "react";
import { Select, Button, Form, Input, message, Modal } from "antd";
import {
  LockOutlined,
  UserOutlined,
  DownOutlined,
  PoweroffOutlined,
  DashboardOutlined,
} from "@ant-design/icons";

const { Option } = Select;

const SignupForm = () => {
  const [display, setDisplay] = useState(false);

  const signupOnClick = () => {
    setDisplay(true);
  };

  const handleCancel = () => {
    setDisplay(false);
  };

  const onFinish = (data) => {
    console.log(data);
  };

  const onChange = (value) => {
    console.log(`selected ${value}`);
  };
  const onSearch = (value) => {
    console.log("search:", value);
  };

  return (
    <>
      <Button
        shape="round"
        ghost
        type="primary"
        onClick={signupOnClick}
        style={{ backgroundColor: "white", borderColor: "#605DE4" }}
      >
        Sign Up
      </Button>
      <Modal
        title="Sign up for Eclipse Parking"
        open={display}
        onCancel={handleCancel}
        footer={null}
        destroyOnClose={true}
      >
        <Form
          name="normal_register"
          initialValues={{ remember: true }}
          onFinish={onFinish}
          preserve={false}
        >
          <Form.Item
            name="Email"
            rule={[{ required: true, message: "Please input your email!" }]}
          >
            <Input prefix={<UserOutlined />} placeholder="email"></Input>
          </Form.Item>
          <Form.Item
            name="Password"
            rules={[{ required: true, message: "Please input your password!" }]}
          >
            <Input prefix={<LockOutlined />} placeholder="password" />
          </Form.Item>
          <Form.Item name="Car Type" rules={[{ required: true }]}>
            <Select
              showSearch
              placeholder="Select Your Car Type"
              optionFilterProp="children"
              onChange={onChange}
              onSearch={onSearch}
              filterOption={(input, option) =>
                (option?.label ?? "")
                  .toLowerCase()
                  .includes(input.toLowerCase())
              }
              options={[
                {
                  value: "Electronic",
                  label: "Electronic",
                },
                {
                  value: "Non-Electric",
                  label: "Non-Electric",
                },
                {
                  value: "Hybrid",
                  label: "Hybrid",
                },
              ]}
            />
          </Form.Item>

          <Form.Item>
            <Button type="primary" htmlType="submit">
              Sign Up
            </Button>
          </Form.Item>
        </Form>
      </Modal>
    </>
  );
};
export default SignupForm;
