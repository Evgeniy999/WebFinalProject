<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Europe</title>

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
    <p></p>
    <h4>Alcohol tops list of EUR 230 million fake food and drink seizures in global operation</h4>
    <div class="contect_news">
        Nearly 26 million litres of fake alcohol has been seized in a&nbsp; joint INTERPOL-Europol operation targeting
        fake food and drink around the world.In the sixth Operation Opson, which involved police, customs, national food
        regulatory authorities and partners from the private sector in&nbsp; 61 countries, counterfeit alcohol was the
        most seized product, f...
    </div>
    <span class="date">25 April 2017</span>

    <h4>Global operation targets child sexual abuse material exchanged via messaging apps</h4>
    <div class="contect_news">
        LYON, France – An operation into the exchange of child sexual abuse material via mobile applications has led to
        38 arrests in Latin America and Europe.Operation Tantalio, launched by the Spanish National Police and
        coordinated by INTERPOL and Europol, saw police across 15 countries in Central and South America and Europe
        target individuals using the messa...
    </div>
    <span class="date"> 18 April 2017</span>

    <h4> Migration and border security top INTERPOL European meeting agenda</h4>
    <div class="contect_news">
        PRAGUE, Czech Republic – Addressing the border security challenges posed by an unprecedented number of migrants
        travelling to Europe is a key issue for senior law enforcement officials gathered at the 44th INTERPOL European
        Regional Conference.Following the publication of the joint Europol-INTERPOL Report on Migrant Smuggling Networks
        earlier this week, d...
    </div>
    <span class="date"> 18 May 2016</span>
    <h4>Record seizures of fake food and drink in INTERPOL-Europol operation</h4>
    <div class="contect_news">
        Thousands of tonnes of fake and sub-standard food and drink have been seized in 47 countries around the world as
        part of an INTERPOL-Europol coordinated operation.Operation Opson IV, conducted during December 2014 and January
        2015, resulted in the seizure of more than 2,500 tonnes of counterfeit and illicit food, including mozzarella,
        strawberries, eggs,...
    </div>
    <span class="date"> 16 February 2015</span>
</div>
<a href="/jsp/main/main.jsp">${back}</a>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

</body>
</html>
