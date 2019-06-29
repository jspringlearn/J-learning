<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
       function re() {
    	   
    	   var url='${pageContext.request.contextPath}/car/addcar.do';
    	   
    	   var car_number=$('#car_number').val();
    	   var car_owner=$('#car_owner').val();
    	   var car_owner_tel=$('#car_owner_tel').val();	 
    	   var car_road=$('#car_road').val();
    	   var car_status=$('#car_status').val();
    	   var car_volume=$('#car_volume').val();
    	   var jsonObj={car_number:car_number,car_owner:car_owner,car_owner_tel:car_owner_tel,car_road:car_road,car_status:car_status,car_volume:car_volume};
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
<form action="${pageContext.request.contextPath}/car/addcar" method="post">
  车牌号码&nbsp;&nbsp;&nbsp;:<input id="car_number" type="text" name="car_number"><br>
    车主:<input id="car_owner" type="text" name="car_owner"><br>
    车主电话:<input id="car_owner_tel" type="text" name="car_owner_tel"><br>
    路线信息<input id="car_road" type="text" name="car_road"><br>
    运输状态:<input id="car_status" type="text" name="car_status"><br>
    车辆型号:<input id="car_volume" type="text" name="car_volume"><br>
    <input type="button" value="提交json格式" onclick="re();">
    <input type="submit">
</form>
</body>
</html>