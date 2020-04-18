<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/17/20
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>CategoryShoes</h1>
    <h2>
        <a href="category?action=list_category">List All Category</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Category</h2>
            </caption>
            <tr>
                <th>Trademark:</th>
                <td>
                    <input type="text" name="trademark" id="trademark" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <input type="text" name="status" id="status" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Create Category"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
