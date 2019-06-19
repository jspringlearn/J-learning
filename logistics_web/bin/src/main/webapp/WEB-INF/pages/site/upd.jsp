<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
       function re() {
    	   alert("xxx");
    	   
    	   var url='${pageContext.request.contextPath}/site/upd.do';
    	   
    	   var siteId=$('#siteId').val();
    	   var name=$('#name').val();
    	   var info=$('#info').val();	   
    	   var jsonObj={siteId:siteId,name:name,info:info};
    	   
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
<form action="${pageContext.request.contextPath}/site/upd" method="post">
  ID:<input id="siteId" type="text" value="${site.siteId}" name="siteId"><br>
    名称:<input id="name" type="text" value="${site.name}" name="name"><br>
    信息:<input id="info" type="text" value="${site.info}" name="info"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">
</form>
</body>
</html>