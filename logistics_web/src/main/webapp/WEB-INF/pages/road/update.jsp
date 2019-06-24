<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
       function re() {
    	   alert("xxx");
    	   var url='${pageContext.request.contextPath}/road/update';
    	   
    	   var circuitId=$('#id').val();
    	   var name=$('#entityName').val();
    	   var distan=$('#distance').val();
    	   var time=$('#elapTime').val();
    	   var asite=$('#aSite').val();
    	   var bsite=$('#bSite').val();
	   
    	   var jsonObj={circuitId:id,entityName:entityName,distance:distance,elapTime:elapTime,aSite:aSite,bSite:bSite};
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
<form action="${pageContext.request.contextPath}/road/update" method="post">
  ID&nbsp;:<input id="Id" type="text" value="${circuit.id}" name="Id" readonly><br>
    名称:<input id="entityName" type="text" value="${circuit.entityName}" name="entityName"><br>
       距离:<input id="distance" type="text" value="${circuit.distance}" name="distance"><br>
    时间:<input id="elapTime" type="text" value="${circuit.elapTime}" name="elapTime"><br>
    起点:<input id="aSite" type="text" value="${circuit.aSite}"  name="aSite"><br>
   终点:<input id="bSite" type="text"value="${circuit.bSite}" name="bSite"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">
</form>
</body>
</html>