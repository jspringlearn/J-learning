<%--
  Created by IntelliJ IDEA.
  User: 缑曼曼
  Date: 2019/6/18
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        function re() {
            alert("xxx");

            var url='${pageContext.request.contextPath}/employee/upd.do';



            var Id=$('#id').val();
            var staffNum=$('#staff_num').val();
            var staffName=$('#staff_name').val();
            var staffSex=$('#staff_sex').val();
            var staffAge=$('#staff_age').val();
            var staffTel=$('#staff_tel').val();

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

<form action="${pageContext.request.contextPath}/employee/upd" method="post">
    ID:<input id="staffId" type="text" value="${staff.id}" name="id"><br>
    姓名:<input id="staffName" type="text" value="${staff.staff_name}" name="staff_name"><br>
    年龄:<input id="staffAge" type="text" value="${staff.staff_age}" name="staff_age"><br>
    工号:<input id="staffNum" type="text" value="${staff.staff_num}" name="staff_num"><br>
    性别：<input id="staffSex" type="text" value="${staff.staff_sex}" name="staff_sex"><br>
    电话：<input id="staffTel" type="text" value="${staff.staff_tel}" name="staff_tel"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit" >
</form>
</body>
</html>