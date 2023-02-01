<%-- 
    Document   : login
    Created on : Feb 1, 2023, 3:44:10 PM
    Author     : tungtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
            Username: <input type="text" name="username"><br/>
            Password: <input type="password" name="password"><br/><!--  -->
            <input type="submit" value="Login">
        </form>
    </body>
</html>
