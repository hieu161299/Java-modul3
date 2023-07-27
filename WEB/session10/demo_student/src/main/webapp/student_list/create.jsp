<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 7/26/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/students?action=create" method="post">
  <input type="text" name="id" placeholder="ID">
  <input type="text" name="name" placeholder="Fullname">
  <input type="text"name="age" placeholder="Age">
  <input type="text"name="image" placeholder="Imange">
  <button>Thêm</button>
</form>
</body>
</html>
