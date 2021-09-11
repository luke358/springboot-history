<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/8
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登陆页面</h1>

<form action="/user/login" method="post">
    用户名:<input type="text" name="username" id="username">
    密码:<input type="text" name="password" id="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
