<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加订单</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/order/addorder" method="post"><%--//添加或修改完之后返回的页面--%>
    订单号:<input id="orderID" type="text" value="${order.orderID}" name="orderID"><br>
    订单名:<input id="orderName" type="text" value="${order.orderName}" name="orderName"><br>
    订单价格:<input id="orderPrice" type="text" value="${order.orderPrice}" name="orderPrice"><br>
    下单时间:<input id="orderTime" type="text" value="${order.orderTime}" name="orderTime"><br>  
    <input type="submit"value="确认添加">
</form>
</body>
</html>