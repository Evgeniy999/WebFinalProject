<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        <%@include file="/js/login.js"%>
    </script>
    <style>
        <%@include file="/css/login.css"%>
    </style>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="properties.text" var="local"/>
    <fmt:message bundle="${local}" key="login.log" var="log"/>
    <fmt:message bundle="${local}" key="login.registration" var="registartion"/>
    <fmt:message bundle="${local}" key="login.submit" var="touch"/>
    <fmt:message bundle="${local}" key="login.forgot" var="forgot"/>
    <fmt:message bundle="${local}" key="login.username" var="username"/>
    <fmt:message bundle="${local}" key="login.pass" var="password"/>
    <fmt:message bundle="${local}" key="login.error.login" var="error"/>
</head>
<body>
<c:set var="flag_error" value="${error_login}"></c:set>
<form action="/interpol" method="post">
    <input type="hidden" value="LOGIN" name="command">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="panel panel-login">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-6">
                                <a href="#" class="active" id="login-form-link">${log} </a>
                            </div>
                            <div class="col-xs-6">
                                <a href="/jsp/registration/registration.jsp">${registartion}</a>
                            </div>
                        </div>
                        <hr>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <form id="login-form" method="post" role="form" style="display: block;">
                                    <div class="form-group">
                                        <input type="text" name="login" tabindex="1" class="form-control"
                                               placeholder="${username}" value="">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" tabindex="2" class="form-control"
                                               placeholder="${password}">
                                    </div>
                                    <div style="color: #a94442">
                                        <c:if test="${flag_error =='false'}">
                                            <p>${error}!</p>
                                        </c:if>
                                    </div>
                                </form>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                        <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                               class="form-control btn btn-login" value="${touch}">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="text-center">
                                            <a href="#" tabindex="5"
                                               class="forgot-password">${forgot}?</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</form>
</body>
</html>