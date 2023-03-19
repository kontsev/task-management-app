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
import java.util.List;


@WebServlet("/list")
public class TaskListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        displayList(req, resp);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/html/task_list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void displayList(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        String username = (String)session.getAttribute("username");

        ApplicationDAO applicationDAO = new ApplicationDAO();
        Connection connection = (Connection)getServletContext().getAttribute("dbconnection");

        List<Task> taskList = applicationDAO.selectAllTasks(username, connection);
        session.setAttribute("taskList", taskList);
    }
}
