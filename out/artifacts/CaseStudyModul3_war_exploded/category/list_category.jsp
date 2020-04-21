<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/17/20
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
    <style>
        .sho a {
            float: left;
            display: block;
            color:#FF82AB;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<center>
<h1>Category</h1>

<div class="sho">
    <a href="${pageContext.request.contextPath}/shoes">Home</a>

    <a href="${pageContext.request.contextPath}/category?action=create_category">Create new category</a>
</div>
</center>

<div>
    <form method="get" action="${pageContext.request.contextPath}/category?action=list_category">
        <div>
            <input type="text" name="status" placeholder="Enter price" style="width: 100px; height: 40px;">
            <button type="submit" value="findByStatus" >Search</button>&emsp;&emsp;

        </div>
    </form>
</div>

<table border="1" style=" width:100%;height:300px ;background-color: #FFE7BA">
    <tr>
     <td>Id</td>
        <td>Trademark</td>
        <td>Status</td>
        <td>Action</td>
    </tr>
    <c:forEach items='${requestScope["listCategory"]}' var="categories">
        <tr>
            <td>${categories.getId()}</td>
            <td>${categories.getTrademark()}</td>
            <td>${categories.getStatus()}</td>

            <td><a href="${pageContext.request.contextPath}/category?action=edit_category&id=${categories.getId()}">edit</a></td>
            <td><a href="${pageContext.request.contextPath}/category?action=delete_category&id=${categories.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>