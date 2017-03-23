<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="br.com.fatec.bean.Product" %>

<%
    String name = request.getParameter("name");
    String code = request.getParameter("code");
    String type = request.getParameter("type");
    
    Product product = new Product(name, code, type);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <ul>
            <li><%=product.getName()%></li>
            <li><%=product.getCode() %></li>
            <li><%=product.getType()%></li>
        </ul>
    </body>
</html>
