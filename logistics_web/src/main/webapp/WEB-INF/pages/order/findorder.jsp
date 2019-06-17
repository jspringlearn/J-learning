<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   查看订单信息:
<table border="4">
    <tr>
        <td>订单	名</td>
        <td>订单价格</td>
         <td>delete</td>
          <td>update</td>
    </tr>
    <c:forEach items="${orderList}" var="order">
        <tr>
            
            <td>${order.orderName}</td>
            <td>${order.orderPrice}</td>
           
                <td><a href="${pageContext.request.contextPath}/order/delete.do?orderID=${order.orderID}">删除</a></td>
				<td><a href="${pageContext.request.contextPath}/order/toupdateorder.do?orderID=${order.orderID}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>