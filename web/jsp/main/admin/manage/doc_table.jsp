<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 30.12.2018
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Documents</title>
    <%--<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>--%>
    <script data-require="jquery@2.0.3" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

    <script>
        <%@include file="/js/modal_script.js"%>
        <%@include file="/js/table.js"%>
    </script>
    <style>
        .col {
            word-wrap: break-word; /* Перенос слов */
        }

        img {
            width: 50px;
            transition: width 0.5s ease;
        }

        #statya:hover img {
            width: 500px;
        }
    </style>
</head>
<body>

<div class="btn-toolbar">
    <button class="btn btn-primary">New User</button>
    <button class="btn">Import</button>
    <button class="btn">Export</button>
    <h2>Filterable Table</h2>
    <p>Type something in the input field to search the table for first names, last names or emails:</p>
    <input id="myInput" type="text" placeholder="Search..">
    <br><br>
</div>
<div class="well">

    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Photo</th>
            <th>Owner statement</th>
            <th>Type statement</th>
            <th>Information</th>
            <th>Reward</th>
            <th>Date</th>
            <th>Lead date</th>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody id="myTable">
        <c:forEach var="doc" items="${docs}">
            <tr>

                <td>${doc.getDocId()}</td>
                <td id="statya">
                    <c:choose>
                    <c:when test="${not empty doc.encodedPhoto}">
                        <img src="data:image/jpeg;base64,${doc.encodedPhoto}"/>
                    </c:when>
                    <c:otherwise>
                        -
                    </c:otherwise>
                </c:choose>
                </td>
                <td>${doc.getName()} ${doc.getLastName()}</td>
                <td>${doc.getStatement()}</td>
                <td style="width: 320px;">
                    <div class="col" style="width: 280px">
                            ${doc.getInformation()}
                    </div>
                </td>
                <td>${doc.getReward()}</td>
                <td>${doc.getTime()}</td>
                <td>${doc.getLeadTime()}</td>
                <td>
                    <form action="/interpol" method="get">
                        <input type="hidden" value="APPROVE_PAGE" name="command">
                        <a href="interpol?command=APPROVE_PAGE&id=${doc.getDocId()}"><i class="icon-pencil"></i></a>
                    </form>
                    <form action="/interpol" method="get">
                        <input type="hidden" value="REMOVE_DOC" name="command">
                        <a href="interpol?command=REMOVE_DOC&id=${doc.getDocId()}"><i class="icon-remove"></i></a>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="pagination">
    <ul>
        <li><a href="#">Prev</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</div>
<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>


<a href="/jsp/main/main.jsp">Back</a>
</body>
</html>


