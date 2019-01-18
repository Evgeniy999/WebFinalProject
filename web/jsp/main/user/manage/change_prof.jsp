<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Change profile</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Form registration</title>

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
        <%@include file="/js/change_prof.js"%>
    </script>
    <style>
        <%@include file="/css/registration.css"%>
    </style>
    <c:set var="nameUser" value="${nameUser}"/>
    <c:set var="language" value="${sessionScope.lang}"/>

    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="resources.properties.text" var="local"/>
    <fmt:message bundle="${local}" key="registration.firstname" var="first"/>
    <fmt:message bundle="${local}" key="registration.lastname" var="last"/>
    <fmt:message bundle="${local}" key="registration.address" var="address"/>
    <fmt:message bundle="${local}" key="registration.datebirth" var="birth"/>
    <fmt:message bundle="${local}" key="registration.phonenumber" var="phone"/>
    <fmt:message bundle="${local}" key="registration.submit" var="touch"/>
</head>
<body>

<form action="/interpol" method="post">
    <input type="hidden" value="CHANGE_PROF" name="command">
    <input type="hidden" value="${nameUser.getUserId()}" name="userId">
    <div class="row">
        <div style="margin-top: 100px" class="col-md-6 col-sm-12 col-lg-6 col-md-offset-3">
            <div class="panel panel-primary">

                <div class="panel-body">
                    <form name="myform">
                        <div class="form-group">
                            <label for="name">${first} </label>
                            <input id="name" name="name" value="${nameUser.getName()}" class="form-control" type="text"
                                   min="1">
                            <span id="error_name" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="last">${last} </label>
                            <input id="last" name="last" value="${nameUser.getLastName()}" class="form-control"
                                   type="text" min="1">
                            <span id="error_last" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="birthday">${birth}</label>
                            <input type="date" name="birthday" value="${nameUser.getBirthday()}" id="birthday"
                                   class="form-control" min="1">
                            <span id="error_birthday" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="address">${address} </label>
                            <input id="address" name="address" value="${nameUser.getAddress()}" class="form-control"
                                   type="text" min="1">
                            <span id="error_address" class="text-danger"></span>
                        </div>
                        <div class="form-group">
                            <label for="telephone">${phone}</label>
                            <input type="text" id="telephone" value="${nameUser.getTelephone()}" name="telephone"
                                   class="form-control" min="1">
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
