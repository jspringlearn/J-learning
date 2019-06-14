<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>员工信息</title>

</head>
<body>

    <c:if test="${empty requestScope.staffList}">
        没有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.staffList}">
        <table border="1" cellspacing="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Num</th>
                <th>sex</th>
                <th>tel</th>
            </tr>
            <c:forEach items="${staffList}" var="staff">
                <tr>
                    <td>${staff.id}</td>
                    <td>${staff.staff_name}</td>
                    <td>${staff.staff_age}</td>
                    <td>${staff.staff_num}</td>
                    <td>${staff.staff_sex}</td>
                    <td>${staff.staff_tel}</td>
                    <td><a href="">Edit</a> </td>
                    <td><a href="">Delete</a> </td>
                </tr>
            </c:forEach>
</table>
    </c:if>
</body>
</html>
