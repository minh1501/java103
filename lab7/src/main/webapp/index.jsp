<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

<c:choose>

    <c:when test="${empty sessionScope.user}">

        <h2>Welcome you</h2>

        <a href="login">
            Đăng nhập
        </a>

    </c:when>

    <c:otherwise>

        <h2>
            Welcome
            ${sessionScope.user.fullname}
        </h2>

        <a href="logout">
            Đăng xuất
        </a>

        <br><br>

        <c:if test="${sessionScope.user.admin}">

            <a href="admin/home.jsp">
                Quản trị hệ thống
            </a>

        </c:if>

    </c:otherwise>

</c:choose>

<hr>

<h3>
    Visitors:
    ${applicationScope.visitors}
</h3>

</body>
</html>