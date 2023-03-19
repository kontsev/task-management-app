package com.example.taskmanagement.servlets;

import com.example.taskmanagement.beans.Task;
import com.example.taskmanagement.dao.ApplicationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ApplicationDAO applicationDAO = new ApplicationDAO();
        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

        applicationDAO.deleteTask(id, connection);
        resp.sendRedirect("list");
    }
}
