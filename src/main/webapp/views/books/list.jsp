<%@ page import="java.util.List" %>
<%@ page import="org.codegym.bookapp.entity.Book" %><%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/30/24
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<Book> books = (List<Book>) request.getAttribute("books"); %>
<html>
<head>
    <title>Title</title>
    <style>
        table {
            width: 700px;
            border-collapse: collapse;
        }

        tr, td {
            border: 1px solid #959595;
            height: 30px;
        }

        tr:hover {
            background-color: #959595;
        }

    </style>
</head>
<body>
<h2>Book list</h2>
<a href="/books/create">Add new book</a>
<table>
    <tr>
        <td>#</td>
        <td>Name</td>
        <td>Desc</td>
        <td>Price</td>
        <td>Author</td>
        <td></td>
    </tr>
    <c:set var="i" value="1"/>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${i}"/></td>
            <td><c:out value="${book.name}"/> </td>
            <td><c:out value="${book.desc}"/> </td>
            <td><c:out value="${book.price}"/> </td>
            <td><c:out value="${book.author}"/> </td>
            <td><a href="${pageContext.request.contextPath}/books/delete?id=<c:out value="${book.id}"/>">Delete</a></td>
        </tr>
        <c:set var="i" value="${i + 1}"/>
    </c:forEach>
</table>
</body>
</html>
