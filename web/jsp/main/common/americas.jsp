<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Americas</title>
    <style>
        <%@include file="/css/news.css"%>
    </style>

    <c:set var="language" value="${sessionScope.lang}"/>
    <fmt:setLocale value="${language}"/>
    <fmt:setBundle basename="resources.properties.text" var="local"/>
    <fmt:message bundle="${local}" key="back" var="back"/>
</head>
<body>

<div class="container">
    <h4>Alcohol tops list of EUR 230 million fake food and drink seizures in global operation</h4>
    <div class="contect_news">
        Nearly 26 million litres of fake alcohol has been seized in a&nbsp; joint INTERPOL-Europol operation targeting
        fake food and drink around the world.In the sixth Operation Opson, which involved police, customs, national food
        regulatory authorities and partners from the private sector in&nbsp; 61 countries, counterfeit alcohol was the
        most seized product, f...
    </div>
    <span class="date">10 December 2018 </span>

    <h4>Global operation targets child sexual abuse material exchanged via messaging apps</h4>
    <div class="contect_news">
        LYON, France – An operation into the exchange of child sexual abuse material via mobile applications has led to
        38 arrests in Latin America and Europe.Operation Tantalio, launched by the Spanish National Police and
        coordinated by INTERPOL and Europol, saw police across 15 countries in Central and South America and Europe
        target individuals using the messa...
    </div>
    <span class="date"> 18 April 2017</span>

    <h4> Tackling organized crime in Latin America and Caribbean focus of INTERPOL meeting</h4>
    <div class="contect_news">
        WILLEMSTAD, Curaçao – Addressing the global problem of Latin American and Caribbean drug crime and its links to
        other serious crimes, particularly migrant smuggling and human trafficking, was the focus of INTERPOL’s third
        annual Project Fortaleza meeting held in the Curaçao capital. Project Fortaleza provides Latin American and
        Caribbean law enforcement w...
    </div>
    <span class="date"> 23 September 2016</span>
    <h4>INTERPOL boosts cybercrime policing capacity in Latin America and the Caribbean</h4>
    <div class="contect_news">
        BOGOTA, Colombia – INTERPOL has conducted a series of cybercrime training sessions in Latin America and the
        Caribbean, aimed at enhancing regional law enforcement capacity to prevent, detect and respond to
        cyberthreats.The three training sessions – held in the Bahamas in June, the Dominican Republic in July and
        Colombia in August – brought together a tota...
    </div>
    <span class="date"> 02 September 2016</span>

    <h4> INTERPOL operations target illegal timber trade in Africa and the Americas</h4>
    <div class="contect_news">
        LYON, France – INTERPOL-coordinated illegal logging operations in West Africa and Central and South America have
        identified key trade routes used by criminal networks to traffic illicitly harvested timber and led to major
        seizures of protected and valuable timber species worth more than USD 262 million.Operation Log took place in
        nine West African countri...
    </div>
    <span class="date">26 November 2015</span>
</div>
<a href="/jsp/main/main.jsp">${back}</a>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

</body>
</html>
