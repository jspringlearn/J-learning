<%--
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>在这里尝试JQuery</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
       $(function () {
           $("#btn").click(function () {
               alert("hello btn");
           });
       })
    </script>
</head>
<body>

   <td>
   <button id="btn">发送ajax请求</button>
   </td>
</body>
</html>
