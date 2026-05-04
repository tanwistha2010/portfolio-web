package com.portfolio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = System.getenv("DATABASE_URL");

        if (url == null || url.isEmpty()) {
            throw new SQLException("DATABASE_URL environment variable is not set");
        }

        return DriverManager.getConnection(url);
    }
}