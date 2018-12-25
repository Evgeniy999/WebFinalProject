<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 12.12.2018
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form registration</title>
    <%--<body>--%>
    <%--<h1>Registration user</h1>--%>
    <%--<form action="/interpol" method="get">--%>
    <%--<input type="hidden" value="REGISTRATION" name="command">--%>
    <%--Login: <input type="text" name="login" size="10"><br>--%>
    <%--Password: <input type="password" name="password" size="10"><br>--%>
    <%--Name:<input type="text" name="name" size="10"><br>--%>
    <%--Last name: <input type="text" name="last" size="10"><br>--%>
    <%--Address: <input type="text" name="address"><br>--%>
    <%--Telephone: <input type="text" name="phone"><br>--%>
    <%--<p>--%>
    <%--<table>--%>
    <%--<tr>--%>
    <%--<th>--%>
    <%--<small>--%>
    <%--<input type="submit" name="save" value="Save">--%>
    <%--</small>--%>
    <%--<th>--%>
    <%--<small>--%>
    <%--<input type="submit" name="cancel" value="Out">--%>
    <%--</small>--%>
    <%--</table>--%>
    <%--</form>--%>
    <%--</body>--%>
    <%--</html>--%>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        <%@include file="../../js/registration.js"%>
    </script>
    <style>
        <%@include file="../../css/registration.css"%>
    </style>

</head>
<body>
<form action="/interpol" method="get">
    <input type="hidden" value="REGISTRATION" name="command">
    <div class="row">
        <div class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Enter Your Details Here
                </div>
                <div class="panel-body">
                    <form name="myform">
                        <div class="form-group">
                            <label for="login">Login *</label>
                            <input id="login" name="login" class="form-control" type="text" min="1">
                        </div>
                        <div class="form-group">
                            <label for="password">Password *</label>
                            <input id="password" name="password" class="form-control" type="number" min="1">
                        </div>
                        <div class="form-group">
                            <label for="myName">First Name *</label>
                            <input id="myName" name="name" class="form-control" type="text" data-validation="required">
                            <span id="error_name" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="lastname">Last Name *</label>
                            <input id="lastname" name="last" class="form-control" type="text" data-validation="email">
                            <span id="error_lastname" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="address">Address *</label>
                            <input id="address" name="address" class="form-control" type="text" min="1">
                            <span id="error" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="birthday">Date Of Birth *</label>
                            <input type="date" name=birthday id="birthday" class="form-control">
                            <span id="error_dob" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="gender">Gender</label>
                            <select name="gender" id="gender" class="form-control">
                                <option selected>Male</option>
                                <option>Female</option>
                                <option>Other</option>
                            </select>
                            <span id="error_gender" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="telephone">Phone Number *</label>
                            <input type="text" id="telephone" name="telephone" class="form-control">
                            <span id="error_phone" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="disc">Discription</label>
                            <textarea class="form-control" rows="3"></textarea>
                        </div>

                        <button id="submit" type="submit" value="submit" class="btn btn-primary center">Submit</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>