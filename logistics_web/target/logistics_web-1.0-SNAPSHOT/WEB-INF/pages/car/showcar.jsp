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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息显示</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css"  />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
       <!--  <th><input name="" type="checkbox" value="" checked="checked"/></th> -->
        <th>车辆名称<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
        <th>车主</th>            
        <th>车主电话</th>           
        <th>路线信息</th>
        <th>运输状态</th>      
        <th>车辆型号</th>
        <th><a href="${pageContext.request.contextPath}/car/toadd">添加</a></th>

        </tr>
        </thead>
        <tbody>
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
        </tbody>
    </table>
    </div>
    
</body>
</html>
