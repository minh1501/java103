<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Home</title>

    <style>

        body{
            font-family: Arial;
            background: #f2f2f2;
        }

        .container{
            width: 500px;
            margin: 100px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 0 10px gray;
        }

        h1{
            color: green;
        }

        a{
            text-decoration: none;
            color: white;
            background: red;
            padding: 10px 20px;
            border-radius: 5px;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>
        Đăng nhập thành công
    </h1>

    <h3>
        Xin chào:
        ${sessionScope.username}
    </h3>

    <br>

    <a href="logout">
        Logout
    </a>

</div>

</body>

</html>