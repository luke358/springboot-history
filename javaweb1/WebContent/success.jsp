<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		注册成功！<br>
		<!-- request域中保存了user这个对象，我们自定义的User类包含了id,name,pwd,sex,hooby属性 
		我们可以通过user.name,获取到User类的name属性对应的值-->
		欢迎，${user.name }注册！
</body>
</html>