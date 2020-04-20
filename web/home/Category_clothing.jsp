<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/20/20
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clothing List</title>
</head>
<body>
<h1>Clothing</h1>
<p>
    <a href="${pageContext.request.contextPath}/shoes?action=list_shoes">Shoes</a>
    <a href="${pageContext.request.contextPath}/category?action=list_category">Category</a>
</p>

<form action="${pageContext.request.contextPath}/clothing" method="get">
    <input type="hidden" name="action" value="findByPrice"/>
    <select name="status">
        <c:forEach items='${requestScope["price"]}' var="status">
            <option name="status">${status}</option>
        </c:forEach>
    </select>
    <button type="submit">Tìm kiếm </button>
</form>

<table border="1">
    <tr>
        <td>Image</td>
        <td>Name</td>
        <td>price</td>
        <td>trademark</td>
        <td>status</td>
    </tr>
    <c:forEach items='${requestScope["shoes"]}' var="shoe">
        <tr>
            <td>${shoe.getImage_link()}</td>
            <td>${shoe.getName_shoes()}</td>
            <td>${shoe.getPrice()}</td>
            <td>${shoe.getTrademark()}</td>
            <td>${shoe.getStatus()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
