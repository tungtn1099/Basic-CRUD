<%-- 
    Document   : list
    Created on : Feb 1, 2023, 9:29:48 AM
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
    <script>
        function submitForm(){
            document.getElementById('formSearch').submit();
        }
    </script>
    <body>
        <c:if test="${sessionScope.account.username eq null}"><a href="../login">Login</a></c:if>
        <c:if test="${sessionScope.account.username ne null}">${sessionScope.account.username} <a href="../logout">Logout</a></c:if>
        <form method="get" id="formSearch">
            Department: <select name="deptId" onchange="submitForm();">
                <option value="0">-----ALL-----</option>
                <c:forEach items="${requestScope.depts}" var="d">
                    <option
                        <c:if test="${d.deptId eq requestScope.deptId}">
                        selected="selected"
                        </c:if>
                        value="${d.deptId}">${d.deptName}</option>
                </c:forEach>
            </select>
        </form>
        <table border="1px">
            <tr>
                <th>Student ID</th>
                <th>Name</th>
                <th>Gender(Male)</th>
                <th>Date of birth</th>
                <th>Department</th>
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
            <tr>
                <td>${s.stuId}</td>
                <td>${s.stuName}</td> 
                <td>
                   <c:if test="${s.gender}">Male</c:if>
                   <c:if test="${!s.gender}">Female</c:if>
                </td>
                <td>${s.dob}</td>
                <td>${s.dept.deptName}</td>
                <td>
                    <a href="update?stuId=${s.stuId}">Update</a>
                    <a href="delete?stuId=${s.stuId}">Delete</a>
                </td>
            </tr>
            </c:forEach>
        </table>
        <a href="create">Create student</a>
    </body>
</html>
