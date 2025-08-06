<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2025/08/04
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/form" method="post">
    <label>Product Description:</label>
    <input type="text" name="Description" placeholder="Enter Product Description" />
    <label>Price:</label>
    <input type="text" name="Price" placeholder="Enter Price" />
    <label>Discount:</label>
    <input type="text" name="Discount" placeholder="Enter Discount" />
    <button type="submit">Tính chiết khấu</button>
</form>

</body>
</html>
