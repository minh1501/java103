<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stored Procedure</title>
</head>
<body>

<h2>Stored Procedure Report</h2>

<table border="1">

<tr>

<th>Video</th>
<th>Likes</th>
<th>Newest</th>
<th>Oldest</th>

</tr>

<c:forEach items="${items}" var="r">

<tr>

<td>${r[0]}</td>
<td>${r[1]}</td>
<td>${r[2]}</td>
<td>${r[3]}</td>

</tr>

</c:forEach>

</table>

</body>
</html>