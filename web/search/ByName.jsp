<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/19/20
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select User By Name</title>
</head>
<body>
<center>
    <h1>Select User By Name</h1>
    <h2>
        <a href="/category">List all category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <div>Enter name: <input type="text" id="price" name="price" size="30"></div>
        <input type="submit" id="submit" name="submit" value="Search">

        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h4>Select users by name</h4></caption>
                <tr>
                    <th>ID</th>
                    <th>trademark</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="category" items="${category_trademark}">
                    <tr>
                        <td><c:out value="${category.id}"/></td>
                        <td><c:out value="${category.trademark}"/></td>
                        <td><c:out value="${category.status}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</div>
</body>
</html>