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
        <div style="margin-top: 100px" class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
            <div class="panel panel-primary">
                <div class="panel-heading">Enter Your Details Here
                </div>
                <div class="panel-body">
                    <form name="myform">
                        <div class="form-group">
                            <label for="login">Login *</label>
                            <input id="login" name="login" class="form-control" type="text" min="1">
                            <span id="error_login" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="password">Password *</label>
                            <input id="password" name="password" class="form-control" type="number" min="1">
                            <span id="error_password" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="name">First Name *</label>
                            <input id="name" name="name" class="form-control" type="text" min="1">
                            <span id="error_name" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="last">Last Name *</label>
                            <input id="last" name="last" class="form-control" type="text" min="1">
                            <span id="error_last" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="address">Address *</label>
                            <input id="address" name="address" class="form-control" type="text" min="1">
                            <span id="error_address" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="birthday">Date Of Birth *</label>
                            <input type="date" name=birthday id="birthday" class="form-control" min="1">
                            <span id="error_birthday" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="telephone">Phone Number *</label>
                            <input type="text" id="telephone" name="telephone" class="form-control" min="1">
                            <span id="error_phone" class="text-danger"></span>
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