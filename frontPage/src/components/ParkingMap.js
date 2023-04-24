import React, { useEffect, useState, useRef } from "react";
import GoogleMapReact from "google-map-react";
// import { GoogleMap, Marker } from "react-google-maps";
import SearchForm from "./SearchForm";
import { Content } from "antd/lib/layout/layout";
import { Card, Col, Row, Select, Carousel } from "antd";
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

const { Option } = Select;

const AnyReactComponent = ({ text }) => <div>{text}</div>;

const ParkingMap = (props) => {
  const [click, setClick] = useState();
  const [current, setCurrent] = useState(0);
  const carouselRef = useRef(null);
  const [mode, setMode] = useState([]);
  const [selected, setSelected] = useState(false);

  const styles = {
    transform: selected ? "scale(5)" : "scale(1)",
  };

  const defaultProps =
    props.decodeAddress.length === 0
      ? {
          center: {
            lat: 34.14955,
            lng: -118.14145,
          },
          zoom: 16,
        }
      : {
          center: {
            lat: props.decodeAddress.lat,
            lng: props.decodeAddress.lon,
          },
          zoom: 16,
        };

  var iconParkingSign = {};
  var iconParkingStructure = {};
  var iconParkingMeter = {};
  var largeIconParkingSign = {};
  var largeIconParkingStructure = {};
  var largeIconParkingMeter = {};
  var destinationIcon = {};
  if (props.decodeAddress.length !== 0) {
    iconParkingSign = {
      url: parkingSignIcon,
      scaledSize: new window.google.maps.Size(30, 30),
    };
    iconParkingStructure = {
      url: parkingStructureIcon,
      scaledSize: new window.google.maps.Size(50, 50),
    };
    iconParkingMeter = {
      url: parkingMeterIcon,
      scaledSize: new window.google.maps.Size(30, 30),
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

  function handleMarkerClick(index) {
    setCurrent(index);
    setSelected(true);
    console.log("debug:" + index);
    carouselRef.current.goTo(0);
  }

  function handleBeforeChange(from, to) {
    setCurrent(to);
  }
  const MyMapComponent = withScriptjs(
    withGoogleMap((prop) => (
      <GoogleMap defaultZoom={16} defaultCenter={defaultProps.center}>
        <Marker
          position={defaultProps.center}
          title="destination"
          icon={{
            url: "http://maps.google.com/mapfiles/kml/paddle/D.png",
            scaledSize: new window.google.maps.Size(45, 45),
          }}
        ></Marker>
        {/* prop.isMarkerShown */}
        {mode == "meter" &&
          props.parkingMetersData.map((item) => {
            return (
              <Marker
                key={item.id}
                position={{ lat: item.lat, lng: item.lon }}
                title="parking meters"
                icon={
                  item.id == click // || item.id == current
                    ? largeIconParkingMeter
                    : iconParkingMeter
                }
                // onClick={() => handleMarkerClick(item.id)}
                // style={styles}
              ></Marker>
            );
          })}
        {mode == "structure" &&
          props.parkingStructuresData.map((item) => {
            return (
              <Marker
                key={item.id}
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
        {mode == "sign" &&
          props.parkingSignsData.map((item) => {
            return (
              <Marker
                key={item.id}
                position={{ lat: item.lat, lng: item.lon }}
                title="parking signs"
                icon={item.id == click ? largeIconParkingSign : iconParkingSign}
              ></Marker>
            );
          })}
      </GoogleMap>
    ))
  );

  const contentStyle = {
    margin: 0,
    height: "50%",
    color: "#fff",
    textAlign: "center",
    background: "#364d79",
  };

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

      <div style={{ position: "absolute", top: "25%", left: "52%" }}>
        <Select
          defaultValue="Parking Mode"
          style={{ width: 150 }}
          onSelect={(value) => {
            setMode(value);
          }}
        >
          <Option value="sign">Parking Sign</Option>
          <Option value="structure">Parking Structure</Option>
          <Option value="meter">Parking Meter</Option>
        </Select>
      </div>

      <div
        style={{
          position: "absolute",
          top: "33%",
          left: "52%",
          width: "610px",
          height: "405px",
        }}
      >
        <Carousel ref={carouselRef} beforeChange={handleBeforeChange} draggable>
          {mode == "meter" &&
            props.parkingMetersData.map((item) => {
              const emoji = Array.from(
                { length: item.recommendationIndex },
                () => String.fromCodePoint(0x2b50)
              );
              return (
                <div>
                  <Card
                    key={item.id}
                    title={`Parking Meters #${item.id}`}
                    bordered={false}
                    style={{ backgroundColor: "#aaabee91", height: "400px" }}
                    onClick={() => {
                      setClick(item.id);
                    }}
                  >
                    <p>Recommendation Index: {emoji}</p>
                    <p>Days Of Operation: {item.daysOfOperation}</p>
                    <p>Hourly Rate: {item.hourlyRate}</p>
                    <p>Max Parking Time: {item.maxTime} hr</p>
                    <p>Hours Of Operation: {item.hoursOfOperation}</p>
                    <p>Type Of Meter: {item.typeOfMeter}</p>
                  </Card>
                </div>
              );
            })}
          {mode == "structure" &&
            props.parkingStructuresData.map((item) => {
              const emoji = Array.from(
                { length: item.recommendationIndex },
                () => String.fromCodePoint(0x2b50)
              );
              return (
                <div>
                  <Card
                    key={item.id}
                    title={`Parking Structure #${item.id}`}
                    bordered={false}
                    style={{ backgroundColor: "#aaabee91" }}
                    onClick={() => {
                      setClick(item.id);
                    }}
                  >
                    <p>Recommendation Index: {emoji}</p>
                    <p>Spaces: {item.spaces}</p>
                    <p>Days Of Operation: {item.daysOfOperation}</p>
                    <p>Hourly Rate: {item.hourlyRate}</p>
                    <p>EV Charging: {item.evCharging}</p>
                  </Card>
                </div>
              );
            })}
          {mode == "sign" &&
            props.parkingSignsData.map((item) => {
              const emoji = Array.from(
                { length: item.recommendationIndex },
                () => String.fromCodePoint(0x2b50)
              );
              return (
                <div>
                  <Card
                    key={item.id}
                    title={`Parking Sign #${item.id}`}
                    bordered={false}
                    style={{ backgroundColor: "#aaabee91" }}
                    onClick={() => {
                      setClick(item.id);
                    }}
                  >
                    <p>Recommendation Index: {emoji}</p>
                    <p>Infomation: {item.sign}</p>
                  </Card>
                </div>
              );
            })}
        </Carousel>
      </div>
      {/* below is old card */}
    </div>
  );
};
export default ParkingMap;
