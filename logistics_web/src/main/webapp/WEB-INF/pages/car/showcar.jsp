<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>显示页面</title>

</head>
<body>
	车辆:
	<table border="2">
		<tr>
			<td>信息展示</td>
		</tr>
		<c:forEach items="${carList}" var="car">
			<tr>
			    <td>${car.car_number}</td>
			    <td>${car.car_owner}</td>
				<td>${car.car_owner_tel}</td> 
				<td>${car.car_road}</td>
				<td>${car.car_status}</td>
				<td>${car.car_volume}</td>
				<td>
				  <a href="${pageContext.request.contextPath}/car/delete?car_number=${car.car_number}" >删除</a>     
				  <a href="${pageContext.request.contextPath}/car/toupdatecar?car_number=${car.car_number}"> 修改</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
