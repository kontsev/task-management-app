package com.example.taskmanagement.servlets;


import com.example.taskmanagement.beans.User;
import com.example.taskmanagement.dao.ApplicationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("html/register.jsp");
        dispatcher.forward(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("firstName");
        String surname = request.getParameter("lastName");

        User user = new User(name, surname, login, password);

        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");


        ApplicationDAO applicationDAO = new ApplicationDAO();
        int rows = applicationDAO.registerUser(user, connection);

        if (rows != 0) {
            request.setAttribute("NOTIFICATION", "Successfully registered!");
        } else {
            request.setAttribute("NOTIFICATION", "Error occurred, try later");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("html/register.jsp");
        dispatcher.forward(request, response);
    }
}
