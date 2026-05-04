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
        String mysqlUrl = System.getenv("MYSQL_URL");

        if (mysqlUrl == null || mysqlUrl.isEmpty()) {
            throw new SQLException("MYSQL_URL environment variable is not set");
        }

        String jdbcUrl = mysqlUrl.replaceFirst("^mysql://", "jdbc:mysql://");

        if (!jdbcUrl.contains("?")) {
            jdbcUrl += "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        }

        return DriverManager.getConnection(jdbcUrl);
    }
}