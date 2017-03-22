<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.Contact" %>
<%@page import="br.com.fatec.controller.ContactController" %>

<%
    String name = request.getParameter("name");
    String rg = request.getParameter("rg");
    String cpf = request.getParameter("cpf");
    String address = request.getParameter("address");
    
    Contact contact = new Contact();
    
    contact.setName(name);
    contact.setRg(rg);
    contact.setCpf(cpf);
    contact.setAddress(address);
    
    ContactController contactController = new ContactController();
    contact = contactController.insertContact(contact);
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
    <p><%=contact.getName() %></p>
    <p><%=contact.getRg() %></p>
    <p><%=contact.getCpf() %></p>
    <p><%=contact.getEnd() %></p>
</body>
</html>
