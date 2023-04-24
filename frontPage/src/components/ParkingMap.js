import React, { useEffect, useState } from "react";
import GoogleMapReact from "google-map-react";
// import { GoogleMap, Marker } from "react-google-maps";
import SearchForm from "./SearchForm";
import { Content } from "antd/lib/layout/layout";
import { Card, Col, Row } from "antd";
// import { compose, withProps } from "recompose";
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker,
} from "react-google-maps";
import parkingSignIcon from "../assets/parking-sign-13347.svg";
import parkingStructureIcon from "../assets/car-parking-location-red-placeholder-15952.svg";
import parkingMeterIcon from "../assets/parking-meter-svgrepo-com.svg";
const AnyReactComponent = ({ text }) => <div>{text}</div>;

const ParkingMap = (props) => {
  const [click, setClick] = useState();
  const [mode, setMode] = useState([]);
  const defaultProps =
    props.decodeAddress.length === 0
      ? {
          center: {
            lat: 34.14955,
            lng: -118.14145,
          },
          zoom: 15,
        }
      : {
          center: {
            lat: props.decodeAddress.lat,
            lng: props.decodeAddress.lon,
          },
          zoom: 15,
        };
  var iconParkingSign = {};
  var iconParkingStructure = {};
  var iconParkingMeter = {};
  var largeIconParkingSign = {};
  var largeIconParkingStructure = {};
  var largeIconParkingMeter = {};
  if (props.decodeAddress.length !== 0) {
    iconParkingSign = {
      url: parkingSignIcon,
      scaledSize: new window.google.maps.Size(20, 20),
    };
    iconParkingStructure = {
      url: parkingStructureIcon,
      scaledSize: new window.google.maps.Size(50, 50),
    };
    iconParkingMeter = {
      url: parkingMeterIcon,
      scaledSize: new window.google.maps.Size(20, 20),
    };
    largeIconParkingSign = {
      url: parkingSignIcon,
      scaledSize: new window.google.maps.Size(50, 50),
    };
    largeIconParkingStructure = {
      url: parkingStructureIcon,
      scaledSize: new window.google.maps.Size(100, 100),
    };
    largeIconParkingMeter = {
      url: parkingMeterIcon,
      scaledSize: new window.google.maps.Size(50, 50),
    };
  }
  const MyMapComponent = withScriptjs(
    withGoogleMap((prop) => (
      <GoogleMap defaultZoom={16} defaultCenter={defaultProps.center}>
        <Marker
          position={defaultProps.center}
          title="destination"
          icon="http://maps.google.com/mapfiles/kml/paddle/D.png"
        ></Marker>
        {prop.isMarkerShown &&
          props.parkingMetersData.map((item) => {
            return (
              <Marker
                position={{ lat: item.lat, lng: item.lon }}
                title="parking meters"
                icon={
                  item.id == click ? largeIconParkingMeter : iconParkingMeter
                }
              ></Marker>
            );
          })}
        {prop.isMarkerShown &&
          props.parkingStructuresData.map((item) => {
            return (
              <Marker
                position={{ lat: item.lat, lng: item.lon }}
                title="parking structures"
                icon={
                  item.id == click
                    ? largeIconParkingStructure
                    : iconParkingStructure
                }
              ></Marker>
            );
          })}
        {prop.isMarkerShown &&
          props.parkingSignsData.map((item) => {
            return (
              <Marker
                position={{ lat: item.lat, lng: item.lon }}
                title="parking signs"
                icon={item.id == click ? largeIconParkingSign : iconParkingSign}
              ></Marker>
            );
          })}
      </GoogleMap>
    ))
  );
  return (
    // Important! Always set the container height explicitly
    <div
      style={{
        display: "flex",
        justifyContent: "space-between",
      }}
    >
      <div
        style={{
          height: "100%",
          width: "50%",
          position: "absolute",
          top: "25%",
          paddingLeft: "5%",
        }}
      >
        <MyMapComponent
          isMarkerShown
          googleMapURL="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoPd7y5p3N7p4jKuh0qQdef5gLA41qVGE"
          loadingElement={<div style={{ height: `100%` }} />}
          containerElement={<div style={{ height: `60%` }} />}
          mapElement={<div style={{ height: `100%` }} />}
        />
      </div>

      {/* below is new drop down+carousel card */}
      {/* <div>
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
      </div> */}

      {/* below is old card */}
      <div
        style={{
          height: "60%",
          width: "50%",
          position: "absolute",
          top: "25%",
          left: "50%",
          paddingRight: "5%",
          overflow: "scroll",
        }}
      >
        <Row gutter={16}>
          <Col span={8}>
            {props.parkingMetersData.map((item) => {
              return (

                <div
                  onClick={() => {
                    setClick(item.id);
                  }}
                >
                  <Card
                    title={`Parking Meters #${item.id}`}
                    bordered={false}
                  >
                    <p>recommendationIndex: {item.recommendationIndex}</p>
                    <p>daysOfOperation: {item.daysOfOperation}</p>
                    <p>hourlyRate: {item.hourlyRate}</p>
                    <p>maxTime: {item.maxTime}</p>
                    <p>hoursOfOperation: {item.hoursOfOperation}</p>
                    <p>typeOfMeter: {item.typeOfMeter}</p>
                  </Card>
                </div>
              );
            })}
          </Col>
          <Col span={8}>
            {props.parkingStructuresData.map((item) => {
              return (
                // <Col span={8}>
                <div
                  onClick={() => {
                    setClick(item.id);
                  }}
                >
                  <Card
                    title={`Parking Structures #${item.id}`}
                    // bordered={false}
                    // style={{
                    //   width: 300,
                    // }}
                  >
                    <p>recommendationIndex: {item.recommendationIndex}</p>
                    <p>spaces: {item.spaces}</p>
                    <p>daysOfOperation: {item.daysOfOperation}</p>
                    <p>hourlyRate: {item.hourlyRate}</p>
                    <p>evCharging: {item.evCharging}</p>
                  </Card>
                </div>
                // </Col>
              );
            })}
          </Col>
          <Col span={8}>
            {props.parkingSignsData.map((item) => {
              return (
                // <Col span={8}>
                <div
                  onClick={() => {
                    setClick(item.id);
                  }}
                >
                  <Card
                    title={`Parking Signs #${item.id}`}
                    // bordered={false}
                    // style={{
                    //   width: 300,
                    // }}
                  >
                    <p>spaces: {item.sign}</p>
                    {/* <p>daysOfOperation: {item.daysOfOperation}</p>
                  <p>hourlyRate: {item.hourlyRate}</p>
                  <p>evCharging: {item.evCharging}</p> */}
                  </Card>
                </div>
                // </Col>
              );
            })}
          </Col>
        </Row>
      </div>
    </div>
  );
};
export default ParkingMap;
