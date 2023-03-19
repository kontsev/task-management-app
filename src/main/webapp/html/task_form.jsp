<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title></title>

  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">

</head>

  <body>
    <header>
      <nav class="navbar navbar-expand-md navbar-dark"
           style="background-color: darkslateblue">
        <div>
          <a href="" class="navbar-brand"> Task Management
            System</a>
        </div>

        <ul class="navbar-nav">
          <li><a href="list"
                 class="nav-link">Tasks</a></li>
        </ul>

        <ul class="navbar-nav navbar-collapse justify-content-end">
<%--          href should be updated--%>
          <li><a href="logout"
                 class="nav-link">Logout</a></li>
        </ul>
      </nav>
    </header>
    <div class="container col-md-5">
      <div class="card">
        <div class="card-body">
          <c:if test="${task != null}">
          <form action="update" method="post">
            </c:if>
            <c:if test="${task == null}">
            <form action="insert" method="post">
              </c:if>

              <caption>
                <h2>
                  <c:if test="${task != null}">
                    Edit Task
                  </c:if>
                  <c:if test="${task == null}">
                    Add New Task
                  </c:if>
                </h2>
              </caption>

              <c:if test="${task != null}">
                <input type="hidden" name="id" value="<c:out value='${task.id}' />" />
              </c:if>

              <fieldset class="form-group">
                <label>Task Title</label> <input type="text"
                                                 value="<c:out value='${task.name}' />" class="form-control"
                                                 name="title" required="required" minlength="5">
              </fieldset>

              <fieldset class="form-group">
                <label>Task Decription</label> <input type="text"
                                                      value="<c:out value='${task.description}' />" class="form-control"
                                                      name="description" minlength="5">
              </fieldset>

              <fieldset class="form-group">
                <label>Task Status</label> <select class="form-control"
                                                   name="isDone">
                <option value="false">In Progress</option>
                <option value="true">Complete</option>
              </select>
              </fieldset>

              <fieldset class="form-group">
                <label>Task Target Date</label> <input type="date"
                                                       value="<c:out value='${task.date}' />" class="form-control"
                                                       name="targetDate" required="required">
              </fieldset>

              <button type="submit" class="btn btn-success">Save</button>
            </form>
          </form>
        </div>
      </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>