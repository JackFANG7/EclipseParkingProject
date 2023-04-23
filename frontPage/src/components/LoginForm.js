import React, { useState, useEffect } from "react";
import { Button, Form, Input, message, Modal } from "antd";
import { LockOutlined, UserOutlined } from "@ant-design/icons";

const LoginForm = () => {
  const [display, setDisplay] = useState(false);

  const loginOnClick = () => {
    setDisplay(true);
  };

  const handleCancel = () => {
    setDisplay(false);
  };

  const onFinish = (data) => {};

  return (
    <>
      <Button type="text" onClick={loginOnClick}>
        <div style={{ color: "white" }}>Log In</div>
      </Button>
      <Modal
        title="Sign In for Eclipse Parking"
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
          <Form.Item>
            <Button type="primary" htmlType="submit">
              Sign In
            </Button>
          </Form.Item>
        </Form>
      </Modal>
    </>
  );
};

export default LoginForm;
