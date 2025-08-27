<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD NEW PRODUCT</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<div>
    <form action="/products?action=add" method="post">
        <h1>Add new product to list</h1>
        <label>Name</label>
        <input name="name" placeholder="Enter name"><br>
        <label>Price</label>
        <input name="price" placeholder="Enter price"><br>
        <label>Description</label>
        <input name="description" placeholder="Enter description"><br>
        <label>Manufacturer</label>
        <input name="manufacturer" placeholder="Enter manufacturer"><br>
        <label>Category:</label>
        Category:
        <select name="categoryId">
            <c:forEach var="c" items="${categories}">
                <option value="${c.id}">${c.name}</option>
            </c:forEach>
        </select><br>
        </select>
        <button type="submit">Save</button>
        <a href="/products">Cancel</a>
    </form>
</div>
</body>
</html>
