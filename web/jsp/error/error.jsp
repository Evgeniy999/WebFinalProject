<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>ERROR</title>
    <style>
        div,li,p{
            font-size: 130%;
        }
        h2{
            font-size: 180%;
        }
    </style>
</head>

<c:set var="language" value="${sessionScope.lang}"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="properties.text" var="local"/>

<fmt:message bundle="${local}" key="error.head" var="error"/>
<fmt:message bundle="${local}" key="error.inf" var="inf"/>
<fmt:message bundle="${local}" key="error.first" var="first"/>
<fmt:message bundle="${local}" key="error.second" var="second"/>
<fmt:message bundle="${local}" key="error.third" var="third"/>
<fmt:message bundle="${local}" key="error.main" var="main"/>
<body>
<div style="padding: 200px 400px; width: 790px;" align="center">
    <h2>${error}!!!</h2>

    <div align="left">
        <p>${inf}:</p>
        <ul>
            <li> ${first};</li>
            <li> ${second};</li>
            <li> ${third}(404)</li>
            <a href="/jsp/main/main.jsp">${main}</a>
        </ul>
    </div>
</div>
</body>
</html>
