<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>信息显示</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css"  />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });
        });
    </script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="http://localhost:8080/logistics_client/">首页</a></li>
    </ul>
</div>
<div class="rightinfo">

    <table class="tablelist" >
         <thead>
        <tr>
            <th><input type="checkbox" checked="checked"/></th>
            <th>ID<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
            <th>订单	名称</th>
            <th>订单价格</th>
            <th>下单时间</th>
            <th>操作&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                <a href="${pageContext.request.contextPath}/order/toadd">添加</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderList}" var="order">
        <tr>
            <td><input type="checkbox"  /></td>
            <td>${order.orderID}</td>
            <td>${order.orderName}</td>
            <td>${order.orderPrice}</td>
            <td>${order.orderTime}</td>
           
                <td><a href="${pageContext.request.contextPath}/order/delete.do?orderID=${order.orderID}">删除</a>
				    <a href="${pageContext.request.contextPath}/order/toupdateorder.do?orderID=${order.orderID}">修改</a>
				    </td>
        </tr>
    </c:forEach>
     </tbody>
</table>
</div>
<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>
</body>
</html>