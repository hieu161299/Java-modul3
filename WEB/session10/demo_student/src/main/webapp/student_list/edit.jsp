<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit</title>
</head>
<body>



<form action="http://localhost:8080/students?action=edit" method="post">
    <%-- <input type="hidden" name="id" placeholder="ID" value="${student.id}">--%>
    <input type="text" name="id" placeholder="ID" style="color: green" value="${student.id}" readonly>
    <input type="text" name="name" placeholder="Fullname" value="${student.name}">
    <input type="text" name="age" placeholder="Age" value="${student.age}">
    <input type="text" name="image" placeholder="Imange" value="${student.image}">
    <button>Sửa</button>
</form>
</body>
</html>
