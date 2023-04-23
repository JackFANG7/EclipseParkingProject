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
          left: "28%",
          transform: 'translate("-50%", "-50%")',
          fontSize: "10em",
          color: "#605DE4",
        }}
      >
        It's More Than
      </div>
      <div
        style={{
          position: "absolute",
          top: "30%",
          left: "30%",
          transform: 'translate("-50%", "-50%")',
          fontSize: "10em",
          color: "#605DE4",
        }}
      >
        Just Parking
      </div>
      <div
        style={{
          textAlign: "center",
          position: "absolute",
          top: "60%",
          left: "22%",
          width: "58%",
          fontSize: "20px",
        }}
      >
        Eclipse, a technology development team, provides customers visualization
        of possible parking lots around their destination. Based on free street
        parking lots, parking meters, parking structures distribution, distance
        and traffic around the destination , our system will generate a
        composite index to recommend parking lots to our customers.
      </div>
      <div
        style={{
          textAlign: "center",
          position: "absolute",
          top: "80%",
          left: "19%",
          width: "60%",
          fontSize: "100px",
        }}
      >
        Click to start
      </div>
    </div>
  );
};
export default Face;
