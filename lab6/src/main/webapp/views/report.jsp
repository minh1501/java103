<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Report</title>
</head>
<body>

<h2>Favorite Report</h2>

<table border="1">

<tr>

<th>Video</th>
<th>Likes</th>
<th>Newest</th>
<th>Oldest</th>

</tr>

<c:forEach
items="${items}"
var="r">

<tr>

<td>${r.group}</td>
<td>${r.likes}</td>
<td>${r.newest}</td>
<td>${r.oldest}</td>

</tr>

</c:forEach>

</table>

</body>
</html>