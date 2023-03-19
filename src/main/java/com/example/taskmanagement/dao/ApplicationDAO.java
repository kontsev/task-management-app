package com.example.taskmanagement.dao;

import com.example.taskmanagement.beans.Task;
import com.example.taskmanagement.beans.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {
    public int registerUser(User user, Connection connection) {
        int rowsAffected = 0;
        try {

            //Insert query
            String sql = "insert into users (user_firstname, user_lastname, user_login, user_password) " +
                    "values(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getFristname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());

            rowsAffected = statement.executeUpdate();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return rowsAffected;
    }

    public boolean validateUser(String username, String password, Connection connection) {
        boolean validate = false;

        try {
           String sql = "select * from users where user_login = ? and user_password = ?";

           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1, username);
           statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                validate = true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return validate;
    }

    public void insertTask(Task task, Connection connection) {
        try {
            String sql = "insert into tasks (task_name, task_completeness, " +
                    "task_date, task_description, user_login) values " + " (?, ?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setBoolean(2, task.isCompleted());
            statement.setDate(3, Date.valueOf(task.getDate()));
            statement.setString(4, task.getDescription());
            statement.setString(5, task.getUsername());
            statement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<Task> selectAllTasks(String username, Connection connection) {
        List<Task> taskList = new ArrayList<>();
        try {
            String sql = "select * from tasks where user_login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("task_id");
                String title = rs.getString("task_name");
                boolean isDone = rs.getBoolean("task_completeness");
                LocalDate date = rs.getDate("task_date").toLocalDate();
                String description = rs.getString("task_description");
                taskList.add(new Task(id, title, isDone, date, description, username));
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return taskList;
    }

    public Task selectTaskById(int id, Connection connection) {
        Task task = null;
        try {
            String sql = "select * from tasks where task_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String title = rs.getString("task_name");
                boolean isDone = rs.getBoolean("task_completeness");
                LocalDate date = rs.getDate("task_date").toLocalDate();
                String description = rs.getString("task_description");
                String username = rs.getString("user_login");
                task = new Task(id, title, isDone, date, description, username);
            }
        } catch(SQLException exception) {
            exception.printStackTrace();
        }

        return task;
    }

    public boolean updateTask(Task task, Connection connection) {
        boolean updated = false;

        try {
            String sql = "update tasks set task_name = ?, task_completeness = ?, " +
                    "task_date = ?, task_description = ?, user_login = ? where task_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, task.getName());
            statement.setBoolean(2, task.isCompleted());
            statement.setDate(3, Date.valueOf(task.getDate()));
            statement.setString(4, task.getDescription());
            statement.setString(5, task.getUsername());
            statement.setInt(6, task.getId());

            updated = statement.executeUpdate() > 0;
        } catch(SQLException exception) {
            exception.printStackTrace();
        }
        return updated;
    }

    public void deleteTask(int id, Connection connection) {
        try {
            String sql = "delete from tasks where task_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
