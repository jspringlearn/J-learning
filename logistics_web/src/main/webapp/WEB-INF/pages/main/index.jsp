<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">

</head>
<body>

	测试页面

	<div id="app">
		<el-button @click="visible = true">Button</el-button>
		<el-dialog :visible.sync="visible" title="Hello world">
		<p>Try Element</p>
		</el-dialog>
	</div>
<form action="${pageContext.request.contextPath}/site/allsite" method="post">
   物流仓储系统
    <input type="submit" value="查看地点信息" >
    
</form>

	<form action="/goods/allgoods" method="post">
		物流管理系统---货物
		<input type="submit" value="查看货物信息" >
	</form>

	<form action="${pageContext.request.contextPath}/managementUser/findallmanagementUser.do" method="post">
		物流仓储系统
		<input type="submit" value="查看管理员信息" >

	</form>

    <form action="${pageContext.request.contextPath}/road/allcircuit" method="post">
        物流仓储系统---线路
        <input type="submit" value="查看线路信息">
    </form>

</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script>
	new Vue({
		el : '#app',
		data : function() {
			return {
				visible : false
			}
		}
	})
</script>
</html>