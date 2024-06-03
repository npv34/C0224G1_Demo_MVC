<%@ page import="java.util.List" %>
<%@ page import="org.codegym.bookapp.entity.Book" %>
<%@ page import="org.codegym.bookapp.entity.Group" %><%--
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

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
<div class="container">
    <h2>Book list</h2>
    <div class="row">
        <div class="col-12 col-md-4">
            <a href="/books/create" class="btn btn-success">Add new book</a>

        </div>
        <div class="col-12 col-md-8">
            <form class="row" action="/books/search" method="get">
                <div class=" col-12 col-md-10">
                    <input type="text" class="form-control" name="keyword">

                </div>
                <div class="col-12 col-md-2">
                    <button class="btn btn-primary" type="submit">Search</button>

                </div>
            </form>
        </div>
    </div>

    Total: <%= books.size() %>

    <table class="table table-hover table-striped">
        <thead class="table-dark">
        <tr>
            <td>#</td>
            <td>Name</td>
            <td>Desc</td>
            <td>Price</td>
            <td></td>
        </tr>
        </thead>
        <c:set var="i" value="1"/>
        <c:forEach items="${books}" var="book">
            <tr>
                <td><c:out value="${i}"/></td>
                <td><c:out value="${book.name}"/> </td>
                <td><c:out value="${book.desc}"/> </td>
                <td><c:out value="${book.price}"/> </td>
                <td>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/books/delete?id=<c:out value="${book.id}"/>">Delete</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/update?id=<c:out value="${book.id}"/>">Update</a>
                </td>
            </tr>
            <c:set var="i" value="${i + 1}"/>
        </c:forEach>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
