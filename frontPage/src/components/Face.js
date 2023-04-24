import { Button } from "antd";
const Face = () => {
  return (
    <div
      style={{
        padding: 24,
        minHeight: 380,
        position: "relative",
      }}
    >
      <img
        src="https://simplemaps.com/static/demos/resources/svg-library/svgs/world.svg"
        style={{ width: "100%", height: "100%" }}
        alt="world map"
      />

      <div
        style={{
          position: "absolute",
          top: "10%",
          left: "30.5%",
          transform: 'translate("-50%", "-50%")',
          fontSize: "8em",
          color: "#605DE4",
          fontFamily: "Verdana",
        }}
      >
        It's More Than
      </div>
      <div
        style={{
          position: "absolute",
          top: "30%",
          left: "33.5%",
          transform: 'translate("-50%", "-50%")',
          fontSize: "8em",
          color: "#605DE4",
          fontFamily: "Verdana",
        }}
      >
        Just Parking
      </div>
      <div
        style={{
          textAlign: "center",
          position: "absolute",
          top: "60%",
          left: "21%",
          width: "58%",
          fontSize: "20px",
          marginTop: "1%",
          fontFamily: "monaco monospace",
        }}
      >
        Eclipse, a technology development team, provides customers visualization
        of possible parking lots around their destination. Based on free street
        parking lots, parking meters, parking structures distribution, distance
        and traffic around the destination, our system will generate a composite
        index to recommend parking lots to our customers.
      </div>
      <div
        style={{
          position: "absolute",
          top: "89%",
          left: "47%",
        }}
      >
        <Button
          type="primary"
          shape="round"
          style={{ background: "#605DE4", borderColor: "white" }}
        >
          Click to Start
        </Button>
      </div>
    </div>
  );
};
export default Face;
