<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		这是一个jsp，可以借助el表达式动态获取数据 并于html标签做结合
		
		<!-- 访问request3后，后天分别传递了str和user两个内容过来 -->
		<hr>
		<!-- 大括号中str与user是request域中保存内容的名字 大小写严格区分 -->
		${str }<br>
		${user }
</body>
</html>