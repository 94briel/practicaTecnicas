package db;
import java.sql.*;

public class DB {

    private static Connection connection;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/gstore?zeroDateTimeBehavior=convertToNull&useSSL=false";
    private static String user = "root";
    private static String password = "root";

    public DB() {
    }

    public static Connection getConexion() {
        if (connection == null) {

            try {
                    Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }           
        }
        return connection;
    }

}