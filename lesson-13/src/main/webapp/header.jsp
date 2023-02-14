<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="css/header.css">
    <title>Header</title>
</head>

<body>
    <div id="wrapper" class="animate">
        <nav class="navbar header-top fixed-top navbar-expand-lg navbar-dark">
            <span class="navbar-toggler-icon leftmenutrigger"></span>
            <a class="navbar-brand" href="#">MAGAZINES</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText">
                <ul class="navbar-nav animate side-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cabinet.jsp">Homepage</a>
                    </li>
                    <li class="nav-item create-magazine-option">
                        <a class="nav-link" href="${pageContext.request.contextPath}/createMagazine.jsp">Add
                            magazines</a>
                    </li>
                    <li class="nav-item user-subscribe-option">
                        <a class="nav-link" href="${pageContext.request.contextPath}/subscribes.jsp">Subscribes</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-md-auto d-md-flex">
                    <li class="nav-item">
                        <button class="nav-link magazine-logout">LogOut</button>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <script src="js/header.js"></script>
</body>

</html>