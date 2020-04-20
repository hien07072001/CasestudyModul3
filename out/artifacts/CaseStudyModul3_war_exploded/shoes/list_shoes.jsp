<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/17/20
  Time: 07:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shoes List</title>
</head>
<body>
<h1>Shoes</h1>
<p>
    <a href="/shoes?action=create_shoes">Create new shoes</a>
</p>
<div>
    <form method="get" action="${pageContext.request.contextPath}/shoes?action=list_shoes">

        <button type="submit" name="action" value="search">Tìm kiếm</button>
    </form>
</div>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Shoes</td>
        <td>Image</td>
        <td>Name</td>
        <td>Price</td>
        <td>action</td>
    </tr>

    <c:forEach items='${requestScope["listShoes"]}' var="khachhang">
        <tr>
            <td>${khachhang.getShoes_id()}</td>
            <td>${khachhang.getImage_link()}</td>
            <td>${khachhang.getName_shoes()}</td>
            <td>${khachhang.getPrice()}</td>
            <td><a href="/shoes?action=edit_shoes&id=${khachhang.getShoes_id()}">edit</a></td>
            <td><a href="/shoes?action=delete_shoes&id=${khachhang.getShoes_id()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>