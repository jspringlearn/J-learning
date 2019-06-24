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
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>ID<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
        <th>地点名称</th>
        <th>地点信息</th>
        <th><a href="${pageContext.request.contextPath}/site/tosave">添加</a></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${siteList}" var="site">
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${site.siteId}</td>
        <td>${site.name}</td>
		<td>${site.info}</td>
        <td><a href="${pageContext.request.contextPath}/site/delete.do?siteId=${site.siteId}" class="tablelink">删除</a>     <a href="${pageContext.request.contextPath}/site/toupdatesite.do?siteId=${site.siteId}" class="tablelink"> 修改</a></td>
        </tr>  
        </c:forEach>       
        </tbody>
    </table>
    </div>
    <form action="${pageContext.request.contextPath}/site/josn" >
    <input type="submit" value="生成json格式" >
    
</form>
    
</body>
</html>
