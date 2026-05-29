<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>Danh sách nhân viên</h2>

<a href="employees?action=create">
    Thêm mới
</a>

<table border="1" width="700">

<tr>
    <th>Code</th>
    <th>Họ tên</th>
    <th>Email</th>
    <th>Action</th>
</tr>

<c:forEach items="${list}" var="e">

<tr>

    <td>${e.empCode}</td>
    <td>${e.fullName}</td>
    <td>${e.email}</td>

    <td>

        <a href="employees?action=view&code=${e.empCode}">
            View
        </a>

        |

        <a href="employees?action=edit&code=${e.empCode}">
            Edit
        </a>

        |

        <a href="employees?action=delete&code=${e.empCode}">
            Delete
        </a>

    </td>

</tr>

</c:forEach>

</table>

</body>
</html>