<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Goods的显示</title>

</head>
<body>
	货物信息
	<table border="2">
		<tr>
			<td>名称</td>
			<td>数量</td>
		</tr>
		<c:forEach items="${goodsList}" var="goods">
		<tr>
			<td>${goods.name}</td>
			<td>${goods.number}
				<a href="/goods/delete?goodsId=${goods.ID}">删除</a>
				<a href="/goods/toupdategoods?goodsId=${goods.ID}">修改</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
