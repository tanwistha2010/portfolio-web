package com.portfolio.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Change these according to your MySQL setup
private static final String URL =
        "jdbc:mysql://localhost:3306/portfolio_db?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";


    private static final String USER = "root";
    private static final String PASSWORD = "Tanwistha";

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
