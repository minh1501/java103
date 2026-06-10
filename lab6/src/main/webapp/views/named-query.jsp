<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Named Query</title>
</head>
<body>

<h2>Named Query</h2>

<form method="post">

Keyword:

<input type="text" name="keyword">

<button>Search</button>

</form>

<hr>

<table border="1">

<tr>
<th>ID</th>
<th>Title</th>
<th>Views</th>
</tr>

<c:forEach items="${items}" var="v">

<tr>

<td>${v.id}</td>
<td>${v.title}</td>
<td>${v.views}</td>

</tr>

</c:forEach>

</table>

</body>
</html>