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

    <script>
        <%@include file="/js/modal_script.js"%>
        <%@include file="/js/table.js"%>
    </script>


</head>

<body>

<form action="/interpol" method="get">
    <input type="hidden" value="REMOVE_USER" name="command">
    <div class="btn-toolbar">
        <button class="btn btn-primary">New User</button>
        <button class="btn">Import</button>
        <button class="btn">Export</button>
        <%--<div>--%>
        <%--<input type="text" name="id"> Delete by id</input>--%>
            <%--<button type="submit" name="id"><i class="icon-remove"></i></button>--%>
        <%--</div>--%>
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
                <th>First Name</th>
                <th>Last Name</th>
                <td>Birthday</td>
                <td>Telephone</td>
                <td>Address</td>
                <th style="width: 36px;"></th>
            </tr>
            </thead>
            <tbody id="myTable">
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
                        <a href="user.html"><i class="icon-pencil"></i></a>
                        <%--<a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>    --%>
                        <a href="interpol?command=REMOVE_USER&id=${user.getUserId()}"><i class="icon-remove"></i></a>
                    </td>
                </tr>
                </c:if>
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
</form>

<form id="del" action="/interpol" method="get">
<input type="hidden" value="REMOVE_USER" name="command">
<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text">Are you sure you want to delete the user?</p>
    </div>

    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal" name="" onclick="document.getElementById('del').submit();">Delete</button>
    </div>
</div>
</form>
<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">Back</a>

</body>
</html>


