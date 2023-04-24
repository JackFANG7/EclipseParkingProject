import React from "react";
import GoogleMapReact from "google-map-react";
import SearchForm from "./SearchForm";
import {
  withScriptjs,
  withGoogleMap,
  GoogleMap,
  Marker,
  TrafficLayer,
} from "react-google-maps";

export default function TrafficMap(props) {
  {
    console.log(Object.keys(props).length === 0);
  }
  const defaultProps =
    Object.keys(props).length !== 0
      ? {
          center: {
            lat: props.lat,
            lng: props.lon,
          },
          zoom: 15,
        }
      : {
          center: {
            lat: 34.14955,
            lng: -118.14145,
          },
          zoom: 15,
        };

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
        <TrafficLayer />
      </GoogleMap>
    ))
  );
  return (
    // Important! Always set the container height explicitly
    <div
      style={{
        height: "60%",
        width: "60%",
        position: "absolute",
        top: "25%",
        left: "20%",
      }}
    >
      <MyMapComponent
        googleMapURL="https://maps.googleapis.com/maps/api/js?key=AIzaSyCoPd7y5p3N7p4jKuh0qQdef5gLA41qVGE"
        loadingElement={<div style={{ height: `100%` }} />}
        containerElement={<div style={{ height: `100%` }} />}
        mapElement={<div style={{ height: `100%` }} />}
      />
    </div>
  );
  // const defaultProps = {
  //   center: {
  //     lat: props.lat,
  //     lng: props.lon,
  //   },
  //   zoom: 15,
  // };

  // return (
  //   // Important! Always set the container height explicitly
  //   <div
  //     style={{
  //       height: "60%",
  //       width: "60%",
  //       position: "absolute",
  //       top: "20%",
  //       left: "20%",
  //     }}
  //   >
  //     <GoogleMapReact
  //       bootstrapURLKeys={{ key: "AIzaSyCoPd7y5p3N7p4jKuh0qQdef5gLA41qVGE" }}
  //       defaultCenter={defaultProps.center}
  //       defaultZoom={defaultProps.zoom}
  //       layerTypes={["TrafficLayer"]}
  //     >
  //       <AnyReactComponent lat={34.14955} lng={-118.14145} />
  //     </GoogleMapReact>
  //   </div>
  // );
}
