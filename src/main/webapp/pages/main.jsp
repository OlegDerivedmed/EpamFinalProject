<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Conferences</title>
</head>
<body>
<%@include file="menu.jsp" %>
<%--<c:forEach var="conf" items="${requestScope.confs}">--%>
<%--<li><c:out value="${conf.name}"/></li>--%>
<%--<c:forEach var="report" items="${conf.reports}">--%>
<%--<li><c:out value="${report.report_name}"/></li>--%>
<%--</c:forEach>--%>
<%--</c:forEach>--%>
<ul class="list-group">
    <c:forEach var="conf" items="${requestScope.confs}">
        <li class="list-group-item"><c:out value="${conf.name}"/>
            <p><c:out value="${conf.place}"/></p>
            <div class="form-group row">
                <label for="example-datetime-local-input" class="col-2 col-form-label"></label>
                <div class="col-10">
                    <input class="form-control" type="datetime-local" value="${conf.date}" id="example-datetime-local-input">
                </div>
            </div>
            <%--<p>When : <c:out value="${conf.date}"/></p>--%>
            <ul class="list-group">
                <c:forEach var="report" items="${conf.reports}">
                    <form method="post" action="/main">
                        <input type="hidden" name="command" value="regToRep">
                        <input type="hidden" name="reportId" value="${report.id}">
                        <c:out value="${report.report_name}"/>
                        <button class="btn btn-dark">Register</button>
                    </form>
                </c:forEach>
            </ul>
        </li>
    </c:forEach>
</ul>

</body>
</html>
