<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">
    <div class="container-fluid">

        <!-- Page Heading -->
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
                            <li class="active"><a href="#tab1primary" data-toggle="tab">News</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">People <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#tab4primary" data-toggle="tab"> Wanted persons </a></li>
                                    <li><a href="#tab5primary" data-toggle="tab"> Missing persons </a></li>
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
                                        <tr>
                                            <td>${people.getPersonId()}</td>
                                            <td>${people.getName()}</td>
                                            <td>${people.getLastName()}</td>
                                            <td>${people.getBirthday()}</td>
                                            <td>${people.getWeight()}</td>
                                            <td>${people.getHeight()}</td>
                                            <td>${people.getColorOfHair()}</td>
                                            <td>${people.getNationality()}</td>
                                            <td>${people.getCharacteristics()}</td>
                                            <td>${people.getSex()}</td>
                                            <td><c:choose>
                                                <c:when test="${not empty people.encodedPhoto}">
                                                    <img class="media-object"
                                                         src="data:image/jpeg;base64,${people.encodedPhoto}"/>

                                                </c:when>
                                                <c:otherwise>
                                                    <img class="media-object" src="/image/943284.png"/>
                                                </c:otherwise>
                                            </c:choose>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="tab-pane fade" id="tab5primary">
                                <c:forEach var="people" items="${people}">
                                    <c:if test="${people.getStatus() == 'missing'}">
                                        <tr>
                                            <td>${people.getPersonId()}</td>
                                            <td>${people.getStatus()}</td>
                                            <td>${people.getName()}</td>
                                            <td>${people.getLastName()}</td>
                                            <td>${people.getBirthday()}</td>
                                            <td>${people.getWeight()}</td>
                                            <td>${people.getHeight()}</td>
                                            <td>${people.getColorOfHair()}</td>
                                            <td>${people.getNationality()}</td>
                                            <td>${people.getCharacteristics()}</td>
                                            <td>${people.getSex()}</td>
                                            <td><c:choose>
                                                <c:when test="${not empty people.encodedPhoto}">
                                                    <img class="media-object"
                                                         src="data:image/jpeg;base64,${people.encodedPhoto}"/>

                                                </c:when>
                                                <c:otherwise>
                                                    <img class="media-object" src="#"/>
                                                </c:otherwise>
                                            </c:choose>
                                            </td>
                                        </tr>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </div>
</div>

</body>
</html>