<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

        /*#statya:hover img {*/
        /*width: 500px;*/
        /*}*/
    </style>
</head>
<body>
<form action="/interpol" method="get">
    <input type="hidden" value="NEWS_ADD_PAGE" name="command">
    <div class="btn-toolbar">
        <button type="submit" class="btn btn-primary">Add event</button>
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
                        <%--<form action="/interpol" method="get">--%>
                        <%--<input type="hidden" value="APPROVE_PAGE" name="command">--%>
                        <%--<a href="interpol?command=APPROVE_PAGE&id=${doc.getDocId()}"><i class="icon-pencil"></i></a>--%>
                        <%--</form>--%>
                    <form action="/interpol" method="get">
                        <input type="hidden" value="REMOVE_NEWS" name="command">
                        <a href="interpol?command=REMOVE_NEWS&id=${doc.getNewsId()}"><i class="icon-remove"></i></a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<a style="padding-top: 100px;padding-bottom: 100px" href="/jsp/main/main.jsp">Back</a>

<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>

    <infotag:getinfo/>
</div>

</body>
</html>
