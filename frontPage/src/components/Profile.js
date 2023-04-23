import React, { useState, useEffect } from "react";
import { UserOutlined } from "@ant-design/icons";
import { Typography, Button, Drawer, message, List } from "antd";

const Profile = () => {
  const [profileVisible, setProfileVisible] = useState(false);

  const onOpenProfile = () => {
    setProfileVisible(true);
  };

  return (
    <>
      <Button
        type="primary"
        shape="circle"
        size="large"
        style={{ backgroundColor: "transparent" }}
        onClick={onOpenProfile}
        icon={<UserOutlined />}
      ></Button>
      <Drawer></Drawer>
    </>
  );
};
export default Profile;
