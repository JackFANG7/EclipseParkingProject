import com.example.eclipseparking.service.ParkingLotService;

//public class eclipseparking {
//    private final ParkingLotService parkingLotService;
//
//    public eclipseparking(ParkingLotService parkingLotService) {
//        this.parkingLotService = parkingLotService;
//    }
//
//    public static void main(String[] args){
////        String myTableName = "CREATE TABLE parking_structure ("
////                + "lat FLOAT( 10, 6 ),"
////                + "lon FLOAT( 10, 6 ),"
////                + "id INT,"
////                + "spaces INT,"
////                + "DAYS_OF_OPERATION varchar(255),"
////                + "HOURLY_RATE varchar(255),"
////                + "EV_CHARGING varchar(255),"
//////                + "DAYS_OF_OPERATION varchar(255),"
//////                + "HOURLY_RATE varchar(255),"
//////                + "MAX_TIME varchar(255),"
//////                + "HOURS_OF_OPERATION varchar(255),"
//////                + "TYPE_OF_METER varchar(255),"
////                + "PRIMARY KEY(id))";
////        try {
////            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
////        } catch (InstantiationException e) {
////            e.printStackTrace();
////        } catch (IllegalAccessException e) {
////            e.printStackTrace();
////        } catch (ClassNotFoundException e) {
////            e.printStackTrace();
////        }
////        String jdbcURL = "jdbc:mysql://personaldb.cnpcwbqq5jqy.us-east-1.rds.amazonaws.com:3306/eclipseparking?createDatabaseIfNotExist=true&serverTimezone=UTC";
////        String username = "admin";
////        String password = "Zxh123456!";
////
////        String csvFilePath = "/Users/fangjianjun/IdeaProjects/eclipseparking/src/main/java/Public_Parking.csv";
////
////        int batchSize = 20;
////
////        Connection connection = null;
////
////        try {
////
////            connection = DriverManager.getConnection(jdbcURL, username, password);
////            String drop = "DROP TABLE parking_structure";
////            connection.createStatement().executeUpdate(drop);
////            connection.createStatement().executeUpdate(myTableName);
////            connection.setAutoCommit(false);
////
//////            String sql = "INSERT INTO parking_signs (lat, lon, id, DAYS_OF_OPERATION, HOURLY_RATE, MAX_TIME, HOURS_OF_OPERATION, TYPE_OF_METER) VALUES (?, ?, ?, ?, ?,?,?,?)";
////            String sql = "INSERT INTO parking_structure (lat, lon, id, spaces, DAYS_OF_OPERATION,HOURLY_RATE,EV_CHARGING) VALUES (?, ?, ?, ?, ?,?,?)";
////            PreparedStatement statement = connection.prepareStatement(sql);
////
////            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
////            String lineText = null;
////
////            int count = 0;
////
////            lineReader.readLine(); // skip header line
////
////            while ((lineText = lineReader.readLine()) != null) {
////                String[] data = lineText.split(",");
////                String lat = data[0];
////                String lon = data[1];
////                String id = data[2];
////                String spaces = data[3];
////                String DAYS_OF_OPERATION = data[4];
////                String HOURLY_RATE =data[5];
////                String EV_CHARGING=data[6];
//////                String MAX_TIME=data[5];
//////                String HOURS_OF_OPERATION=data[6];
//////                String TYPE_OF_METER=data[7];
////
////                statement.setDouble(1, Double.parseDouble(lat));
////                statement.setDouble(2, Double.parseDouble(lon));
////                statement.setInt(3, Integer.parseInt(id));
////                statement.setInt(4, Integer.parseInt(spaces));
////                statement.setString(5, DAYS_OF_OPERATION);
////                statement.setString(6, HOURLY_RATE);
////                statement.setString(7, EV_CHARGING);
//////                statement.setString(5, HOURLY_RATE);
//////                statement.setString(6, MAX_TIME);
//////                statement.setString(7, HOURS_OF_OPERATION);
//////                statement.setString(8, TYPE_OF_METER);
////
////
////                statement.addBatch();
////                statement.executeBatch();
////            }
////
////            lineReader.close();
////
////            // execute the remaining queries
////            statement.executeBatch();
////
////            connection.commit();
////            connection.close();
////
////        } catch (IOException ex) {
////            System.err.println(ex);
////        } catch (SQLException ex) {
////            ex.printStackTrace();
////
////            try {
////                connection.rollback();
////            } catch (SQLException e) {
////                e.printStackTrace();
////            }
////        }
//    }
//}
