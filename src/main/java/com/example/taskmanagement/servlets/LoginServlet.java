package com.example.taskmanagement.servlets;

import com.example.taskmanagement.dao.ApplicationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/html/login.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

        ApplicationDAO applicationDAO = new ApplicationDAO();
        if (applicationDAO.validateUser(username, password, connection)) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            req.getRequestDispatcher("/html/task_list.jsp").forward(req, resp);
        } else {
            String errorMessage="Invalid Credentials, please login again!";
            req.setAttribute("error", errorMessage);
            req.getRequestDispatcher("/html/login.jsp").forward(req, resp);
        }
    }
}
