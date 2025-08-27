<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

<h1 class="mb-4">Product List</h1>


<form action="${pageContext.request.contextPath}/products" method="get" class="row g-2 mb-3">
    <input type="hidden" name="action" value="search"/>
    <div class="col-auto">
        <input type="text" name="keyword" class="form-control" placeholder="Enter product name">
    </div>
    <div class="col-auto">
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>


<c:if test="${not empty mess}">
    <div class="alert alert-success">${mess}</div>
</c:if>
<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>


<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturer</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.manufacturer}</td>
            <td>
                <c:out value="${p.category.name}"/>
            </td>
            <td>
                <a class="btn btn-sm btn-warning" href="products?action=edit&id=${p.id}">Edit</a>
                <a class="btn btn-sm btn-info" href="products?action=view&id=${p.id}">View</a>
                <a class="btn btn-sm btn-danger" href="products?action=delete&id=${p.id}"
                   onclick="return confirm('Are you sure to delete this product?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<nav>
    <ul class="pagination">
        <c:forEach var="i" begin="1" end="${totalPages}">
            <li class="page-item ${i == currentPage ? 'active' : ''}">
                <a class="page-link" href="${pageContext.request.contextPath}/products?page=${i}">
                        ${i}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>

<a href="${pageContext.request.contextPath}/products?action=add" class="btn btn-success mt-3">
    Add new product
</a>

</body>
</html>
