<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.Colaborator" %>
<%@page import="br.com.fatec.controller.ColaboratorController" %>

<%
    String name = request.getParameter("name");
    String type = request.getParameter("type");
    
    Colaborator colaborator = new Colaborator();
    
    colaborator.setNome(name);
    colaborator.setType(type);
    
    ColaboratorController colaboratorController = new ColaboratorController();
    colaborator = colaboratorController.insertColaborator(colaborator);
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
    <p><%=colaborator.getName() %></p>
    <p><%=colaborator.getType() %></p>
</body>
</html>
