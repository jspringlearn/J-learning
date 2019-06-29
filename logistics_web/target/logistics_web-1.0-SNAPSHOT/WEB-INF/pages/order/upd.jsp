<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改订单</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
       /*function re() {
    	   alert("xxx");
    	   
    	   var url='${pageContext.request.contextPath}/order/upd.do';
    	   
    	   var orderID=$('#orderID').val();
    	   var orderName=$('#orderName').val();
    	   var orderPrice=$('#orderPrice').val();	   
    	   var jsonObj={orderID:orderID,orderName:orderName,orderPrice:orderPrice};
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
<form action="${pageContext.request.contextPath}/order/upd" method="post">
    订单号:<input id="orderID" type="text" value="${order.orderID}" name="orderID"><br>
    订单名:<input id="orderName" type="text" value="${order.orderName}" name="orderName"><br>
    订单价格:<input id="orderPrice" type="text" value="${order.orderPrice}" name="orderPrice"><br>
    下单时间:<input id="orderTime" type="text" value="${order.orderTime}" name="orderTime"><br>
    <input type="submit"value="确认修改">
</form>
</body>
</html>