<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form create books</h2>
<form action="/books/create" method="post">
    Name: <input type="text" name="name" />
    Desc: <input type="text" name="desc" />
    Price: <input type="text" name="price" />
    <button value="submit">Save</button>
</form>
<a href="/books/list">List</a>
</body>
</html>
