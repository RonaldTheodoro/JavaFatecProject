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
    <from name="insertColaborator" action="validateInsertCollaborator.jsp" method="POST">
        <p>Name: <input type="text" name="name"></p>
        <p>Type: <input type="text" name="type"></p>
        <p><input type="submit" name="Search"></p>
    </from>
</body>
</html>
