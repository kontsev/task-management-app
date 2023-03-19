package com.example.taskmanagement.listeners;

import com.example.taskmanagement.dao.DBConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("in contextinitialized method");
        Connection connection = null;
        try {
            connection = DBConnection.getConnectionToDB();
        } catch (SQLException e) {
            throw new RuntimeException("Connection to db failed!");
        }
        arg0.getServletContext().setAttribute("dbconnection", connection);


    }

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("in contextDestroyed method");
        Connection connection = (Connection)arg0.getServletContext().getAttribute("dbconnection");
        try {
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
