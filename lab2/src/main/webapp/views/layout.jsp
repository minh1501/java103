<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<body>

<h1>Online Shopping Mall</h1>

<!-- include tĩnh -->
<%@ include file="menu.jsp" %>

<table width="100%">

    <tr>

        <td width="75%">

            <!-- include động -->
            <jsp:include page="item.jsp">
                <jsp:param name="name"
                           value="Sản phẩm 1"/>

                <jsp:param name="image"
                           value="sp1.jpg"/>
            </jsp:include>

            <br>

            <jsp:include page="item.jsp">
                <jsp:param name="name"
                           value="Sản phẩm 2"/>

                <jsp:param name="image"
                           value="sp2.jpg"/>
            </jsp:include>

        </td>

        <td width="25%" valign="top">

            <jsp:include page="login.jsp"/>

            <hr>

            <jsp:include page="category.jsp"/>

        </td>

    </tr>

</table>

</body>
</html>