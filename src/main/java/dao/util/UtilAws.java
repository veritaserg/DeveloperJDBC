package dao.util;

import model.Skill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UtilAws {
    static final String DATABASE_URL = "mysqlaws.c05bmdvhonqe.ap-northeast-1.rds.amazonaws.com";
    private static final String DATABASE_DRIVER = "com.simba.athena.jdbc.Driver";
    private static final int SERVER_PORT = 3306;
    static final String USER = "admin";
    static final String PASSWORD = "qwerty123";
    private static final String DATABASE_NAME = "developer";

    static Connection connection;

    static {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:mysql://" + DATABASE_URL + ":" + SERVER_PORT + "/" + DATABASE_NAME;
        try {
            connection = DriverManager.getConnection(connectionUrl, USER, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to get connection.");
        }
        return connection;
    }

}

