<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Detail</title>
</head>
<body>
<h1>Product Detail</h1>
<p><b>ID:</b> ${product.id}</p>
<p><b>Name:</b> ${product.name}</p>
<p><b>Price:</b> ${product.price}</p>
<p><b>Description:</b> ${product.description}</p>
<p><b>Manufacturer:</b> ${product.manufacturer}</p>

<a href="/products">Back to List</a>
</body>
</html>
