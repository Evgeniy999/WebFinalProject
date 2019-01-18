<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Document</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <style>
        <%@include file="/css/application.css"%>
    </style>
    <c:set var="nameUser" value="${nameUser}"/>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="resources.properties.text" var="local"/>
    <fmt:message bundle="${local}" key="application.doc" var="doc"/>
    <fmt:message bundle="${local}" key="application.information" var="information"/>
    <fmt:message bundle="${local}" key="application.missing" var="missing"/>
    <fmt:message bundle="${local}" key="application.wanted" var="wanted"/>
    <fmt:message bundle="${local}" key="application.reward" var="reward"/>
    <fmt:message bundle="${local}" key="add.news.image" var="image"/>
    <fmt:message bundle="${local}" key="application.type" var="types"/>
    <fmt:message bundle="${local}" key="application.save" var="save"/>
    <fmt:message bundle="${local}" key="application.filling.date" var="fill"/>
    <fmt:message bundle="${local}" key="application.cancel" var="cancel"/>
    <fmt:message bundle="${local}" key="application.lead.time" var="lead"/>
    <fmt:message bundle="${local}" key="back" var="back"/>
</head>
<body>

<form action="/interpol" method="post" enctype="multipart/form-data">
    <input type="hidden" value="ADD_APPLIC" name="command">

    <div class="container" style="margin-top:50px;">
        <form class="form-horizontal" method="post" action="">
            <fieldset>
                <input type="hidden" value="${nameUser.getName()}" name="name">
                <input type="hidden" value="${nameUser.getLastName()}" name="last">

                <div id="edit_farmer" style="display:none"></div>
                <div class="row">
                    <div class="col-md-2 panel panel-heading">${doc}</div>
                    <div class="col-md-4 panel panel-heading" style="display:none; color:red" id="contact_error"></div>
                </div>


                <div class="row form-group">
                    <%--@declare id="statement"--%><label class="col-md-2 control-label"
                                                          for="statement">${types}</label>
                    <div class="col-md-4">
                        <label class="radio-inline"><input type="radio" name="statement" value="2"
                                                           checked>${wanted}</label>
                        <label class="radio-inline"><input type="radio" name="statement"
                                                           value="1">${missing}</label>
                    </div>

                </div>

                <div class="row">
                    <label class="col-md-1 control-label" for="information">${information}</label>
                    <div class="col-md-4">
                        <div class="input-group">
			<span class="input-group-addon">
			<i class="glyphicon glyphicon-pencil"></i>
			</span>
                            <textarea class="form-control" id="information" name="information"
                                      placeholder="information"></textarea>
                        </div>
                    </div>
                </div>

                <div style="padding:10px" class="row form-group">
                    <label for="photo">${image} (PNG, JPG)</label>
                    <input type="file" id="photo" name="photo" accept=".jpg, .jpeg, .png">
                </div>


                <div class="form-group">
                    <label for="date">${fill}</label>
                    <input type="date" name=date id="date" class="form-control" min="1">
                </div>

                <div class="form-group">
                    <label for="date_lead">${lead}</label>
                    <input type="date" name=date_lead id="date_lead" class="form-control" min="1">
                </div>

                <div class="form-group">
                    <label for="reward">${reward}($)</label>
                    <input type="text" name=reward id="reward" class="form-control" min="1">
                </div>


                <div class="form-group row">
                    <div class="col-md-8 text-center">
                        <button type="submit" id="save" name="save" class="btn btn-large btn-success"> ${save}
                        </button>
                        <button class="btn btn-large btn-danger" type="button"
                                onclick=history.go(-1)> ${cancel}</button>
                    </div>
                </div>
            </fieldset>
        </form>
    </div>
</form>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">${back}</a>
</body>
</html>