<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/17/20
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title style="text-align: center">Shoes Manager</title>
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

    <a style="text-align: center" href="shoes?action=list_shoes">List All Shoes</a>
</div>
</center>


<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Shoes
                </h2>
            </caption>
            <tr>
                <th>Image:</th>
                <td>
                    <input type="text" name="image" size="100"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="100"/>
                </td>
            </tr><tr>
            <th>Price:</th>
            <td>
                <input type="text" name="price" size="100"/>
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