<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath %>>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>ID<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
          <th>线路名</th>
          <th>距离</th>
          <th>时间</th>
          <th>起点</th>
          <th>终点</th>
          <th><a href="${pageContext.request.contextPath}/road/tosave">添加</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${circuitList}" var="circuit">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${circuit.id}</td>
        <td>${circuit.entityName}</td>
        <td>${circuit.distance}</td>
        <td>${circuit.elapTime}</td>
        <td>${circuit.aSite}</td>
        <td>${circuit.bSite}</td>
        <td><a href="${pageContext.request.contextPath}/road/delete?id=${circuit.id}" class="tablelink">删除</a>     
        <a href="${pageContext.request.contextPath}/road/toupdate?id=${circuit.id}" class="tablelink"> 修改</a></td>
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