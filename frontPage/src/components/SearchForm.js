import {
  Layout,
  Typography,
  Space,
  Row,
  Input,
  Button,
  TimePicker,
  DatePicker,
  Col,
  Form,
  message,
  Select,
} from "antd";
import { CarFilled, CalendarFilled } from "@ant-design/icons";
import { useState } from "react";
import moment from "moment";
import {
  getDecodeAddress,
  getParkingMetersResult,
  getParkingSignsResult,
  getParkingStructuresResult,
} from "../utils";
import ParkingMap from "./ParkingMap";
import TrafficMap from "./TrafficMap";
const { Option } = Select;
const SearchForm = () => {
  const [select, setSelect] = useState([]);
  const [loading, setLoading] = useState(false);
  const [parkingMeters, setParkingMeters] = useState([]);
  const [parkingStructures, setParkingStructures] = useState([]);
  const [parkingSigns, setParkingSigns] = useState([]);
  const [decodeAddress, setDecodeAddress] = useState([]);
  const dataset = {
    parkingMetersData: parkingMeters,
    parkingStructuresData: parkingStructures,
    parkingSignsData: parkingSigns,
    decodeAddress: decodeAddress,
  };
  const onChange = (date, dateString) => {
    console.log(date, dateString);
  };
  const onFinish = (values) => {
    setLoading(true);
    // console.log(values);
    getParkingMetersResult(values)
      .then((data) => {
        setParkingMeters(data);
        // message.success("Search Successfully");
      })
      .catch((err) => message.error(err.message))
      .finally(setLoading(false));
    getParkingSignsResult(values)
      .then((data) => {
        setParkingSigns(data);
        // message.success("Search Successfully");
      })
      .catch((err) => message.error(err.message))
      .finally(setLoading(false));
    getParkingStructuresResult(values)
      .then((data) => {
        setParkingStructures(data);
        // message.success("Search Successfully");
      })
      .catch((err) => message.error(err.message))
      .finally(setLoading(false));
    getDecodeAddress(values)
      .then((data) => {
        setDecodeAddress(data);
        // message.success("Search Successfully");
      })
      .catch((err) => message.error(err.message))
      .finally(setLoading(false));
  };
  return (
    <>
      <div style={{ display: "flex", justifyContent: "center" }}>
        <Space.Compact
          style={{
            width: "100%",
            position: "relative",
            bottom: "10%",
            left: "10%",
          }}
        >
          {/* <Row gutter={28}> */}
          <Form
            layout="inline"
            style={{ left: "25%", position: "absolute" }}
            initialValues={{
              remember: true,
            }}
            onFinish={onFinish}
          >
            <Form.Item name="address">
              <Input
                placeholder="Where to?"
                prefix={<CarFilled />}
                style={{
                  width: "112%",
                }}
              />
            </Form.Item>
            <Form.Item name="date">
              <DatePicker
                onChange={onChange}
                style={{
                  width: "112%",
                }}
                suffixIcon={<div></div>}
                disabledDate={(current) =>
                  current.isBefore(moment().subtract(1, "day"))
                }
              />
            </Form.Item>
            <Form.Item name="time">
              <TimePicker
                onChange={onChange}
                format="HH:mm"
                defaultValue={moment("00:00", "HH:mm")}
                minuteStep={30}
                suffixIcon={<div></div>}
                style={{
                  width: "112%",
                }}
              />
            </Form.Item>
            {/* </Col> */}
            {/* <Col span={8}> */}
            <Form.Item>
              <Button type="primary" htmlType="submit" loading={loading}>
                Search
              </Button>
            </Form.Item>
            {/* </Col> */}
          </Form>
          {/* </Row> */}
        </Space.Compact>
      </div>
      <div>
        <div>
          <div>
            <div>
              <Select
                defaultValue="ParkingMap"
                style={{ width: 120 }}
                onSelect={(value) => {
                  setSelect(value);
                }}
              >
                <Option value="parking">ParkingMap</Option>
                <Option value="traffic">TrafficMap</Option>
              </Select>
              {select === "traffic" ? (
                <TrafficMap {...decodeAddress} />
              ) : (
                <ParkingMap {...dataset} />
              )}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};
export default SearchForm;
