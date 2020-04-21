<%--
  Created by IntelliJ IDEA.
  User: hien
  Date: 4/20/20
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shoes Category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="./css/style.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;

        }

        /* Định dạng header */
        .header {
            background-color: #e9d8f4;
            color: #58257b;
            padding: 10px;
            text-align: center;
        }

        /* Định dạng thanh điều hướng trên cùng */
        .topnav {
            overflow: hidden;
            background-color: #58257b;
        }

        /* Định dạng link điều hướng */
        .topnav a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        /* Thay đổi màu liên kết khi di chuột qua */
        .topnav a:hover {
            background-color: #db7093;
            color: white;
            font-weight: bold
        }
        .fakeimg {
            background-color: #baa1cc;
            /*width: 20%;*/
            /*padding: 20px;*/
        }
        .leftcolumn {
            float: right;
            width: 20%;
            background-color: #e9d8f4;
            padding-left: 10px;
        }
        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }
        img.avta{
            width: 200px;
            height: 250px;
        }
        img.avt{
            width: 1270px;
            height: 400px;
            padding: 25px;
            background-color: powderblue
        }

            .footer {
                background-color: #e9d8f4;
                color: #58257b;
                padding: 1px;
                text-align: center;
            }


    </style>
</head>
<body>
<div class="header">
    <h1>CoCo Shop</h1>
</div>

<div class="topnav">
    <a href="#">Home</a>
    <a href="${pageContext.request.contextPath}/shoes?action=list_shoes">Shoes</a>
    <a href="${pageContext.request.contextPath}/category?action=list_category">Category</a>
</div>

<div >
    <img src="https://giaydatino.vn/wp-content/uploads/2018/10/cac-hang-giay-sneaker-noi-tieng.jpg" class="avt" alt="User Icon" />
</div>

<%--<form action="${pageContext.request.contextPath}/shoes" method="get">--%>
<%--    <input type="hidden" name="action" value="findByPrice"/>--%>
<%--    <select name="status">--%>
<%--        <c:forEach items='${requestScope["price"]}' var="status">--%>
<%--            <option name="status">${status}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <button type="submit">Tìm kiếm </button>--%>
<%--</form>--%>
<div class="leftcolumn">
    <div class="card">
        <h2>Nămg động với mùa hè !</h2>
        <div class="fakeimg">
            <img src="https://cdn.nhanh.vn/cdn/store/7136/artCT/26315/coverfb.png" class="avta" alt="User Icon" />
        </div>
        <p>Hay trao cho chô gái một đôi giày phù hợp ,cô ấy sẽ chinh phục cả thế giới .</p>
    </div>

    <div class="card">
        <h3>Nổi bật</h3>
        <div class="fakeimg">
            <img src="https://znews-photo.zadn.vn/w660/Uploaded/wopthuo/2017_06_14/VANS.jpg"class="avta">
        </div>
        <div class="fakeimg">
            <img src="https://giaybom.com/image/top-5-mau-giay-the-thao-nu-lam-nang-me-man-tu-cai-nhin-dau-tien141020191401016725.jpg" class="avta">
        </div>
        <div class="fakeimg">
            <img src="https://anhvienshop.com/wp-content/uploads/2019/07/1-456.jpg" class="avta">
        </div>
    </div>
    
    <div class="card">
        <h3>Follow Me</h3>
        <p>Facebook </p>
        <p>CoCoShop:https:fakfab/sjdf</p>
        <p>Shoppe</p>
        <p>Yhttps://www.com/watch?v=6CEC6gQTBOY</p>
    </div>

</div>
</div>
</div>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Image</td>
        <td>Name</td>
        <td>price</td>
        <td>trademark</td>
        <td>status</td>
    </tr>
    <c:forEach items='${requestScope["shoes"]}' var="shoe">
        <tr>
            <td>${shoe.getShoes_id()}</td>
            <td><img src="${shoe.getImage_link()}"alt="img" width="70%" height="auto" ></td>
            <td>${shoe.getName_shoes()}</td>
            <td>${shoe.getPrice()}</td>
            <td>${shoe.getTrademark()}</td>
            <td>${shoe.getStatus()}</td>
        </tr>
    </c:forEach>
</table>
<div class="footer">
    <h4>Liên hệ</h4>
    <p>Địa chỉ: 56 Duy Tân, Dịch Vọng Hậu, Cầu Giấy, Hà Nội.</p>
    <p>Điện thoại: 024 2242 6188.</p>
    <p>Email: info@meta.vn.</p></div>
</body>
</html>
