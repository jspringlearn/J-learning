<%--
  Created by IntelliJ IDEA.
  User: 杨亚斌
  Date: 2019/6/12
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        function re() {
            alert("xxx");
            var url='${pageContext.request.contextPath}/managementUser/upd.do';
            var managementID=$('#managementID').val();
            var MName=$('#MName').val();
            var MPhone=$('#MPhone').val();
            var jsonObj={managementID:managementID,MName:MName,MPhone:MPhone};
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
<form action="${pageContext.request.contextPath}/managementUser/upd" method="post">
    ID:<input id="managementID" type="text" value="${managementUser.managementID}" name="managementID"><br>
    姓名:<input id="MName" type="text" value="${managementUser.MName}" name="MName"><br>
    电话:<input id="MPhone" type="text" value="${managementUser.MPhone}" name="MPhone"><br>
    <input type="submit"value="确认修改">
</form>
</body>
</html>
