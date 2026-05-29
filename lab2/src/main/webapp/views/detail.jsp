<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>

<div style="width:300px;
            border:1px solid gray;
            padding:10px">

    <h2 align="center">
        ${item.name}
    </h2>

    <div align="center">

        <img src="images/${item.image}"
             width="200">

    </div>

    <hr>

    <ul>

        <li>
            Giá gốc:
            <del>$${item.price}</del>
        </li>

        <li>
            Giá mới:
            $${item.newPrice}
        </li>

        <li>
            Mức giá:
            ${item.level}
        </li>

    </ul>

    <hr>

    <div align="center">

        Ngày tạo:

        <fmt:formatDate
            value="${item.date}"
            pattern="dd-MM-yyyy"/>

    </div>

</div>

</body>
</html>