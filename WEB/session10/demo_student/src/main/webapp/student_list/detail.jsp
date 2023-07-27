<%--
  Created by IntelliJ IDEA.
  User: ACER NITRO 5
  Date: 7/27/2023
  Time: 11:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
  <tr  >
    <th>ID</th>
    <th>Tên</th>
    <th>Tuổi</th>
    <th>Ảnh</th>
    <th colspan="2">Action</th>
  </tr>

    <tr>
      <td>${student.id}</td>
      <td><a href="/students?action=detail&id=${student.id}">${student.name}</a></td>
      <td>${student.age}</td>
      <td><img src="${student.image}" alt="sv"></td>


    </tr>


</table>
</body>
</html>
