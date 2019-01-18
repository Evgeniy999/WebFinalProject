<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>Africa</title>
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
    <h4>Counter-terrorism meeting addresses border security in East Africa</h4>
    <div class="contect_news">
        KAMPALA, Uganda ‒ A working group meeting has brought together representatives from multiple agencies in
        East
        Africa to
        focus on border control challenges in the fight against terrorism in the region.Co-hosted by the Uganda
        Police
        and
        funded by the INTERPOL Foundation for a Safer World, the three-day meeting (4-6 December) was attended by
        more
        than 40
        off...
    </div>
    <span class="date">10 December 2018 </span>

    <h4>Strengthening security in Southern Africa</h4>
    <div class="contect_news">
        GABORONE, Botswana – Botswana’s role on the frontline of law enforcement cooperation
        in Southern Africa was high
        on the
        agenda during the first official visit to the country by INTERPOL Secretary General Jürgen Stock.The
        INTERPOL
        Chief met
        with the Acting Commissioner of the Botswana Police Service (BPS), Tapudzani Pester Gabolekwe, and the
        Executive
        Secr...
    </div>
    <span class="date"> 29 August 2018</span>

    <h4> INTERPOL launches initiative to boost African security</h4>
    <div class="contect_news">
        I-ONE: INTERPOL’s operational network expansionLYON, France – Africa’s regional
        police leaders and Secretary
        General
        Jürgen Stock have launched an INTERPOL initiative to strengthen Africa’s global law enforcement role by
        improving its
        ability to share and receive police information.The I-ONE launch provided an opportunity for the four
        African
        regional
        pol...
    </div>
    <span class="date"> 12 March 2018</span>
    <h4>INTERPOL capacity building programme targets human trafficking and trans-border crime in West Africa and
        Sahel</h4>
    <div class="contect_news">
        LYON, France– Tackling human trafficking and strengthening borders in the West Africa
        – Sahel region was the
        focus of
        two INTERPOL training sessions in Mauritania and Senegal.The capacity building events (21 - 29 August 2017)
        aimed to
        provide frontline officers with the skills and knowledge required to more effectively curb human trafficking
        across the
        re...
    </div>
    <span class="date"> 20 September 2017</span>

    <h4> Alcohol tops list of EUR 230 million fake food and drink seizures in global operation</h4>
    <div class="contect_news">
        Nearly 26 million litres of fake alcohol has been seized in a&nbsp; joint
        INTERPOL-Europol operation targeting
        fake food
        and drink around the world.In the sixth Operation Opson, which involved police, customs, national food
        regulatory
        authorities and partners from the private sector in&nbsp; 61 countries, counterfeit alcohol was the most
        seized
        product,
        f...
    </div>
    <span class="date"> 25 April 2017</span>

    <h4> Regional threats require a global response – INTERPOL Chief in Central Africa</h4>
    <div class="contect_news">
        MALABO, Equatorial Guinea – INTERPOL Secretary General Jürgen Stock has said that
        regional law enforcement
        cooperation
        in Central Africa is interconnected with security efforts across Africa and beyond.Speaking at a meeting of
        security
        ministers from countries of the Central African Police Chiefs Committee (CAPCCO) which was officially opened
        by
        Prime
        Min...
    </div>
    <span class="date">10 September 2016</span>

    <h4> 1,500 police in operation targeting crime networks across Eastern and Southern Africa</h4>
    <div class="contect_news">
        KENYA/ZIMBABWE - An operation across Eastern and Southern Africa targeting
        transnational crimes including human,
        drug
        and arms trafficking, people smuggling, terrorism, car theft and environmental crime has resulted in nearly
        4,500
        arrests.To address the wide-ranging yet often interlinked types of crime across the region, some 1,500
        officers
        were
        deployed...
    </div>
    <span class="date">12 July 2016</span>
</div>
﻿<a href="/jsp/main/main.jsp">${back}</a>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

</body>
</html>
