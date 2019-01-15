<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Password</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <script type="text/javascript">
        <%@include file="/js/login.js"%>
    </script>
    <style>
        <%@include file="/css/login.css"%>
    </style>

    <c:set var="nameUser" value="${nameUser}"/>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="properties.text" var="local"/>
    <fmt:setBundle basename="properties.text" var="local"/>
    <fmt:message bundle="${local}" key="login.change.touch" var="touch"/>
    <fmt:message bundle="${local}" key="login.pass" var="password"/>
    <fmt:message bundle="${local}" key="main.change.pass" var="change_pass"/>
    <fmt:message bundle="${local}" key="back" var="back"/>

</head>
<body>

<form action="/interpol" method="post">
    <input type="hidden" value="CHANGE_PASS" name="command">
    <input type="hidden" value="${nameUser.getUserId()}" name="userId">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-login">
                    <div class="panel-heading">
                        <div class="row">
                            <p>${change_pass}</p>
                        </div>
                        <hr>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="login-form" method="post" role="form" style="display: block;">

                                    <div class="form-group">
                                        <input type="password" name="password" tabindex="2" class="form-control"
                                               placeholder="${password}">
                                    </div>
                                    <div class="form-group">
                                        <div class="row">
                                            <div class="col-sm-6 col-sm-offset-3">
                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                       class="form-control btn btn-login" value="${touch}">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<a style='position:fixed;bottom:20px;left:5px;
           width:100%;'
   href="/jsp/main/main.jsp">${back}</a>
</body>
</html>
