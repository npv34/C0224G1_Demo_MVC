<%--
  Created by IntelliJ IDEA.
  User: luanpv
  Date: 5/30/24
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Login page</h2>
<form action="/auth/login" method="post">
     <label>username:
        <input type="text" name="username"/>
    </label>
    pass: <input name="password" type="password">
    <button type="submit">Login</button>
</form>
</body>
</html>
