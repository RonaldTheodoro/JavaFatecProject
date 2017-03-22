<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.User" %>
<%@page import="br.com.fatec.controller.UserController" %>

<%
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    
    User user = new User();
    
    user.setLogin(login);
    user.setPassword(password);
    
    UserController userController = new UserController();
    user = userController.validateUser(user);
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
    <div>
        <p><%=user.getId()%></p>
        <p><%=user.getName()%></p>
        <p><%=user.getLogin()%></p>
        <p><%=user.getPassword()%></p>
        <p><%=user.getStatus()%></p>
        <p><%=user.getType()%></p>
    </div>
    <div>
        <a href="insertUser.jsp">Insert User</a>
        <a href="../contact/insertContact.jsp">Insert Contact</a>
        <a href="../collaborator/insertCollaborator.jsp">Insert Collaborator</a>
    </div>
</body>
</html>
