<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <li><a href="http://localhost:8080/logistics_client_war_exploded/">首页</a></li>
        <li><a >基本内容</a></li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <form action="" method="post">
            <input type="hidden" name="_method" value="DELETE"/>
        </form>
        <c:if test="${empty requestScope.staffList}">
            没有任何员工信息
        </c:if>
        <c:if test="${!empty requestScope.staffList}">

        <tr>
            <th><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>ID<i class="sort"><img src="<%=basePath%>images/px.gif" /></i></th>
            <th>姓名</th>
            <th>年龄</th>
            <th>工号</th>
            <th>性别</th>
            <th>电话</th>
            <th>操作</th>
            <th><a href="${pageContext.request.contextPath}/employee/tosave">添加</a></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${staffList}" var="staff">
            <tr>
                <td><input name="" type="checkbox" value="" /></td>
                <td>${staff.id}</td>
                <td>${staff.staff_name}</td>
                <td>${staff.staff_age}</td>
                <td>${staff.staff_num}</td>
                <td>${staff.staff_sex}</td>
                <td>${staff.staff_tel}</td>
                <td>
                    <a href= "${pageContext.request.contextPath}/employee/toupdatestaff.do?id=${staff.id}" class="tablelink">Edit</a>
                    <a href="${pageContext.request.contextPath}/employee/delete.do?id=${staff.id}" class="tablelink">Delete</a>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    </c:if>



</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>
</html>
