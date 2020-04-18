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
</head>
<body>
<h1>Category</h1>
<p>
    <%--    //<a href="${pageContext.request.contextPath}/clothing?action=createClothing">Create new clothing</a>--%>
    <a href="${pageContext.request.contextPath}/category?action=create_category">Create new category</a>
</p>
<div>
    <form method="get" action="${pageContext.request.contextPath}/category?action=list_category">

        <button type="submit" name="action" value="search">Tìm kiếm</button>
    </form>
</div>
<table border="1">
    <tr>
<%--        <td>ID</td>--%>
        <td>Trademark</td>
        <td>Status</td>
        <td>Action</td>
    </tr>


    <c:forEach items='${requestScope["listCategory"]}' var="categories">
        <tr>
<%--            <td>${categories.getID()}</td>--%>
            <td>${categories.getTrademark()}</td>
            <td>${categories.getStatus()}</td>
            <td><a href="/category?action=edit_category&id=${categories.getId()}">edit</a></td>
            <td><a href="/category?action=delete_category&id=${categories.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>