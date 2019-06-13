<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Goods的显示</title>
	<!--链接方式引入css
	<link rel="stylesheet" href="css的url" type="text/css" >
	  -->
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<table border="1" cellspacing="0" cellpadding="5" width="400" height="100" align="centre">

	<!--border 围绕表格单元的边框,th是表头，tr是行，td 是行中的每个单元格-->

	<caption >Goods 信息</caption>    <!--定义表格标题，默认居中  -->

	<tr>
		<th bgcolor="#faebd7">名称</th>
		<th bgcolor="#faebd7">数量</th>
		<th bgcolor="#faebd7">修改</th>
		<th bgcolor="#faebd7">删除</th>

	</tr>
	<c:forEach items="${goodsList}" var="goods">
		<tr>
			<td>${goods.name}</td>
			<td>${goods.number}</td>
			<td>
				<a href="${pageContext.request.contextPath}/goods/delete?goodsId=${goods.ID}" >删除</a>

			</td>
			<td>

				<a href="${pageContext.request.contextPath}/goods/toupdategoods?goodsId=${goods.ID}">修改</a>

			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
