
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布评论</title>
    <script src="${pageContext.request.contextPath}/WEB-INF/resources/js/jquery-1.8.3.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/comment/addcomment" method="post"><%--//添加或修改完之后返回的页面--%>
    ID:<input id="commentID" type="text" value="${comment.commentID}" name="commentID"><br>
    评论内容:<input id="commentContent" type="text" value="${comment.commentContent}" name="commentContent"><br>
    发布时间:<input id="commentTime" type="text" value="${comment.commentTime}" name="commentTime"><br>
    <input type="submit"value="确认发布">
</form>
</body>
</html>
