<%-- 
    Document   : home
    Created on : Feb 12, 2023, 11:00:43 PM
    Author     : khanhhoanguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <h1>Homepage</h1>
        <p>Hello ${user.username}</p>
        <a href="login?action=logout">Log out</a>        
    </body>
</html>
