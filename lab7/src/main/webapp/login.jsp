<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Đăng nhập</h2>

<form action="login" method="post">

    ID:
    <input type="text" name="id">
    <br><br>

    Password:
    <input type="password" name="password">
    <br><br>

    <button type="submit">
        Login
    </button>

</form>

<p style="color:red">
    ${message}
</p>

</body>
</html>