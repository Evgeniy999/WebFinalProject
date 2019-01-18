<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Add</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="resources.properties.text" var="local"/>
    <fmt:message bundle="${local}" key="add.news" var="add"/>
    <fmt:message bundle="${local}" key="add.news.topic" var="topic"/>
    <fmt:message bundle="${local}" key="add.news.country" var="country"/>
    <fmt:message bundle="${local}" key="add.news.event" var="event"/>
    <fmt:message bundle="${local}" key="add.news.image" var="image"/>
    <fmt:message bundle="${local}" key="add.news.submit" var="submit"/>
    <fmt:message bundle="${local}" key="add.news.cancel" var="cancel"/>
    <fmt:message bundle="${local}" key="add.news.date" var="date"/>
    <fmt:message bundle="${local}" key="back" var="back"/>
</head>
<body>

<form action="/interpol" method="post" enctype="multipart/form-data">
    <input type="hidden" value="ADD_NEWS" name="command">
    <div class="form-horizontal">
        <fieldset>

            <legend>${add}</legend>

            <div class="form-group">
                <label class="col-md-4 control-label" for="topic">${topic}</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="topic" name="topic">${topic}...</textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="information">${event}</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="information" name="information">${event}.....</textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="country">${country}</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="country" name="country">${country}...</textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="dateNews">${date}</label>
                <div class="col-md-4">
                    <input id="dateNews" name="dateNews" type="date" placeholder="" class="form-control input-md"
                           required="">

                </div>
            </div>

            <div style="padding:10px" class="form-group">
                <label for="photo">${image} (PNG, JPG)</label>
                <input type="file" id="photo" name="photo" accept=".jpg, .jpeg, .png">
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="button1idDDSA"></label>
                <div class="col-md-8">
                    <button id="button1idDDSA" name="button1idDDSA" type="submit"
                            class="btn btn-success">${submit}</button>
                    <button id="button2id" name="button2id" class="btn btn-danger">${cancel}</button>
                </div>
            </div>
        </fieldset>
    </div>
</form>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">${back}</a>

</body>
</html>
