<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body class="hgu">
<ul class="nav justify-content-center navbar-light bg-light">
    <li class="btn btn-sm btn-light">
        <a class="nav-link" href="/main?command=upcoming">Home</a>
    </li>
    <li class="btn dropdown btn-light btn-sm">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
           aria-haspopup="true" aria-expanded="false">
            Confs
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="/main?command=upcoming">Upcoming</a>
            <a class="dropdown-item" href="#">Past</a>
            <a class="dropdown-item" href="#">My confs</a>
        </div>
    </li>
    <li class="btn btn-light btn-sm">
        <a class="nav-link" href="#">Ratings</a>
    </li>
    <li class="btn btn-light btn-sm">
        <a class="nav-link" href="#">Offer report</a>
    <li class="btn btn-light btn-sm">
        <a class="nav-link" href="#">My bonuses</a>
    </li>
    <li class="btn btn-light btn-sm">
        <a class="nav-link" href="#">Edit users</a>
    </li>
    <li class="btn justify-content-left btn-light btn-sm">
        <a class="nav-link" href="/main?command=logOut">LogOut</a>
    </li>
    </li>
</ul>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
