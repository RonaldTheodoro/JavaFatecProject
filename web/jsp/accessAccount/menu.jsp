<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.User" %>
<%@page import="br.com.fatec.controller.UserController" %>

<%
    String login = request.getParameter("login");
    String password = request.getParameter("password")
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
    <h1>Hello World!</h1>
</body>
</html>
