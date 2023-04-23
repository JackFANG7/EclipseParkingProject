import React from "react";
import GoogleMapReact from "google-map-react";
import SearchForm from "./SearchForm";
import { Content } from "antd/lib/layout/layout";
import { Card } from "antd";

const AnyReactComponent = ({ text }) => <div>{text}</div>;

const ListParking = (props) => {
  return (
    // Important! Always set the container height explicitly
    <div>
      {props.parkingMetersData.map((item) => {
        return (
          <Card
            title={item.id}
            bordered={false}
            style={{
              width: 300,
            }}
          >
            <p>daysOfOperation: {item.daysOfOperation}</p>
            <p>hourlyRate: {item.hourlyRate}</p>
            <p>maxTime: {item.maxTime}</p>
            <p>hoursOfOperation: {item.hoursOfOperation}</p>
            <p>typeOfMeter: {item.typeOfMeter}</p>
          </Card>
        );
      })}
    </div>
  );
};
export default ListParking;
