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
</head>
<body>

<h1 style="text-align: center">Shoes</h1>
<h2>
    <a style="text-align: center" href="shoes?action=list_shoes">List All Shoes</a>
</h2>

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
                    <input type="text" name="image" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input type="text" name="name" size="45"/>
                </td>
            </tr><tr>
            <th>Price:</th>
            <td>
                <input type="text" name="price" size="45"/>
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