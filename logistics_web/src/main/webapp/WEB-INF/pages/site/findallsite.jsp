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
            <td>${site.name}</td>
			<td>${site.info}
			<a href="${pageContext.request.contextPath}/site/edit.do?id=${site.id}">修改</a></td>
		</c:forEach>
	</table>
</body>
</html>
