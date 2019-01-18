<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Main</title>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        <%@include file="/js/main.js"%>
    </script>
    <style>
        <%@include file="/css/main.css"%>
    </style>
    <c:set var="nameUser" value="${nameUser}"/>
    <c:set var="lastPage" value="/jsp/main/main.jsp" scope="session"/>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="resources.properties.text" var="local"/>
    <fmt:message bundle="${local}" key="main.interpol" var="interpol"/>
    <fmt:message bundle="${local}" key="main.login" var="login"/>
    <fmt:message bundle="${local}" key="main.edit.prof" var="prof"/>
    <fmt:message bundle="${local}" key="main.change.pass" var="password"/>
    <fmt:message bundle="${local}" key="main.out" var="out"/>
    <fmt:message bundle="${local}" key="main.rus" var="rus"/>
    <fmt:message bundle="${local}" key="main.en" var="en"/>

</head>
<body>

<div id="throbber" style="display:none; min-height:120px;"></div>
<div id="noty-holder"></div>
<div id="wrapper">

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation" style="height: 61px;">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img src="/image/logo.png" width="50" height="45" class="pic" alt="INTERPOL">
            </a>

        </div>
        <ul class="nav navbar-left top-nav">
            <li>
                <a> ${interpol} </a>
            </li>
        </ul>
        <!-- Navigation -->

        <ul class="nav navbar-right top-nav">

            <li>
                <form action="/interpol" method="post">
                    <input type="hidden" value="CHANGE_LANG" name="command">
                    <ul>
                        <li>
                            <div class="btn-group btn-group-sm divLang" id="center" role="group" aria-label="...">
                                <button type="submit" name="lang" value="en" class="btn btn-default navbar-btn">${en}
                                </button>
                                <button type="submit" name="lang" value="rus" class="btn btn-default navbar-btn">${rus}
                                </button>
                            </div>
                        </li>
                    </ul>
                </form>
            </li>
            <c:choose>
                <c:when test="${sessionScope.isLogin == false}">

                    <c:if test="${sessionScope.role =='GUEST'}">
                        <li><a>${role}</a></li>
                        <li>
                            <a href="/interpol?command=LOGIN_PAGE"> ${login} </a>
                        </li>
                    </c:if>

                </c:when>
                <c:otherwise>
                    <c:choose>
                        <c:when test="${sessionScope.role =='USER'}">
                            <li><a>${role}</a></li>
                            <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Stats"><i
                                    class="fa fa-user"></i>
                            </a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle"
                                   data-toggle="dropdown"> ${nameUser.getName()} ${nameUser.getLastName()} <b
                                        class="fa fa-angle-down"></b>
                                </a>
                                <ul class="dropdown-menu" style="width: 182px;padding-top: 12px;">
                                    <form id="change_prof" action="/interpol" method="post">
                                        <input type="hidden" value="TO_CHANGE_PROF_PAGE" name="command">
                                        <li><a href="#" class="profstyle"
                                               onclick="document.getElementById('change_prof').submit();"><i
                                                class="fa fa-fw fa-user"></i>${prof}</a>
                                        </li>
                                    </form>

                                    <form id="change" action="/interpol" method="post">
                                        <input type="hidden" value="TO_CHANGE_PASS_PAGE" name="command">
                                        <li><a href="#" class="profstyle"
                                               onclick="document.getElementById('change').submit();">
                                            <i class="fa fa-fw fa-cog" style="text-decoration: none"></i>${password}</a>
                                        </li>
                                    </form>


                                    <li class="divider"></li>
                                    <li>
                                        <map>
                                            <form id="form-id" action="/interpol" method="post">
                                                <input type="hidden" value="LOGOUT" name="command">
                                    <li><a href="#" class="profstyle"
                                           onclick="document.getElementById('form-id').submit();">
                                        </map> <i style="text-decoration: none"
                                                  class="fa fa-fw fa-power-off "></i> ${out} </a></li>

                                    </form>
                                    </li>
                                </ul>
                            </li>

                        </c:when>
                        <c:when test="${sessionScope.role =='ADMIN'}">
                            <li><a>${role}</a></li>
                            <li><a href="#" data-placement="bottom" data-toggle="tooltip" data-original-title="Stats"><i
                                    class="fa fa-user-secret"></i>
                            </a>
                            </li>
                            <li class="dropdown" style="width: 182px;">
                                <a href="#" class="dropdown-toggle"
                                   data-toggle="dropdown"> ${nameUser.getName()} ${nameUser.getLastName()} <b
                                        class="fa fa-angle-down"></b></a>
                                <ul class="dropdown-menu" style="width: 182px;padding-top: 12px;">
                                    <form id="change_prof" action="/interpol" method="post">
                                        <input type="hidden" value="TO_CHANGE_PROF_PAGE" name="command">
                                        <li><a href="#" class="profstyle"
                                               onclick="document.getElementById('change_prof').submit();"><i
                                                class="fa fa-fw fa-user"></i>${prof}</a></li>
                                    </form>
                                    <form id="change" action="/interpol" method="post">
                                        <input type="hidden" value="TO_CHANGE_PASS_PAGE" name="command">
                                        <li><a href="#" class="profstyle"
                                               onclick="document.getElementById('change').submit();">
                                            <i class="fa fa-fw fa-cog" style="text-decoration: none"></i>${password}</a>
                                        </li>
                                    </form>

                                    <li class="divider"></li>
                                    <li>
                                        <map>
                                            <form id="form-id" action="/interpol" method="post">
                                                <input type="hidden" value="LOGOUT" name="command">
                                    <li><a href="#" class="profstyle"
                                           onclick="document.getElementById('form-id').submit();">
                                        </map> <i style="text-decoration: none"
                                                  class="fa fa-fw fa-power-off"></i> ${out} </a></li>

                                    </form>
                                    </li>
                                </ul>
                            </li>

                        </c:when>
                    </c:choose>
                </c:otherwise>
            </c:choose>
        </ul>

        <c:choose>
            <c:when test="${sessionScope.isLogin == false}">

                <c:if test="${sessionScope.role =='GUEST'}">
                    <jsp:include page="/jsp/main/guest/guest_left_menu.jsp"/>
                </c:if>

            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${sessionScope.role =='USER'}">
                        <jsp:include page="/jsp/main/user/user_left_menu.jsp"/>
                    </c:when>
                    <c:when test="${sessionScope.role =='ADMIN'}">
                        <jsp:include page="/jsp/main/admin/admin_left_menu.jsp"/>
                    </c:when>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </nav>


    <c:choose>
    <c:when test="${sessionScope.isLogin == false}">

    <c:if test="${sessionScope.role =='GUEST'}">

        <jsp:include page="/jsp/main/guest/main_guest.jsp"/>
    </c:if>

    </c:when>
    <c:otherwise>
    <c:choose>
    <c:when test="${sessionScope.role =='USER'}">

        <jsp:include page="/jsp/main/user/main_user.jsp"/>
    </c:when>
    <c:when test="${sessionScope.role =='ADMIN'}">
        <jsp:include page="/jsp/main/admin/main_admin.jsp"/>
    </c:when>
    </c:choose>
    </c:otherwise>
    </c:choose>

</body>
</html>