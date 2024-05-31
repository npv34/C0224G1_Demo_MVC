<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.codegym.bookapp.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/31/24
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Book bookUpdate = (Book)request.getAttribute("book"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form update books</h2>

<form action="/books/update?id=<%= bookUpdate.getId() %>" method="post">
    Name: <input type="text" name="name" value="<%= bookUpdate.getName() %>"/>
    Desc: <input type="text" name="desc" value="<%= bookUpdate.getDesc() %>" />
    Price: <input type="text" name="price" value="<%= bookUpdate.getPrice() %>"/>
    <button value="submit">Save</button>
</form>
<a href="/books/list">List</a>
</body>
</html>
