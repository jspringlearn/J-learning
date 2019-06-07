<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
       function re() {
    	   alert("xxx");
    	   
    	   var url='${pageContext.request.contextPath}/stu/save.do';
    	   
    	   var name=$('#name').val();
    	   var sex=$('#sex').val();	   
    	   var jsonObj={name:name,sex:sex};
    	   
    	   var parameters=JSON.stringify(jsonObj);
    	   
    	   console.log(jsonObj);
    	   console.log(parameters);
    	   $.ajax({
    		   type:'post',
    		   url:url,
    		   contentType:'application/json;charset=UTF-8',
    		   data:parameters,
    		   success:function(respData){
    			   console.log(respData);
    		   }
    	   })
		
	}
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}" method="post">
    城市:<input type="text" name="sitename"><br>
    信息:<input type="text" name="siteinfo"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">
</form>
</body>
</html>