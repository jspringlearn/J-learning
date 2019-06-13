<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>信息显示</title>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
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
				<a href="${pageContext.request.contextPath}/site/delete.do?siteId=${site.siteId}">删除</a>
				<a href="${pageContext.request.contextPath}/site/toupdatesite.do?siteId=${site.siteId}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
	<div v-for="(name,info) in ${siteList}">
  {{ ${site.name} }}: {{ ${site.info} }}
</div>
</body>
</html>
