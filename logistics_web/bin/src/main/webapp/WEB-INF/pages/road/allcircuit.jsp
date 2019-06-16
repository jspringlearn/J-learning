<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据输出</title>
</head>
<body>
线路信息:
<table id="ddd" border="2">
<tr>
    <td>线路名</td>
    <td>距离</td>
    <td>时间</td>
    <td>起点</td>
    <td>终点</td>
</tr>
<c:forEach items="${circuitList}" var="circuit">
<tr><td>${circuit.entityName}</td>
<td>${circuit.distance}</td>
<td>${circuit.elapTime}</td>
<td>${circuit.aSite}</td>
<td>${circuit.bSite}</td>
</tr>
</c:forEach>
</table>
</body>
</html>