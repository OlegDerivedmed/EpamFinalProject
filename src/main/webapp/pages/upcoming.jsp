<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upcoming confs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<%@include file="menu.jsp" %>
<%--<ul class="list-group">--%>
<%--<c:forEach var="conf" items="${requestScope.confs}">--%>
<%--<li class="list-group-item"><c:out value="${conf.name}"/>--%>
<%--<p><c:out value="${conf.place}"/></p>--%>
<%--<div class="form-group row">--%>
<%--<label for="example-datetime-local-input" class="col-2 col-form-label"></label>--%>
<%--<div class="col-10">--%>
<%--<input class="form-control" type="text" value="${conf.date}" id="example-datetime-local-input">--%>
<%--</div>--%>
<%--</div>--%>
<%--&lt;%&ndash;<p>When : <c:out value="${conf.date}"/></p>&ndash;%&gt;--%>
<%--<ul class="list-group">--%>
<%--<c:forEach var="report" items="${conf.reports}">--%>
<%--<form method="post" action="/main">--%>
<%--<input type="hidden" name="command" value="regToRep">--%>
<%--<input type="hidden" name="reportId" value="${report.id}">--%>
<%--<c:out value="${report.report_name}"/>--%>
<%--<button class="btn btn-dark">Register</button>--%>
<%--</form>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ul>--%>
<ul class="list-group w-75" style="margin: auto; padding-top: 5px;">
    <c:forEach var="conf" items="${requestScope.confs}">
        <li class="list-group-item list-group-item-info text-center"><h4><c:out value="${conf.name}"/></h4></li>
        <li class="list-group-item list-group-item-info text-center"><h5><c:out value="${conf.place}"/></h5></li>
        <li class="list-group-item list-group-item-info text-center"><h5><fmt:formatDate pattern="dd MMM yyyy HH:mm"
                                                                                         value="${conf.date}"/></h5>
        </li>
        <%--<li class="list-group-item list-group-item-info text-center"><h5><c:out value="${conf.date}"/></h5></li>--%>
        <li class="list-group-item">
            <ul class="list-group">
                <c:forEach var="report" items="${conf.reports}">
                    <li class="list-group-item">
                        <form method="post" action="/main">
                            <input type="hidden" name="command" value="regToRep">
                            <input type="hidden" name="reportId" value="${report.id}">
                            <div class="row">
                                <div class="col-8">
                                    <span><c:out value="${report.report_name}"/></span>
                                </div>
                                <div class="col-4" style="text-align: right;">
                                    <button class="btn btn-dark btn-sm" <c:out
                                            value="${sessionScope.isRegistered.get(report.id)}"/>>Register
                                    </button>
                                </div>
                            </div>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
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
