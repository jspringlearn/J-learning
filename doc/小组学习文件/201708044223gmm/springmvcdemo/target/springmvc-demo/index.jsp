<html>
<body>

   <br><br>
   <!--
   模拟修改操作：
   1、原始数据为：1.Tom，123456，tom@www.com,12
   2、密码不能被修改
   3.表单回显，模拟操作直接在表单填写对应的属性值
    -->
   <form action="springmvc/testModelAttribute" method="post">
      <input type="hidden" name="id" value="1"/>
      username:<input type="text" name="username" value="Tom"/>
      <br>
      email:<input type="text" name="email" value="tom@www.com"/>
      <br>
      age:<input type="text" name="age" value="12"/>
      <br>
      <input type="submit" value="submit"/>
   </form>

   <br><br>
   <a href="springmvc/testMap">Test Map</a>

   <br><br>
   <a href="springmvc/testModelAndView">Test ModelAndView</a>

   <br><br>
   <a href="springmvc/testServletAPI">Test ServletAPI</a>

   <br><br>
   <form action="springmvc/testPojo" method="post">
      username:<input type="text" name="username"/>
      <br>
      password:<input type="password" name="password"/>
      <br>
      email:<input type="text" name="email"/>
      <br>
      age:<input type="text" name="age"/>
      <br>
      city:<input type="text" name="address.city"/>
      <br>
      province:<input type="text" name="address.province"/>
      <br>
      <input type="submit" value="submit"/>
   </form>

   <br><br>
   <form action="springmvc/testRestPut/1" method="post">
      <input type="hidden" name="_method" value="PUT"/>
      <input type="submit" value="TestRest PUT">
   </form>

   <br><br>
   <form action="springmvc/testRestDelete/1" method="post">
      <input type="hidden" name="_method" value="DELETE"/>
      <input type="submit" value="TestRest DELETE"/>
   </form>

   <br><br>
   <form action="springmvc/testRestPost" method="post">
      <input type="submit" value="TestRest POST"/>
   </form>

   <br><br>
   <a href="springmvc/testRestGet/1">Test Rest Get</a>

   <br><br>
   <a href="springmvc/testPathVariable/1">Test PathVariable</a>

   <br><br>
   <a href="springmvc/testParamsAndHeaders?username=gsonya&age=10">Test ParamsAndHeaders</a>

   <br><br>
   <form action="springmvc/testMethod" method="post">
      <input type="submit" value="testMethod"/>
   </form>

   <br><br>
   <a href="springmvc/testMethod">Test Method</a>

   <br><br>
   <a href="springmvc/testRequestMapping">Test RequestMapping</a>

   <br><br>
   <a href="helloworld">Hello World</a>

</body>
</html>
