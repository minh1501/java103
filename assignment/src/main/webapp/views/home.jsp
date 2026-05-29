<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<title>ONLINE ENTERTAINMENT</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
}

body{
    font-family: Arial;
    background:#f5f5f5;
}

.container{
    width:1200px;
    margin:auto;
}

/* MENU */

.menu{
    width:100%;
    height:80px;
    background:#f6b800;
    border-radius:15px;
    margin-top:20px;
    box-shadow:0 2px 10px rgba(0,0,0,0.2);
}

.menu ul{
    list-style:none;
    display:flex;
    align-items:center;
    height:100%;
}

.menu ul li{
    margin-left:50px;
}

.menu ul li a{
    text-decoration:none;
    font-size:22px;
    font-weight:bold;
    color:#2b33ff;
}

.logo{
    color:red !important;
    font-size:32px !important;
    text-shadow:2px 2px 3px #999;
}

/* VIDEO GRID */

.video-list{
    margin-top:40px;
    display:grid;
    grid-template-columns:repeat(3,1fr);
    gap:30px;
}

.card{
    border:1px solid #ff9b4a;
    background:white;
    padding:15px;
}

.poster{
    width:100%;
    height:220px;
    border:1px solid #ff9b4a;
    overflow:hidden;
}

.poster img{
    width:100%;
    height:100%;
    object-fit:cover;
}

.title{
    background:#dfead8;
    padding:15px 10px;
    margin-top:10px;
    font-size:28px;
    font-weight:bold;
    font-variant:small-caps;
}

.action{
    text-align:right;
    margin-top:15px;
}

.btn{
    padding:8px 18px;
    border:none;
    border-radius:6px;
    text-decoration:none;
    color:white;
    font-size:22px;
    margin-left:10px;
    font-weight:bold;
}

.like{
    background:#58b81b;
}

.share{
    background:#ff7b00;
}

/* PAGING */

.paging{
    margin-top:30px;
    text-align:center;
}

.paging a{
    text-decoration:none;
    background:#bfbfbf;
    color:white;
    padding:10px 20px;
    margin:5px;
    border-radius:8px;
    font-size:24px;
    box-shadow:0 2px 5px rgba(0,0,0,0.3);
}

/* CLEAR */

.clear{
    clear:both;
}

</style>

</head>

<body>

<div class="container">

    <!-- MENU -->

    <div class="menu">

        <ul>

            <li>
                <a class="logo" href="home">
                    ONLINE ENTERTAINMENT
                </a>
            </li>

            <li>
                <a href="favorite">
                    My Favorites
                </a>
            </li>

            <li>
                <a href="login">
                    My Account
                </a>
            </li>

        </ul>

    </div>

    <!-- VIDEO -->

    <div class="video-list">

        <c:forEach items="${videos}" var="v">

            <div class="card">

                <div class="poster">

                    <a href="detail?id=${v.id}">

                        <img src="images/${v.poster}">

                    </a>

                </div>

                <div class="title">

                    ${v.title}

                </div>

                <div class="action">

                    <a class="btn like"
                    href="like?id=${v.id}">
                        Like
                    </a>

                    <a class="btn share"
                    href="share?id=${v.id}">
                        Share
                    </a>

                </div>

            </div>

        </c:forEach>

    </div>

    <!-- PAGING -->

    <div class="paging">

        <a href="#">|&lt;</a>

        <a href="#">&lt;&lt;</a>

        <a href="#">&gt;&gt;</a>

        <a href="#">&gt;|</a>

    </div>

</div>

</body>
</html>