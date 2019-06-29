<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货物添加</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>

    <script type="text/javascript">
        function re() {
            alert("xxx");
            var url='${pageContext.request.contextPath}/goods/update';

            var ID=$('#ID').val();
            var name=$('#name').val();
            var number=$('#number').val();
            var jsonObj={ID:ID,name:name,number:number};

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

    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>

</head>
<body>
<h3> 添加Goods信息</h3>
<div>
    <form action="${pageContext.request.contextPath}/goods/save" method="post">


        <label for="ID">ID</label>
        <input type="text" id="ID" name="ID" placeholder="Goods ID.." value="${goods.ID}">

        <label for="name">name</label>
        <input type="text" id="name" name="name" placeholder="Goods 名字.." value="${goods.ID}">

        <label for="number">数量</label>
        <input type="text" id="number" name="number" placeholder="Goods 数量.." value="${goods.number}">
        <input type="button" value="提交json格式" onclick="re();">
        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>

<!--
ID:<input id="ID" type="text" value="${goods.ID}" name="ID"><br>
名称:<input id="name" type="text" value="${goods.name}" name="name"><br>
数量:<input id="number" type="text" value="${goods.number}" name="number"><br>
<input type="button" value="提交json格式" onclick="re();">
<input type="submit" value="提交更改信息！">

-->