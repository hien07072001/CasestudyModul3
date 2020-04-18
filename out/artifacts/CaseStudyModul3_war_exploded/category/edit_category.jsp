<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/17/20
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title style="text-align: center">Category Manager</title>
</head>
<body>

<h1 style="text-align: center">Category</h1>
<h2>
    <a style="text-align: center" href="category?action=list_category">List All Category</a>
</h2>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Category
                </h2>
            </caption>
            <tr>
                <th>Trademark:</th>
                <td>
                    <input type="text" name="trademark" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <input type="text" name="status" size="45"/>
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