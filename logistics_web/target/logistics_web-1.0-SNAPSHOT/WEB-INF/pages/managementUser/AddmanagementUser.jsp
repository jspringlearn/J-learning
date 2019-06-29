<%--
  Created by IntelliJ IDEA.
  User: 杨亚斌
  Date: 2019/6/17
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加管理员</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
  /*  function re() {
        alert("出错啦！");
        var url='${pageContext.request.contextPath}/managementUser/AddmanagementUser.do';
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
    }*/
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/managementUser/AddmanagementUser" method="post"><%--//添加或修改完之后返回的页面--%>
    ID:<input id="managementID" type="text"  name="ManagementID"><br>
    姓名:<input id="MName" type="text"  name="MName"><br>
    电话:<input id="MPhone" type="text"  name="MPhone"><br>
    <input type="submit"value="确认添加">
</form>
</body>
</html>