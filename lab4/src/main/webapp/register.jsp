<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>Form Đăng Ký</h2>

<form action="register" method="post">

    Họ tên:
    <input type="text" name="fullname">
    <br>

    <span style="color:red">
        ${errors.fullname}
    </span>

    <br>

    Email:
    <input type="text" name="email">
    <br>

    <span style="color:red">
        ${errors.email}
    </span>

    <br>

    Giới tính:

    <input type="radio"
           name="gender"
           value="Nam"> Nam

    <input type="radio"
           name="gender"
           value="Nữ"> Nữ

    <br><br>

    Chuyên ngành:

    <select name="major">
        <option>CNTT</option>
        <option>Marketing</option>
        <option>Thiết kế</option>
    </select>

    <br><br>

    <button type="submit">
        Đăng ký
    </button>

</form>

</body>
</html>