package com.example.taskmanagement.dao;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:postgresql://localhost:5432/task_management_db");
        ds.setUsername("postgres");
        ds.setPassword("postgres");
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnectionToDB() throws SQLException {
        return ds.getConnection();
    }
}
