
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<table border="1">
    <tr  >
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Ảnh</th>
        <th colspan="2">Action</th>
    </tr>

        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td><img src="${student.image}" alt="sv"></td>

        </tr>

</table>--%>

<form action="http://localhost:8080/students?action=edit" method="post">
    <input type="hidden" name="id" placeholder="ID" value="${student.id}">
<%--
    // <input type="text" name="id" placeholder="ID" value="${student.id} " readonly>
--%>
    <input type="text" name="name" placeholder="Fullname" >
    <input type="text"name="age" placeholder="Age" >
    <input type="text"name="image" placeholder="Imange">
    <button>Sửa</button>
</form>
</body>
</html>
