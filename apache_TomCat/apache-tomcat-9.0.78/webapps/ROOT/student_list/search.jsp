<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
  img {
    width: 100px;
    height: 100px;
  }
</style>
<body>
<table border="1">
  <tr  >
    <th>ID</th>
    <th>Tên</th>
    <th>Tuổi</th>
    <th>Ảnh</th>

  </tr>

  <c:forEach items="${searchList}" var="student">

    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.age}</td>
      <td><img src="${student.image}" alt="sv"></td>

    </tr>

  </c:forEach>

</table>

<a href="/students?action=showAll">Trở về trang chủ</a>
</body>
</html>
