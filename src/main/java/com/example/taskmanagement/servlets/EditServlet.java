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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        ApplicationDAO applicationDAO = new ApplicationDAO();
        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

        Task task = applicationDAO.selectTaskById(id, connection);
        req.setAttribute("task", task);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/html/task_form.jsp");
        dispatcher.forward(req, resp);

    }
}
