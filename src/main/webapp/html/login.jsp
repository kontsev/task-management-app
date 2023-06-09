<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title></title>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
  <h1>Login Form</h1>
  <div class = "container-tagline">
    <% if(request.getAttribute("error")!=null){ %>
    <em><%=request.getAttribute("error")%></em><br />
    <%} %>
    <form action="login" method="post">

      <div class="form-group">
        <label for="username">User Name:</label> <input type="text"
                                                     class="form-control" id="username"
                                                     placeholder="User Name"
                                                     name="username" required>
      </div>

      <div class="form-group">
        <label for="password">Password:</label> <input type="password"
                                                    class="form-control" id="password"
                                                    placeholder="Password"
                                                    name="password" required>
      </div>


      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>