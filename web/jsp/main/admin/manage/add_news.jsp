<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 06.01.2019
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<!------ Include the above in your HEAD tag ---------->

<form action="/interpol" method="post"  enctype="multipart/form-data">
    <input type="hidden" value="ADD_NEWS" name="command">
    <div class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>ADD NEWS</legend>


        <!-- Topic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="topic">TOPIC NEWS</label>
            <div class="col-md-4">
                <textarea class="form-control" id="topic" name="topic">Topic...</textarea>
            </div>
        </div>

        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="information">NEWS & EVENTS</label>
            <div class="col-md-4">
                <textarea class="form-control" id="information" name="information">NEWS & events here.....</textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-4 control-label" for="country">COUNTRY</label>
            <div class="col-md-4">
                <textarea class="form-control" id="country" name="country">Country...</textarea>
            </div>
        </div>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="dateNews">DATE</label>
            <div class="col-md-4">
                <input id="dateNews" name="dateNews" type="date" placeholder="" class="form-control input-md" required="">

            </div>
        </div>

        <div style="padding:10px" class="form-group">
            <label for="photo">Choose images to upload (PNG, JPG)</label>
            <input type="file" id="photo" name="photo" accept=".jpg, .jpeg, .png">
        </div>
        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="button1idDDSA"></label>
            <div class="col-md-8">
                <button id="button1idDDSA" name="button1idDDSA" type="submit" class="btn btn-success">SUBMIT</button>
                <button id="button2id" name="button2id" class="btn btn-danger">CANCEL</button>
            </div>
        </div>
    </fieldset>
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
