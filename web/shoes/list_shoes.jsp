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
    <style>
        .sho a {
            float: left;
            display: block;
            color: #FF82AB;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<center>
<h1>Shoes</h1>
<div class="sho">
    <a href="${pageContext.request.contextPath}/shoes">Home</a>

    <a href="/shoes?action=create_shoes">Create new shoes</a>
</div>
</center>
<div>
    <form method="get" action="${pageContext.request.contextPath}/shoes?action=list_shoes">
        <div>
            <input type="text" name="price" placeholder="Enter price" style="width: 100px; height: 40px;">
            <button type="submit" value="findByPrice">Search</button>&emsp;&emsp;

        </div>
    </form>
</div>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Image</td>
        <td>Nme</td>
        <td>Price</td>
        <td>action</td>
    </tr>

    <c:forEach items='${requestScope["listShoes"]}' var="khachhang">
        <tr>
            <td>${khachhang.getShoes_id()}</td>
            <td><img src="${khachhang.getImage_link()}"alt="img" width="70%" height="auto" ></td>
            <td>${khachhang.getName_shoes()}</td>
            <td>${khachhang.getPrice()}</td>
            <td><a href="/shoes?action=edit_shoes&id=${khachhang.getShoes_id()}">edit</a></td>
            <td><a href="/shoes?action=delete_shoes&id=${khachhang.getShoes_id()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>