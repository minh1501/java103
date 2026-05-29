<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h1 align="center">
    DANH SÁCH SẢN PHẨM
</h1>

<table width="100%">

    <tr>

        <c:forEach var="p"
                   items="${items}"
                   varStatus="i">

            <td align="center">

                <div style="
                    border:1px solid gray;
                    width:250px;
                    padding:10px;
                    margin:10px">

                    <a href="detail">

                        <img src="images/${p.image}"
                             width="200"
                             height="180">

                    </a>

                    <h3>

                        <a href="detail">

                            ${p.name}

                        </a>

                    </h3>

                    <p>
                        Giá:
                        $${p.newPrice}
                    </p>

                </div>

            </td>

            <!-- xuống hàng sau mỗi 3 sản phẩm -->

            <c:if test="${(i.index + 1) % 3 == 0}">
                </tr>
                <tr>
            </c:if>

        </c:forEach>

    </tr>

</table>

</body>
</html>