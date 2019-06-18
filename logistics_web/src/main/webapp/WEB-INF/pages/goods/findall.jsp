<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: K
  Date: 2019/6/17
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Goods的显示</title>
    <!--外部样式的引用-->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css"  />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>

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
        <li><a href="#">货物信息</a></li>
        <li><a href="#">基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">

    <table class="tablelist">
        <thead>
        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>名字</th>
            <th>数量</th>
            <th>
                <a>操作</a>
                <a href="${pageContext.request.contextPath}/goods/add">添加</a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goodsList}" var="goods">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${goods.name}</td>
                <td>${goods.number}</td>
                <td><a href="${pageContext.request.contextPath}/goods/delete?goodsId=${goods.ID}" >删除</a>
                    <a href="${pageContext.request.contextPath}/goods/toupdategoods?goodsId=${goods.ID}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>




</body>
</html>

