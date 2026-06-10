<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite By User</title>
</head>

<body>

<h2>Favorite By User</h2>

<form method="post">

User ID:

<input
type="text"
name="userId">

<button>
Search
</button>

</form>

<hr>

<table border="1">

<tr>
<th>ID</th>
<th>Video</th>
<th>Like Date</th>
</tr>

<c:forEach
items="${items}"
var="f">

<tr>

<td>${f.id}</td>

<td>${f.video.title}</td>

<td>${f.likeDate}</td>

</tr>

</c:forEach>

</table>

</body>
</html>