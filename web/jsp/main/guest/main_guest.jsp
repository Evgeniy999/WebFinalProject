<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="language" value="${sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="resources.properties.text" var="local"/>
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
<fmt:message bundle="${local}" key="main.news.table" var="newst"/>
<fmt:message bundle="${local}" key="main.documnts" var="documentt"/>
<fmt:message bundle="${local}" key="main.people" var="peoplet"/>
<fmt:message bundle="${local}" key="main.users" var="userst"/>
<fmt:message bundle="${local}" key="main.wanted.table" var="wantedt"/>
<fmt:message bundle="${local}" key="main.missing.table" var="missingt"/>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    table, th, td {
        border: 1px solid black;
        border-collapse: collapse;
    }
</style>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row" id="main">
            <div id="content">
                <img src="/image/bg_header.jpg" width="1620" height="177">
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel with-nav-tabs panel-primary">
                    <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary" data-toggle="tab">${newst}</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">${peoplet} <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#tab4primary" data-toggle="tab"> ${wantedt} </a></li>
                                    <li><a href="#tab5primary" data-toggle="tab"> ${missingt} </a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div class="panel-body">
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="tab1primary">
                                <div class="well">
                                    <c:forEach var="news" items="${news}">
                                        <div class="media">
                                            <a class="pull-left" href="#">
                                                <c:choose>
                                                    <c:when test="${not empty news.encodedPhoto}">
                                                        <img class="media-object"
                                                             src="data:image/jpeg;base64,${news.encodedPhoto}"/>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <img class="media-object" src="/image/news.jpg"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <div class="media-body">
                                                    <%--<h4 class="media-heading">${news.getNewsId()}</h4>--%>
                                                <p class="text">${news.getTopic()}</p>
                                                <p>${news.getInformation()}</p>
                                                <ul class="list-inline list-unstyled">
                                                    <li><span><i
                                                            class="glyphicon glyphicon-calendar"></i> ${news.getTime()}</span>
                                                    </li>
                                                </ul>
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="tab4primary">
                                <c:forEach var="people" items="${people}">
                                    <c:if test="${people.getStatus() == 'wanted'}">
                                        <div class="media">
                                            <a class="pull-left" href="#">
                                                <c:choose>
                                                    <c:when test="${not empty people.encodedPhoto}">
                                                        <img class="media-object"
                                                             src="data:image/jpeg;base64,${people.encodedPhoto}"/>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <img class="media-object" src="/image/943284.png"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <div class="media-body">
                                                <p>${name}: ${people.getName()}</p>
                                                <p>${last}: ${people.getLastName()}</p>
                                                <p>${birth}: ${people.getBirthday()}</p>
                                                <p>${weight}:
                                                    <c:choose>
                                                        <c:when test="${people.getWeight()=='0'}">
                                                            -
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${people.getWeight()}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>
                                                <p>${height}:
                                                    <c:choose>
                                                        <c:when test="${people.getHeight() == '0'}">
                                                            ${people.getHeight()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${hair}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getColorOfHair()}">
                                                            ${people.getColorOfHair()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${nationality}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getNationality()}">
                                                            -
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${people.getNationality()}
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${characteristics}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getCharacteristics()}">
                                                            ${people.getCharacteristics()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${sex}: ${people.getSex()}</p>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="tab-pane fade" id="tab5primary">
                                <c:forEach var="people" items="${people}">
                                    <c:if test="${people.getStatus() == 'missing'}">
                                        <div class="media">
                                            <a class="pull-left" href="#">
                                                <c:choose>
                                                    <c:when test="${not empty people.encodedPhoto}">
                                                        <img class="media-object"
                                                             src="data:image/jpeg;base64,${people.encodedPhoto}"/>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <img class="media-object" src="/image/943284.png"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <div class="media-body">
                                                <p>${name}: ${people.getName()}</p>
                                                <p>${last}: ${people.getLastName()}</p>
                                                <p>${birth}: ${people.getBirthday()}</p>
                                                <p>${weight}:
                                                    <c:choose>
                                                        <c:when test="${people.getWeight()=='0'}">
                                                            -
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${people.getWeight()}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </p>
                                                <p>${height}:
                                                    <c:choose>
                                                        <c:when test="${people.getHeight() == '0'}">
                                                            -
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${people.getHeight()}
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${hair}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getColorOfHair()}">
                                                            ${people.getColorOfHair()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${nationality}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getNationality()}">
                                                            ${people.getNationality()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${characteristics}:
                                                    <c:choose>
                                                        <c:when test="${not empty people.getCharacteristics()}">
                                                            ${people.getCharacteristics()}
                                                        </c:when>
                                                        <c:otherwise>
                                                            -
                                                        </c:otherwise>
                                                    </c:choose></p>
                                                <p>${sex}: ${people.getSex()}</p>
                                            </div>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>

    </div>
</div>

</body>
</html>