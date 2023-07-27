<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <title>Danh sách sinh viên</title>
</head>
<style>
    img {
        width: 100px;
        height: 100px;
    }
</style>
<body>
<a href="/students?action=create">Thêm mới sinh viên</a>
<a href="/user?action=logout">Đăng xuất</a>
<br>
    <table border="1">
        <tr  >
            <th>ID</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Ảnh</th>
            <th colspan="2">Action</th>
        </tr>

        <c:forEach items="${studentList}" var="student">

            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td><img src="${student.image}" alt="sv"></td>
                <td><a href="http://localhost:8080/students?action=edit&id=${student.id}">Sửa</a></td>
                <td><a href="http://localhost:8080/students?action=delete&id=${student.id}">Xóa</a></td>

            </tr>

        </c:forEach>

    </table>

<form action="/students" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" placeholder="search" name="nameSearch">
    <button>Tìm</button>
</form>

</body>
</html>



