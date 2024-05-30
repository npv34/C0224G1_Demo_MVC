<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/30/24
  Time: 9:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form create books</h2>
<form action="/books/create" method="post">
    Id: <input type="number" name="id" />
    Name: <input type="text" name="name" />
    Desc: <input type="text" name="desc" />
    Price: <input type="text" name="price" />
    Author: <input type="text" name="author" />
    <button value="submit">Save</button>
</form>
</body>
</html>
