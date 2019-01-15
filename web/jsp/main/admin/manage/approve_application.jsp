<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Approve</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style type="text/css">
        <%@include file="/css/approve.css"%>
    </style>
    <script type="text/javascript">
        <%@include file="/js/registration.js"%>
    </script>
</head>

<c:set var="language" value="${sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties.text" var="local"/>
<fmt:message bundle="${local}" key="main.name.table" var="name"/>
<fmt:message bundle="${local}" key="main.lastname.table" var="last"/>
<fmt:message bundle="${local}" key="main.birth.table" var="birth"/>
<fmt:message bundle="${local}" key="main.weight.table" var="weight"/>
<fmt:message bundle="${local}" key="main.height.table" var="height"/>
<fmt:message bundle="${local}" key="main.telephone.table" var="phone"/>
<fmt:message bundle="${local}" key="main.address.table" var="address"/>
<fmt:message bundle="${local}" key="main.colorofhair.table" var="hair"/>
<fmt:message bundle="${local}" key="main.nationality.table" var="nationality"/>
<fmt:message bundle="${local}" key="main.characteristics.table" var="characteristics"/>
<fmt:message bundle="${local}" key="main.sex.table" var="sex"/>
<fmt:message bundle="${local}" key="gender" var="gender"/>
<fmt:message bundle="${local}" key="male" var="male"/>
<fmt:message bundle="${local}" key="female" var="female"/>
<fmt:message bundle="${local}" key="other" var="other"/>
<fmt:message bundle="${local}" key="back" var="back"/>
<fmt:message bundle="${local}" key="login.username" var="username"/>
<fmt:message bundle="${local}" key="application.information" var="information"/>
<fmt:message bundle="${local}" key="main.statement" var="stat"/>
<fmt:message bundle="${local}" key="application.reward" var="reward"/>
<fmt:message bundle="${local}" key="application.lead.time" var="lead"/>
<fmt:message bundle="${local}" key="main.form" var="forma"/>
<fmt:message bundle="${local}" key="application.type" var="type"/>
<fmt:message bundle="${local}" key="add.news.date" var="date"/>

<body style="padding-right: 100px">
<c:set var="document" value="${document}"/>
<table cellspacing="0" id="maket">
    <tr>
        <td id="leftcol">
            <p>${stat}</p>
            <div>
                <p>${username}: ${document.getName()} ${document.getLastName()}</p>
                <p>${information}: </p>
                <p>
                <div class="col" style="width: 280px">
                    ${document.getInformation()}
                </div>
                </p>
                <p>${type}: ${document.getStatement()}</p>
                <p>${reward}($): ${document.getReward()}</p>
                <p>${date}: ${document.getTime()}</p>
                <p>${lead}: ${document.getLeadTime()}</p>
                <p><c:choose>
                    <c:when test="${not empty document.encodedPhoto}">
                        <img src="data:image/jpeg;base64,${document.encodedPhoto}"/>
                    </c:when>
                    <c:otherwise>
                        -
                    </c:otherwise>
                </c:choose></p>
            </div>
        </td>
        <td id="rightcol">${forma}
            <form action="/interpol" method="post" enctype="multipart/form-data">
                <input type="hidden" value="APPROVE_APPLIC" name="command">

                <c:if test="${document.getStatement() == 'missing'}">
                    <input type="hidden" value="1" name="status">
                </c:if>
                <c:if test="${document.getStatement() == 'wanted'}">
                    <input type="hidden" value="2" name="status">
                </c:if>
                <input type="hidden" value="${document.getDocId()}" name="docId">
                <div class="form-horizontal">
                    <fieldset>

                        <div class="panel-body">
                            <form name="myform">
                                <div class="form-group">
                                    <label for="name">${name} *</label>
                                    <input id="name" name="name" class="form-control" type="text" min="1">
                                    <span id="error_name" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="last">${last} *</label>
                                    <input id="last" name="last" class="form-control" type="text" min="1">
                                    <span id="error_last" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="birthday">${birth} *</label>
                                    <input type="date" name="birthday" id="birthday" class="form-control"
                                           min="1">
                                    <span id="error_birthday" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="weight">${weight} </label>
                                    <input id="weight" name="weight" class="form-control" type="text"
                                           min="1" >
                                    <span id="error_weight" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="height">${height} </label>
                                    <input id="height" name="height" class="form-control" type="text"
                                           min="1" >
                                    <span id="error_height" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="hair">${hair} </label>
                                    <input id="hair" name="hair" class="form-control" type="text" min="1"
                                    value=" ">
                                    <span id="error_hair" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="nationality">${nationality} </label>
                                    <input type="text" id="nationality" name="nationality"
                                           class="form-control"
                                           min="1">
                                    <span id="error_nationality" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="gender">${gender}</label>
                                    <select name="gender" id="gender" class="form-control">
                                        <option value="Male" selected>Male</option>
                                        <option value="Female">Female</option>
                                        <option value="Other">Other</option>
                                    </select>
                                    <span id="error_gender" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="characteristics">${characteristics} </label>
                                    <textarea class="form-control" id="characteristics"
                                              name="characteristics"></textarea>

                                </div>
                                <button id="submit" type="submit" value="submit"
                                        class="btn btn-primary center">
                                    Submit
                                </button>
                            </form>
                        </div>
                    </fieldset>
                </div>
                </div>
            </form>
        </td>
    </tr>
</table>

<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/admin/manage/doc_table.jsp">${back}</a>

</body>
</html>
