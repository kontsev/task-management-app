package com.example.taskmanagement.servlets;

import com.example.taskmanagement.beans.Task;
import com.example.taskmanagement.dao.ApplicationDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");

        int id = Integer.parseInt(req.getParameter("id"));

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        boolean status = Boolean.valueOf(req.getParameter("isDone"));
        LocalDate date = LocalDate.parse(req.getParameter("targetDate"));

        Task task = new Task(id, title, status, date, description, username);
        ApplicationDAO applicationDAO = new ApplicationDAO();
        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

        applicationDAO.updateTask(task, connection);
        resp.sendRedirect("list");
    }
}
