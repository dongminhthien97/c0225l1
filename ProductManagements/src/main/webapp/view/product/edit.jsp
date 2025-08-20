<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>
<form method="post" action="${pageContext.request.contextPath}/products?action=edit">
    <input type="hidden" name="id" value="${product.id}"/>
    <p>
        <label>Name: </label>
        <input type="text" name="name" value="${product.name}" required/>
    </p>
    <p>
        <label>Price: </label>
        <input type="number" step="0.01" name="price" value="${product.price}" required/>
    </p>
    <p>
        <label>Description: </label>
        <input type="text" name="description" value="${product.description}" required/>
    </p>
    <p>
        <label>Manufacturer: </label>
        <input type="text" name="manufacturer" value="${product.manufacturer}" required/>
    </p>
    <p>
        <button type="submit">Update</button>
    </p>
</form>
<a href="${pageContext.request.contextPath}/products">Back to list</a>
</body>
</html>
