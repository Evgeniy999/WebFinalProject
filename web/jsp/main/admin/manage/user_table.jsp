<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>

<body>

<div class="btn-toolbar">
    <button class="btn btn-primary">New User</button>
    <button class="btn">Import</button>
    <button class="btn">Export</button>
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
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.getUserId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getBirthday()}</td>
                <td>${user.getTelephone()}</td>
                <td>${user.getAddress()}</td>
                <td>
                    <a href="user.html"><i class="icon-pencil"></i></a>
                    <a href="#mod_id" role="button" data-toggle="modal" data-target="#modal"><i class="icon-remove"></i></a>
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
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>


<a href="/jsp/main/main.jsp">Back</a>
</body>
</html>


