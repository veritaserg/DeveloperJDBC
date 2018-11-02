package dao.util;

import java.sql.*;

public class Util {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/dev?user=root&password=1234&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String USER = "root";
    static final String PASSWORD = "1234";
    static Connection connection;

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        try {

            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to get connection.");
        }
        return connection;
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
