<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改评论</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        /*function re() {
            alert("xxx");

            var url='${pageContext.request.contextPath}/comment/upd.do';

    	   var commentID=$('#commentID').val();
    	   var commentContent=$('#commentContent').val();
    	   var jsonObj={commentID:commentID,commentContent:commentContent};
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
<form action="${pageContext.request.contextPath}/comment/upd" method="post">
    ID:<input id="commentID" type="text" value="${comment.commentID}" name="commentID"><br>
    评论内容:<input id="commentContent" type="text" value="${comment.commentContent}" name="commentContent"><br>
    评论时间:<input id="commentTime" type="text" value="${comment.commentTime}" name="commentTime"><br>
    <input type="submit"value="确认修改">
</form>
</body>
</html>
