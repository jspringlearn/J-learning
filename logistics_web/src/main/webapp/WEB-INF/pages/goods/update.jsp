<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>货物修改</title>
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
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/update" method="post">
    ID:<input id="ID" type="text" value="${goods.ID}" name="ID"><br>
    名称:<input id="name" type="text" value="${goods.name}" name="name"><br>
    数量:<input id="number" type="text" value="${goods.number}" name="number"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit" value="提交更改信息！">
</form>
</body>
</html>