<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>

<c:set var="nameUser" value="${nameUser}"/>
<form action="/interpol" method="post" enctype="multipart/form-data">
    <input type="hidden" value="ADD_APPLIC" name="command">

<div class="container" style="margin-top:50px;">
    <form class="form-horizontal" method="post" action="">
        <fieldset>
            <input type="hidden" value="${nameUser.getName()}" name="name">
            <input type="hidden" value="${nameUser.getLastName()}" name="last">

            <div id="edit_farmer" style="display:none"></div>
            <div class="row">
                <div class="col-md-2 panel panel-heading">Form document</div>
                <div class="col-md-4 panel panel-heading" style="display:none; color:red" id="contact_error"></div>
            </div>


            <div class="row form-group">
                <%--@declare id="statement"--%><label class="col-md-2 control-label" for="statement">Type
                statement</label>
                <div class="col-md-4">
                    <label class="radio-inline"><input type="radio" name="statement" value="2"
                                                       checked>Wanted</label>
                    <label class="radio-inline"><input type="radio" name="statement"
                                                       value="1">Missing</label>
                </div>

            </div>

            <div class="row">
                <label class="col-md-1 control-label" for="information">Information</label>
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
                <label for="photo">Choose images to upload (PNG, JPG)</label>
                <input type="file" id="photo" name="photo" accept=".jpg, .jpeg, .png">
            </div>


            <div class="form-group">
                <label for="date">Application filling date</label>
                <input type="date" name=date id="date" class="form-control" min="1">
            </div>

            <div class="form-group">
                <label for="date_lead">Lead time</label>
                <input type="date" name=date_lead id="date_lead" class="form-control" min="1">
            </div>

            <div class="form-group">
                <label for="reward">Reward</label>
                <input type="text" name=reward id="reward" class="form-control" min="1">
            </div>


            <div class="form-group row">
                <div class="col-md-8 text-center">
                    <button type="submit" id="save" name="save" class="btn btn-large btn-success"> Save Farmer Information
                    </button>
                    <button class="btn btn-large btn-danger" type="button" onclick=history.go(-1)> Cancel</button>
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

<a href="/jsp/main/main.jsp">Back</a>
</body>
</html>
