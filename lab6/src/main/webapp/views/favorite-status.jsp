<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite Status</title>
</head>
<body>

<h2>Videos Đã Có Người Thích</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Title</th>
<th>Views</th>
</tr>

<c:forEach items="${favoriteVideos}" var="v">

<tr>
<td>${v.id}</td>
<td>${v.title}</td>
<td>${v.views}</td>
</tr>

</c:forEach>

</table>

<br><br>

<h2>Videos Chưa Có Người Thích</h2>

<table border="1">

<tr>
<th>ID</th>
<th>Title</th>
<th>Views</th>
</tr>

<c:forEach items="${notFavoriteVideos}" var="v">

<tr>
<td>${v.id}</td>
<td>${v.title}</td>
<td>${v.views}</td>
</tr>

</c:forEach>

</table>

</body>
</html>