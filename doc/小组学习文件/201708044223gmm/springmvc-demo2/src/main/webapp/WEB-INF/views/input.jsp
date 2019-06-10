<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 缑曼曼
  Date: 2019/6/10
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--form:可以更快捷开发出表单页面，而且可以更方便的进行表单值的回显--%>
    <form:form action="emp" method="post" modelAttribute="employee">
        <%--path属性对应html表单标签的name属性值--%>
        LastName:<form:input path="lastName"/>
        <br>
        Email:<form:input path="email"/>
        <br>
        <%
            Map<String,String>genders=new HashMap();
            genders.put("男","Male");
            genders.put("女","Famale");
            request.setAttribute("genders",genders);
        %>
        Gender:<form:radiobuttons path="gender" items="${genders}" />
        <br>
        Department:<form:select path="department" items="${departments}" itemLabel="departmentName" itemValue="id"></form:select>
        <br>
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
