<html>
<body>

<h2>Sửa nhân viên</h2>

<form action="employees" method="post">

    <input type="hidden"
           name="action"
           value="update">

    Mã:
    <input type="text"
           name="empCode"
           value="${emp.empCode}"
           readonly>

    <br><br>

    Họ tên:
    <input type="text"
           name="fullName"
           value="${emp.fullName}">

    <br><br>

    Email:
    <input type="text"
           name="email"
           value="${emp.email}">

    <br><br>

    <button type="submit">
        Update
    </button>

</form>

</body>
</html>
