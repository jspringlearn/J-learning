<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>注册</title>

</head>
<body>
	地点:
	<table border="2">
		<tr>
			<td>名称</td>
			<td>简介</td>
		</tr>
		<c:forEach items="${siteList}" var="site">
		<tr>
			<td>${site.name}</td>
			<td>${site.info}
				<a href="/site/delete?siteId=${site.siteId}">删除</a>
				<a href="/site/toupdatesite?siteId=${site.siteId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
