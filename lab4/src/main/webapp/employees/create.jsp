<html>
<body>

<h2>Thêm nhân viên</h2>

<form action="employees" method="post">

    <input type="hidden"
           name="action"
           value="insert">

    Mã:
    <input type="text" name="empCode">
    <br><br>

    Họ tên:
    <input type="text" name="fullName">
    <br><br>

    Email:
    <input type="text" name="email">
    <br><br>

    <button type="submit">
        Thêm
    </button>

</form>

</body>
</html>