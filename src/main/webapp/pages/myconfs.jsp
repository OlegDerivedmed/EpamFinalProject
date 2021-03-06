<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Confs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<%@include file="menu.jsp" %>
<ul class="list-group w-75" style="margin: auto; padding-top: 5px;">
        <li class="list-group-item">
            <ul class="list-group">
                <c:forEach var="report" items="${requestScope.reports}">
                    <li class="list-group-item">
                        <form method="post" action="/main">
                            <input type="hidden" name="command" value="regToRep">
                            <input type="hidden" name="reportId" value="${report.id}">
                            <div class="row">
                                <div class="col-8">
                                    <p><c:out value="${report.report_name}"/></p>
                                </div>
                            </div>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </li>
</ul>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
</body>
</html>
