<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties.text" var="local"/>
<fmt:message bundle="${local}" key="main.search" var="search"/>
<fmt:message bundle="${local}" key="main.missing" var="missing"/>
<fmt:message bundle="${local}" key="main.wanted" var="wanted"/>
<fmt:message bundle="${local}" key="main.member.countirs" var="member"/>
<fmt:message bundle="${local}" key="main.world" var="world"/>
<fmt:message bundle="${local}" key="main.africa" var="africa"/>
<fmt:message bundle="${local}" key="main.americas" var="americas"/>
<fmt:message bundle="${local}" key="main.asia" var="asia"/>
<fmt:message bundle="${local}" key="main.europe" var="europa"/>
<fmt:message bundle="${local}" key="main.crime.areas" var="areas"/>
<fmt:message bundle="${local}" key="main.about" var="about"/>
<fmt:message bundle="${local}" key="main.manage.users" var="manageUser"/>
<fmt:message bundle="${local}" key="main.manage.documents" var="manageDoc"/>
<fmt:message bundle="${local}" key="main.news" var="news"/>
<form>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <li>
                <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-search"></i>
                    ${search} <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                <ul id="submenu-1" class="collapse">
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${missing} </a></li>
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${wanted} </a></li>
                </ul>
            </li>
            <li>
                <a href="#" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-star"></i>
                    ${member} <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                <ul id="submenu-2" class="collapse">
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${world} </a></li>
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${africa} </a></li>
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${americas} </a></li>
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${asia} </a></li>
                    <li><a href="#"><i class="fa fa-angle-double-right"></i> ${europa} </a></li>
                </ul>
            </li>

            <li><a href="/interpol?command=MANAGE_USER" class="menustyle">
                <i style="text-decoration: none" class="fa fa-users"></i> ${manageUser} </a>
            </li>

            <li><a class="menustyle" href="/interpol?command=MANAGE_DOC">
                <i style="text-decoration: none" class="fa fa-folder-open-o"></i> ${manageDoc} </a>
            </li>
            <li>
                <a href="/interpol?command=NEWS_PAGE"><i class="fa fa-newspaper-o"></i> ${news}</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-fw fa-paper-plane-o"></i> ${areas} </a>
            </li>
            <li>
                <a href="/jsp/main/common/about.jsp"><i class="fa fa-fw fa fa-question-circle"></i> ${about}</a>
            </li>

        </ul>
    </div>
</form>
