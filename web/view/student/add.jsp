<%-- 
    Document   : add
    Created on : Feb 1, 2023, 10:41:18 AM
    Author     : tungtn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="create" method="POST">
            Name: <input type="text" name="stuName"/> <br/>
            Gender: <input type="radio" checked="checked" value="male" name="gender"/> Male
            &nbsp; <input type="radio" value="female" name="gender"/> Female  <br/>
            Dob: <input type="date" name="dob"><br/>
            Department: <select name="deptId">
                <c:forEach items="${requestScope.depts}" var="d">
                    <option value="${d.deptId}">${d.deptName}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Create"/>
        </form>
    </body>
</html>
