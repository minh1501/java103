<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">

    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Remember</th>
    </tr>

    <c:forEach var="u"
               items="${items}">

        <tr>

            <td>${u.username}</td>

            <td>${u.password}</td>

            <td>
                ${u.remember?'Yes':'No'}
            </td>

        </tr>

    </c:forEach>

</table>