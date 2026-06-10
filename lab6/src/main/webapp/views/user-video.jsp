<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User By Video</title>
</head>
<body>

<h2>User By Video</h2>

<form method="post">

Video ID:

<input
type="text"
name="videoId">

<button>
Search
</button>

</form>

<hr>

<table border="1">

<tr>
<th>ID</th>
<th>Fullname</th>
<th>Email</th>
</tr>

<c:forEach
items="${items}"
var="u">

<tr>

<td>${u.id}</td>
<td>${u.fullname}</td>
<td>${u.email}</td>

</tr>

</c:forEach>

</table>

</body>
</html>