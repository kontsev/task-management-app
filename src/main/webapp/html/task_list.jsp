<%@ page import="com.example.taskmanagement.beans.Task" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>User Management Application</title>

  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>

</head>
  <body>
  <header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: darkslateblue">
      <div>
        <a href="" class="navbar-brand"> Task Management
          System </a>
      </div>

      <ul class="navbar-nav">
<%--        <li><a href="<%=request.getContextPath()%>/list"--%>
      <li><a href="list"
               class="nav-link">Task list</a></li>
      </ul>

      <ul class="navbar-nav navbar-collapse justify-content-end">
        <li><a href="logout"
               class="nav-link">Logout</a></li>
      </ul>
    </nav>
  </header>

  <div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
      <h3 class="text-center">List of Tasks</h3>
      <hr>
      <div class="container text-left">

        <a href="new"
           class="btn btn-success">Add Task</a>
      </div>
      <br>
      <table class="table table-bordered">
        <thead>
        <tr>
          <th>Title</th>
          <th>Target Date</th>
          <th>Task Status</th>
          <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <!--   for (Todo todo: todos) {  -->
<%--        <jsp:useBean id="taskList" scope="session" type="java.util.List"/>--%>
        <c:forEach var="task" items="${taskList}">

          <tr>
            <td><c:out value="${task.name}" /></td>
            <td><c:out value="${task.date}" /></td>
            <td><c:out value="${task.completeToString()}" /></td>

            <td><a href="edit?id=<c:out value='${task.id}' />">Edit</a>
              &nbsp;&nbsp;&nbsp;&nbsp; <a
                      href="delete?id=<c:out value='${task.id}' />">Delete</a></td>

            <!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
                      <button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
          </tr>
        </c:forEach>
        <!-- } -->
        </tbody>

      </table>
    </div>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>