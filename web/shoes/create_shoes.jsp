<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Shoes</title>
</head>
<body>

<h1 style="text-align: center">Shoes Management</h1>
<h2>
    <a href="${pageContext.request.contextPath}/shoes?action=list_shoes">List All shoes</a>
</h2>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2 style="text-align: center">Add New shoes</h2>
            </caption>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" id="image" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" id="price" size="45"/>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>--%>

<%--                </th>Select a Category:&nbsp;--%>
<%--                <select name="category">--%>
<%--                    <c:forEach items="${listCategory}" var="category">--%>
<%--                        <option value="${category.id}">${category.name}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--                <br/><br/>--%>
<%--            </tr>--%>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>