<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.User" %>
<%@page import="br.com.fatec.controller.UserController" %>

<%
    String name = request.getParameter("name");
    String status = request.getParameter("status");
    String type = request.getParameter("type");
    
    User user = new User();
    
    user.setName(name);
    user.setStatus(status);
    user.setType(type);
    
    UserController userController = new UserController(user);
    user = userController.insertUser(user);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Fatec Project</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <p><%=user.getName() %></p>
    <p><%=user.getStatus() %></p>
    <p><%=user.getType() %></p>
</body>
</html>
