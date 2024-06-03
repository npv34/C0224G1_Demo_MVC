<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="org.codegym.bookapp.entity.Student" %>
<%@ page import="org.codegym.bookapp.entity.Group" %><%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 6/3/24
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Student> students = (List<Student>) request.getAttribute("students"); %>
<% List<Group> groups = (List<Group>) request.getAttribute("group"); %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>Student list</h2>
            <a href="/students/create" class="btn btn-success">Create</a>
            <div class="row">
                <form class="row" action="/students/filter" method="get">
                    Filter:
                    <div class="col-6">
                        <select name="group_id" id="" class="form-select" >
                            <c:forEach items="${groups}" var="group">
                                <option value="<c:out value="${group.id}"/>"><c:out value="${group.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class=" col-3">
                        <button class="btn btn-primary" type="submit">Filter</button>
                    </div>
                </form>
            </div>


        </div>
        <div class="card-body">
            <table class="table table-hover">
                <tr>
                    <td>#</td>
                    <td>Name</td>
                    <td>Email</td>
                    <td>Group</td>
                    <td></td>
                </tr>
                <c:set var="i" value="1"/>
                <c:forEach items="${students}" var="student">
                    <tr>
                        <td><c:out value="${i}"/></td>
                        <td><c:out value="${student.name}"/></td>
                        <td><c:out value="${student.email}"/></td>
                        <td>
                            <a href="/groups/detail?id=<c:out value="${student.group.id}"/>"><c:out value="${student.group.name}"/></a>
                        </td>
                        <td>
                            <a href="" class="btn btn-danger">Delete</a>
                            <a href="" class="btn btn-primary">Update</a>
                        </td>
                    </tr>
                    <c:set var="i" value="${i + 1}"/>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
