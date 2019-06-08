<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 杨亚斌
  Date: 2019/6/8
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看</title>
</head>
<body>
查看管理人员信息:
<table border="2">
    <tr>
        <td>姓名</td>
        <td>电话</td>
    </tr>
    <c:forEach items="${managementUserList}" var="managementUser">
        <tr>
            <td>${managementUser.MName}</td>
            <td>${managementUser.MPhone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
