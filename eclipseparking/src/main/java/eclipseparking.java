//import com.example.eclipseparking.service.ParkingLotService;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class eclipseparking {
//    private final ParkingLotService parkingLotService;
//
//    public eclipseparking(ParkingLotService parkingLotService) {
//        this.parkingLotService = parkingLotService;
//    }
//
//    public static void main(String[] args) throws SQLException {
//        String myTableName = "CREATE TABLE prediction ("
//                + "lat FLOAT( 10, 6 ),"
//                + "lon FLOAT( 10, 6 ),"
//                + "id INT,"
//                + "t0000 FLOAT( 10, 6 ),"
//                + "t0030 FLOAT( 10, 6 ),"
//                + "t0100 FLOAT( 10, 6 ),"
//                + "t0130 FLOAT( 10, 6 ),"
//                + "t0200 FLOAT( 10, 6 ),"
//                + "t0230 FLOAT( 10, 6 ),"
//                + "t0300 FLOAT( 10, 6 ),"
//                + "t0330 FLOAT( 10, 6 ),"
//                + "t0400 FLOAT( 10, 6 ),"
//                + "t0430 FLOAT( 10, 6 ),"
//                + "t0500 FLOAT( 10, 6 ),"
//                + "t0530 FLOAT( 10, 6 ),"
//                + "t0600 FLOAT( 10, 6 ),"
//                + "t0630 FLOAT( 10, 6 ),"
//                + "t0700 FLOAT( 10, 6 ),"
//                + "t0730 FLOAT( 10, 6 ),"
//                + "t0800 FLOAT( 10, 6 ),"
//                + "t0830 FLOAT( 10, 6 ),"
//                + "t0900 FLOAT( 10, 6 ),"
//                + "t0930 FLOAT( 10, 6 ),"
//                + "t1000 FLOAT( 10, 6 ),"
//                + "t1030 FLOAT( 10, 6 ),"
//                + "t1100 FLOAT( 10, 6 ),"
//                + "t1130 FLOAT( 10, 6 ),"
//                + "t1200 FLOAT( 10, 6 ),"
//                + "t1230 FLOAT( 10, 6 ),"
//                + "t1300 FLOAT( 10, 6 ),"
//                + "t1330 FLOAT( 10, 6 ),"
//                + "t1400 FLOAT( 10, 6 ),"
//                + "t1430 FLOAT( 10, 6 ),"
//                + "t1500 FLOAT( 10, 6 ),"
//                + "t1530 FLOAT( 10, 6 ),"
//                + "t1600 FLOAT( 10, 6 ),"
//                + "t1630 FLOAT( 10, 6 ),"
//                + "t1700 FLOAT( 10, 6 ),"
//                + "t1730 FLOAT( 10, 6 ),"
//                + "t1800 FLOAT( 10, 6 ),"
//                + "t1830 FLOAT( 10, 6 ),"
//                + "t1900 FLOAT( 10, 6 ),"
//                + "t1930 FLOAT( 10, 6 ),"
//                + "t2000 FLOAT( 10, 6 ),"
//                + "t2030 FLOAT( 10, 6 ),"
//                + "t2100 FLOAT( 10, 6 ),"
//                + "t2130 FLOAT( 10, 6 ),"
//                + "t2200 FLOAT( 10, 6 ),"
//                + "t2230 FLOAT( 10, 6 ),"
//                + "t2300 FLOAT( 10, 6 ),"
//                + "t2330 FLOAT( 10, 6 ),"
//                + "PRIMARY KEY(id))";
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String jdbcURL = "jdbc:mysql://personaldb.cnpcwbqq5jqy.us-east-1.rds.amazonaws.com:3306/eclipseparking?createDatabaseIfNotExist=true&serverTimezone=UTC";
//        String username = "admin";
//        String password = "Zxh123456!";
//
//        String csvFilePath = "/Users/fangjianjun/IdeaProjects/EclipseParkingProject/eclipseparking/src/main/java/prediction.csv";
//
//        int batchSize = 20;
//
//        Connection connection = null;
//
//        try {
//
//            connection = DriverManager.getConnection(jdbcURL, username, password);
//            String drop = "DROP TABLE prediction";
//            connection.createStatement().executeUpdate(drop);
//            connection.createStatement().executeUpdate(myTableName);
//            connection.setAutoCommit(false);
//
////            String sql = "INSERT INTO parking_signs (lat, lon, id, DAYS_OF_OPERATION, HOURLY_RATE, MAX_TIME, HOURS_OF_OPERATION, TYPE_OF_METER) VALUES (?, ?, ?, ?, ?,?,?,?)";
//            String sql = "INSERT INTO prediction (lat, lon, id, t0000,t0030,t0100,t0130,t0200,t0230,t0300,t0330,t0400,t0430,t0500,t0530,t0600,t0630,t0700,t0730,t0800,t0830,t0900,t0930,t1000,t1030,t1100,t1130,t1200,t1230,t1300,t1330,t1400,t1430,t1500,t1530,t1600,t1630,t1700,t1730,t1800,t1830,t1900,t1930,t2000,t2030,t2100,t2130,t2200,t2230,t2300,t2330) VALUES (?, ?, ?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?, ?, ?,?,?)";
//            PreparedStatement statement = connection.prepareStatement(sql);
//
//            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
//            String lineText = null;
//
//
//            lineReader.readLine(); // skip header line
//
//            while ((lineText = lineReader.readLine()) != null) {
//                String[] data = lineText.split(",");
//                String lat = data[0];
//                String lon = data[1];
//                String id = data[2];
//                statement.setDouble(1, Double.parseDouble(lat));
//                statement.setDouble(2, Double.parseDouble(lon));
//                statement.setInt(3, Integer.parseInt(id));
//                for(int i=3; i< data.length; i++){
//                    statement.setDouble(i+1, Double.parseDouble(data[i]));
//                }
//                statement.addBatch();
//                statement.executeBatch();
//            }
//
//            lineReader.close();
//
//            // execute the remaining queries
//            statement.executeBatch();
//
//            connection.commit();
//            connection.close();
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
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
