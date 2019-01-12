<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 30.12.2018
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage users</title>
    <script data-require="jquery@2.0.3" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script data-require="jquery@1.10.19" data-semver="1.10.19"  type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <script>
        <%@include file="/js/modal_script.js"%>
        <%@include file="/js/table.js"%>
    </script>
    <style>
        .col {
            word-wrap: break-word; /* Перенос слов */
        }
    </style>

</head>

<body>

    <div class="btn-toolbar">
        <button type="submit" class="btn btn-primary">Add </button>
    </div>



<div class="container">
    <table class="table table-striped table-bordered table-hover" id="table_id">
        <thead>
        <tr>
            <th>#</th>
            <th>First Name</th>
            <th>Last Name</th>
            <td>Birthday</td>
            <td>Telephone</td>
            <td>Address</td>
            <th style="width: 36px;"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <c:if test="${user.isType() == false}">
                <tr>
                    <td>${user.getUserId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getBirthday()}</td>
                    <td>${user.getTelephone()}</td>
                    <td>${user.getAddress()}</td>
                    <td>
                            <%--<a href=""><i class="icon-pencil"></i></a>--%>
                        <form action="/interpol" method="get">
                            <input type="hidden" value="REMOVE_USER" name="command">
                            <a href="interpol?command=REMOVE_USER&id=${user.getUserId()}"><i
                                    class="icon-remove"></i></a>
                        </form>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">Back</a>

</body>
</html>


