<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculate Discount</h1>
<form action="/ProductDiscount" method="post">
    <label>Product Description:</label>
    <input type="text" placeholder="Product Description" name="description">
    <label>List Price:</label>
    <input type="text" placeholder="List Price" name="price">
    <label>Discount Percent:</label>
    <input type="text" placeholder="Discount Percent" name="discount">
    <button>Calculate Discount</button>
</form>
</body>
</html>