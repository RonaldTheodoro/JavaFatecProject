<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Fatec Project</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
    <form name="insertContact" action="validateInsertContact.jsp" method="POST">
        <p>Name: <input type="text" name="name"></p>
        <p>Rg: <input type="text" name="rg"></p>
        <p>Cpf: <input type="text" name="cpf"></p>
        <p>Address: <input type="text" name="address"></p>
        <p><input type="submit" name="Search"></p>
    </form>
</body>
</html>
