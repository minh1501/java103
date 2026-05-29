<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Login</title>

    <style>

        body{
            font-family: Arial;
            background: #f2f2f2;
        }

        .container{
            width: 350px;
            margin: 100px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px gray;
        }

        h2{
            text-align: center;
        }

        input{
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            margin-bottom: 15px;
        }

        button{
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover{
            background: #0056b3;
        }

        .error{
            color: red;
            text-align: center;
        }

    </style>

</head>

<body>

<div class="container">
    <h2>ĐĂNG NHẬP</h2>

    <form action="login" method="post">
        <label>Username</label>
        <input
                type="text"
                name="username"
                required >
        <label>Password</label>

        <input
                type="password"
                name="password"
                required>

        <button type="submit">
            Login
        </button>

    </form>

    <p class="error">
        ${message}
    </p>

</div>

</body>

</html>