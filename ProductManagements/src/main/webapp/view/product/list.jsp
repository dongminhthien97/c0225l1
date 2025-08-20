<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<div>
    <h1>Product List</h1>
    <form action="${pageContext.request.contextPath}/products" method="post" class="mb-3">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" placeholder="Enter product name">
        <button type="submit">Search</button>
    </form>

    <p style="color:green;">${param.mess}</p>

    <!-- Hiển thị thông báo lỗi nếu có -->
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>

    <table class="table table-sm">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacturer</th>
        </tr>
        <c:forEach var="product" items="${productList}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.manufacturer}"/></td>
                <td>
                    <a href="products?action=edit&id=${product.id}">Edit</a> |
                    <a href="products?action=view&id=${product.id}">View</a> |
                    <a href="products?action=delete&id=${product.id}"
                       onclick="return confirm('Are you sure to delete this product?')">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/products?action=add">Add new product</a><br><br>
    <a href="/products">Back to List</a>
    </form>
</div>
</body>
</html>
