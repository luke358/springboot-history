<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/7/7
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
            </div>
        </div>
    </div>


    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label >书籍名称</label>
            <input name="bookName" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍数量</label>
            <input name="bookCounts" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <label>书籍详情</label>
            <input name="detail" type="text" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加" >
        </div>
    </form>
</div>
</body>
</html>
