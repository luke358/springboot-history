<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
注册页面<br>
   <form action="http://localhost:7080/javaweb1/regist" method="post"><br>
   		<input name="name" type="text" placeholder="请输入用户名">
   		<span><font color="red">${nameErr }</font></span><br>
   		<input name="pwd"  type="password" placeholder="请输入密码"><br>
   		性别:<label><input name="sex" type="radio" value="male" checked>男</label>
   				<label><input name="sex" type="radio" value="female"/>女</label><br>
   		生日:<input name="birth" type="date"><br>
   		爱好:<input name="hobby" type="checkbox" value="basketball">篮球
   		<input name="hobby" type="checkbox" value="sing">唱
   		<input name="hobby" type="checkbox" value="jump">跳<br>
   		<input type="submit" value="注册">
   		<input type="reset" value="重置"><br>
   		</form>
</body>
</html>