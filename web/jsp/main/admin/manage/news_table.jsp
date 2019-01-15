<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>News</title>
    <script data-require="jquery@2.0.3" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script data-require="jquery@1.10.19" data-semver="1.10.19" type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <script>
        <%@include file="/js/modal_script.js"%>
        <%@include file="/js/table.js"%>
    </script>
    <style>

        img {
            width: 250px;
            transition: width 0.5s ease;
        }

    </style>
</head>
<body>

<c:set var="language" value="${sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties.text" var="local"/>
<fmt:message bundle="${local}" key="back" var="back"/>

<form action="/interpol" method="get">
    <input type="hidden" value="NEWS_ADD_PAGE" name="command">
    <div class="btn-toolbar">
        <p>Add news</p>
        <button type="submit" class="fa fa-plus"></button>
    </div>
</form>

<div class="well">
    <table class="table table-striped table-bordered table-hover" id="table_id">
        <thead>
        <tr>
            <th>#</th>
            <th>Photo</th>
            <th>Topic</th>
            <th>Information</th>
            <td>Country</td>
            <td>Date</td>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="news" items="${news}">
            <tr>

                <td>${news.getNewsId()}</td>
                <td>
                    <c:choose>
                        <c:when test="${not empty news.encodedPhoto}">
                            <img src="data:image/jpeg;base64,${news.encodedPhoto}"/>
                        </c:when>
                        <c:otherwise>
                            -
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${news.getTopic()}</td>
                <td style="width: 320px;">
                    <div class="col" style="width: 280px">
                            ${news.getInformation()}
                    </div>
                </td>
                <td>${news.getCountry()}</td>
                <td>${news.getTime()}</td>

                <td>
                    <form action="/interpol" method="get">
                        <input type="hidden" value="REMOVE_NEWS" name="command">
                        <a href="interpol?command=REMOVE_NEWS&id=${doc.getNewsId()}"><i
                                class="icon-fixed-width icon-trash"></i></a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a style="padding-top: 100px;padding-bottom: 100px" href="/jsp/main/main.jsp">${back}</a>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>

    <infotag:getinfo/>
</div>

</body>
</html>
