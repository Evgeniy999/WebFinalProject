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
<fmt:message bundle="${local}" key="main.submit.application" var="applic"/>
<form>
    <div class="collapse navbar-collapse navbar-ex1-collapse">
        <ul class="nav navbar-nav side-nav">
            <li>
                <a href="#" data-toggle="collapse" data-target="#submenu-1"><i class="fa fa-fw fa-search"></i>
                    ${search} <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                <ul id="submenu-1" class="collapse">
                    <li><a href="/interpol?command=SEARCH_PAGE&status=missing"><i
                            class="fa fa-angle-double-right"></i> ${missing}</a></li>
                    <li><a href="/interpol?command=SEARCH_PAGE&status=wanted"><i
                            class="fa fa-angle-double-right"></i> ${wanted} </a></li>
                </ul>
            </li>
            <li>
                <a href="#" data-toggle="collapse" data-target="#submenu-2"><i class="fa fa-fw fa-star"></i>
                    ${member} <i class="fa fa-fw fa-angle-down pull-right"></i></a>
                <ul id="submenu-2" class="collapse">
                    <li><a href="/jsp/main/common/world.jsp"><i class="fa fa-angle-double-right"></i> ${world} </a></li>
                    <li><a href="/jsp/main/common/africa.jsp"><i class="fa fa-angle-double-right"></i> ${africa} </a>
                    </li>
                    <li><a href="/jsp/main/common/americas.jsp"><i class="fa fa-angle-double-right"></i> ${americas}
                    </a></li>
                    <li><a href="/jsp/main/common/asia.jsp"><i class="fa fa-angle-double-right"></i> ${asia} </a></li>
                    <li><a href="/jsp/main/common/europe.jsp"><i class="fa fa-angle-double-right"></i> ${europa} </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="/interpol?command=PAGE_APPLIC"><i class="fa fa-fw fa-user-plus"></i> ${applic}</a>
            </li>
            <li>
                <a href="/jsp/main/common/crime_areas.jsp"><i class="fa fa-fw fa-paper-plane-o"></i> ${areas} </a>
            </li>
            <li>
                <a href="/jsp/main/common/about.jsp"><i class="fa fa-fw fa fa-question-circle"></i> ${about}</a>
            </li>
        </ul>
    </div>
</form>