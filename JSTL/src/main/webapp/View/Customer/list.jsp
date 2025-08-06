<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<div>
    <h1 style="text-align: center">Danh sách khách hàng</h1>
    <table class="table table-sm">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td><c:out value="${customer.getName()}"></c:out></td>
                <td>
                    <c:out value="${customer.getDateOfBirth()}"></c:out>
                </td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
                <td>
                    <img src="https://play.google.com/store/apps/details?id=com.google.android.apps.photos"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
