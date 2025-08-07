<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<style>
    img {
        width: 80px;
        height: auto;
        border-radius: 6px;
    }
</style>
<div>
    <h1 style="text-align: center">Danh sách khách hàng</h1>
    <table class="table table-sm">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.getName()}"></c:out></td>
                <td>
                    <c:out value="${customer.getDateOfBirth()}"></c:out>
                </td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
                <td><img src="${pageContext.request.contextPath}/${customer.image}" alt="Ảnh khách hàng"></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
