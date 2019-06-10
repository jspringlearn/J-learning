<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <body>
        <c:if test="${empty requestScope.employees}">
            没有任何员工信息。
        </c:if>
        <c:if test="${!empty requestScope.employees}">
            <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach  items="${requestScope.employees}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>${emp.gender}</td>
                        <td>${emp.department.departmentName}</td>
                        <td><a href="">Edit</a> </td>
                        <td><a href="">Delete</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br><br>
        <a href="emp">Add New Employee</a>
</body>
</head>
</html>