
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
<%--    <link href="../../css/login.css" rel="stylesheet" >--%>
<%--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>--%>
<%--    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
    <style>
        form{
            border: 3px solid #f1f1f1;

        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 10px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        span{
            text-decoration: underline;

        }
        img.anh{
            width: 500px;
        }
    </style>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <div class="fadeIn first">
            <img src="https://giare.net/wp-content/uploads/2016/06/thiet-ke-logo-giay-04.jpg" id="icon" class="anh" alt="User Icon" />
        </div>

        <form method="post" action="${pageContext.request.contextPath}/login">
          <span>Email:</span><input type="text" id="login" class="fadeIn second" name="email" placeholder="email">
          <span>Password:</span><input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>
    </div>
</div>
</body>
</html>