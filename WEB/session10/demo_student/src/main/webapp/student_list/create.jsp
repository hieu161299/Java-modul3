
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
