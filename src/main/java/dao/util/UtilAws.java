package dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



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




//    public static void main(String[] args) throws SQLException {
//     Connection connection = getConnection();
//     Statement statement;
//        statement = connection.createStatement();
//
//        String SQL = "CREATE TABLE developers " +
//                "(id INTEGER not NULL, " +
//                " name VARCHAR(50), " +
//                " specialty VARCHAR (50), " +
//                " salary INTEGER not NULL, " +
//                " PRIMARY KEY (id))";
//
//        statement.executeUpdate(SQL);
//        if(statement!=null){
//            statement.close();
//        }
//        if(connection!=null){
//            connection.close();
//        }
//    }




}
