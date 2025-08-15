<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
</head>
<body>
<h2>Update Product</h2>
<form method="post" action="/products?action=edit">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${product.id}"/>

    <label>Name:</label>
    <input type="text" name="name" value="${product.name}"/><br/>

    <label>Price:</label>
    <input type="text" name="price" value="${product.price}"/><br/>

    <label>Description</label>
    <textarea name="description">${product.description}</textarea><br/>

    <label>Manufacturer:</label>
    <input type="text" name="manufacturer" value="${product.manufacturer}"/><br/>

    <button type="submit">Edit</button>
</form>
</body>
</html>