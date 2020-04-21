<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new Shoes</title>
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
    <h1 style="text-align: center">Shoes Management</h1>
    <div>
        <a href="${pageContext.request.contextPath}/shoes">Home</a>

        <a href="${pageContext.request.contextPath}/shoes?action=list_shoes">List All shoes</a>
    </div>

</center>
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