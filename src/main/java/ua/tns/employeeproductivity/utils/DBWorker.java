package ua.tns.employeeproductivity.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private Connection connection;

    public DBWorker() {
        try {
            connection = DriverManager.getConnection(DBConstants.DB_URL, DBConstants.DB_USER, DBConstants.DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
