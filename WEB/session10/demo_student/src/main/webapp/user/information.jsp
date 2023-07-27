<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 7/27/2023
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
      <li>${user.id}</li>
      <li>${user.username}</li>
      <li>${user.password}</li>
      <li>${user.role}</li>
    </ul>
</body>
</html>
