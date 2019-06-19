<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加车辆</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/order/addorder" method="post"><%--//添加或修改完之后返回的页面--%>
    车牌号码:<input id="car_number" type="text" value="${car.car_number}" name="car_number"><br>
    车主:<input id="car_owner" type="text" value="${car.car_owner}" name="car_owner"><br>
    车主电话:<input id="car_owner_tel" type="text" value="${car_owner_tel}" name="car_owner_tel"><br>
    路线信息:<input id="car_road" type="text" value="${car.car_road}" name="car_road"><br>  
    运输状态:<input id="car_status" type="text" value="${car.car_status}" name="car_status"><br>  
     车型:<input id="car_volume" type="text" value="${car.car_volume}" name="car_volume"><br>
    
    <input type="submit"value="确认添加">
</form>
</body>
</html>