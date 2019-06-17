<%--
  Created by IntelliJ IDEA.
  User: 杨亚斌
  Date: 2019/6/8
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
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
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>ID<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
            <th>姓名</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${managementUserList}" var="managementUser">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${managementUser.managementID}</td>
                <td>${managementUser.MName}</td>
                <td>${managementUser.MPhone}</td>
                <td> <a href="${pageContext.request.contextPath}/managementUser/delete.do?managementID=${managementUser.managementID}">删除</a>
                    <a href="${pageContext.request.contextPath}/managementUser/toupdatemanagementUser.do?managementID=${managementUser.managementID}">修改</a></td>
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
