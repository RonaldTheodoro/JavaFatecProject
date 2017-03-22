<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.User" %>
<%@page import="br.com.fatec.controller.UserController" %>

<%
    int id = Integer.parserInt(request.getParameter("id"));
    User user = new User();
    user.setId(id);
    UserController userController = new UserController();
    user = userController.searchUser(user);
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
    <ul>
        <li><%=user.getId() %></li>
        <li><%=user.getName() %></li>
        <li><%=user.getLogin() %></li>
        <li><%=user.getPassword() %></li>
        <li><%=user.getStatus() %></li>
        <li><%=user.getType() %></li>
    </ul>
</body>
</html>
