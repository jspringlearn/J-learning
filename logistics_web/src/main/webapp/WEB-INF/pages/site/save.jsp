<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
       function re() {
    	   
    	   var url='${pageContext.request.contextPath}/site/upd.do';
    	   
    	   var siteId=$('#siteId').val();
    	   var name=$('#name').val();
    	   var info=$('#info').val();	   
    	   var jsonObj={siteId:siteId,name:name,info:info};
    	 //  var jsonObj={name:name,info:info};
    	   var parameters=JSON.stringify(jsonObj);
    	   alert(parameters);
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
<form action="${pageContext.request.contextPath}/site/save" method="post">
  ID&nbsp;&nbsp;&nbsp;:<input id="siteId" type="text" name="siteId"><br>
    名称:<input id="name" type="text" name="name"><br>
    信息:<input id="info" type="text" name="info"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">
</form>
</body>
</html>