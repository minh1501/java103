<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<div class="container mt-4">

    <div class="card">

        <div class="card-header bg-primary text-white">
            <h3>User Management</h3>
        </div>

        <div class="card-body">

            <!-- Message -->

            <c:if test="${not empty message}">
                <div class="alert alert-info">
                    ${message}
                </div>
            </c:if>

            <!-- Form -->

            <form method="post">

                <div class="row">

                    <div class="col-md-6">

                        <label class="form-label">
                            User ID
                        </label>

                        <input
                            type="text"
                            name="id"
                            class="form-control"
                            value="${form.id}">
                    </div>

                    <div class="col-md-6">

                        <label class="form-label">
                            Password
                        </label>

                        <input
                            type="password"
                            name="password"
                            class="form-control"
                            value="${form.password}">
                    </div>

                </div>

                <br>

                <div class="mb-3">

                    <label class="form-label">
                        Fullname
                    </label>

                    <input
                        type="text"
                        name="fullname"
                        class="form-control"
                        value="${form.fullname}">
                </div>

                <div class="mb-3">

                    <label class="form-label">
                        Email
                    </label>

                    <input
                        type="email"
                        name="email"
                        class="form-control"
                        value="${form.email}">
                </div>

                <div class="mb-3">

                    <label class="form-label">
                        Phone
                    </label>

                    <input
                        type="text"
                        name="phone"
                        class="form-control"
                        value="${form.phone}">
                </div>

                <div class="mb-3">

                    <label class="form-label">
                        Role
                    </label>

                    <br>

                    <input
                        type="radio"
                        name="admin"
                        value="true"

                        <c:if test="${form.admin}">
                            checked
                        </c:if>
                    >

                    Admin

                    &nbsp;&nbsp;

                    <input
                        type="radio"
                        name="admin"
                        value="false"

                        <c:if test="${!form.admin}">
                            checked
                        </c:if>
                    >

                    User

                </div>

                <!-- Buttons -->

                <button
                    formaction="${pageContext.request.contextPath}/user/create"
                    class="btn btn-success">

                    Create
                </button>

                <button
                    formaction="${pageContext.request.contextPath}/user/update"
                    class="btn btn-warning">

                    Update
                </button>

                <button
                    formaction="${pageContext.request.contextPath}/user/delete"
                    class="btn btn-danger">

                    Delete
                </button>

                <button
                    formaction="${pageContext.request.contextPath}/user/reset"
                    class="btn btn-secondary">

                    Reset
                </button>

            </form>

        </div>

    </div>

    <br>

    <!-- User List -->

    <div class="card">

        <div class="card-header bg-dark text-white">
            User List
        </div>

        <div class="card-body">

            <table class="table table-bordered table-hover">

                <thead>

                <tr>

                    <th>ID</th>
                    <th>Fullname</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Role</th>
                    <th>Action</th>

                </tr>

                </thead>

                <tbody>

                <c:forEach items="${items}" var="u">

                    <tr>

                        <td>${u.id}</td>

                        <td>${u.fullname}</td>

                        <td>${u.email}</td>

                        <td>${u.phone}</td>

                        <td>

                            <c:choose>

                                <c:when test="${u.admin}">
                                    Admin
                                </c:when>

                                <c:otherwise>
                                    User
                                </c:otherwise>

                            </c:choose>

                        </td>

                        <td>

                            <a
                               href="${pageContext.request.contextPath}/user/edit?id=${u.id}"
                               class="btn btn-primary btn-sm">

                                Edit

                            </a>

                        </td>

                    </tr>

                </c:forEach>

                </tbody>

            </table>

        </div>

    </div>

</div>

</body>
</html>