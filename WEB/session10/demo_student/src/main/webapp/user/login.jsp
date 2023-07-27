
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <form action="http://localhost:8080/user?action=login" method="post">
        <input type="text" name="username">
        <input type="password" name="password">
        <button type="submit">Đăng nhập</button>
         <a href="http://localhost:8080/user?action=register">Đăng ký</a>
    </form>
</body>
</html>
