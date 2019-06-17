<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--
    spring mvc 处理静态资源：
    1.需要处理的原因：DispatcherServlet请求映射配置为/,
    spring mvc会捕获web容器所有请求，包括静态资源的请求
    spring mvc会将他们当成一个普通的请求处理，因找不到
    对应处理器会出现错误
    2.解决：在spring mvc 的配置文件中配置<mvc:default-servlet-handler/>
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
            })
        })
    </script>
</head>
    <body>

        <form action="" method="post">
            <input type="hidden" name="_method" value="DELETE"/>
        </form>

        <c:if test="${empty requestScope.employees}">
            没有任何员工信息。
        </c:if>
        <c:if test="${!empty requestScope.employees}">
            <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>Department</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach  items="${requestScope.employees}" var="emp">
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.lastName}</td>
                        <td>${emp.email}</td>
                        <td>${emp.gender}</td>
                        <td>${emp.department.departmentName}</td>
                        <td><a href="emp/${emp.id}">Edit</a> </td>
                        <td><a class="delete" href="emp/${emp.id}">Delete</a> </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <br><br>
        <a href="emp">Add New Employee</a>
</body>

</html>