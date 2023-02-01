<%-- 
    Document   : update
    Created on : Feb 1, 2023, 11:12:47 AM
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
        <form action="update" method="post">
            Student ID: <input value="${s.stuId}" type="text" name="stuId" readonly/><br/>
            Student name: <input value="${s.stuName}" type="text" name="stuName"/><br/>
            Gender: <input type="radio" name="gender" value="true" ${s.gender?"checked":""}/>Male
            &nbsp;  <input type="radio" name="gender" value="false" ${s.gender?"":"checked"}/>Female<br/>
            DoB: <input value="${s.dob}" type="date" name="dob"/><br/>
            Department: <select name="deptId">
                <c:forEach items="${requestScope.depts}" var="d">
                    <option <c:if test="${d.getDeptId()==s.getDept().getDeptId()}">selected="selected"</c:if> value="${d.deptId}">${d.deptName}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
