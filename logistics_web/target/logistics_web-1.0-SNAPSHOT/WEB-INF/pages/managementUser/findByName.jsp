<%--
  Created by IntelliJ IDEA.
  User: 杨亚斌
  Date: 2019/6/8
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function re() {
            alert("xxx");

            var url='${pageContext.request.contextPath}/managementUser/AddManagementuser.do';

            var name=$('#name').val();
            var info=$('#phone').val();
            var jsonObj={name:name,phpne:phone};

            var parameters=JSON.stringify(jsonObj);

            console.log(jsonObj);
            console.log(parameters);
            $.ajax({
                type:'post',
                url:url,
                contentType:'application/json;charset=UTF-8',
                data:parameters,
                success:function(respData){
                    console.log("jsonp:"+respData);
                }
            })

        }
    </script>
</head>
<body>
<form action="findByName.jsp" method="post">
    姓名:<input id="name" type="text" value="${managementUser.name}" name="name"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">

</form>
</body>
</html>
