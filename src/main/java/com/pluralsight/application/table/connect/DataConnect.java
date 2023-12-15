package com.pluralsight.application.table.connect;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DataConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/northwind";
    private static final String USER = "root";
    private static final String PASS = "~CONFIDENTIAL~";

    private static BasicDataSource dataSource;

    public static void sqlConnection() {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASS);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void dataCloser() throws SQLException {
        dataSource.close();
    }
}
