<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<html>
<head>
    <title>World</title>
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
    <div class="contect_news">
        <p>At INTERPOL today, we have a global membership of 194 countries. Each country maintains a National Central
            Bureau (NCB),
            staffed by national law enforcement officers. It forms the link with INTERPOL's global network, enabling
            member
            countries to work together on cross-border investigations. NCBs are increasingly involved in shaping the
            Organization's
            direction.
        </p>
        <h5>A</h5>
        <p>Afghanistan | Albania | Algeria | Andorra | Angola | Anguilla (UK) | Antigua & Barbuda | Argentina | Armenia
            |
            Aruba | Australia | Austria | Azerbaijan</p>

        <h5> B</h5>
        <p>Bahamas | Bahrain | Bangladesh | Barbados | Belarus | Belgium | Belize | Benin | Bermuda (UK) | Bhutan |
            Bolivia
            | Bosnia and Herzegovina | Botswana | Brazil | British Virgin Islands (UK) | Brunei | Bulgaria |
            Burkina-Faso |
            Burundi</p>

        <h5> C</h5>
        <p>Cambodia | Cameroon | Canada | Cape Verde | Cayman Islands (UK) | Central African Republic | Chad | Chile |
            China | Colombia | Comoros | Congo | Congo (Democratic Rep.) | Costa Rica | Croatia | Cuba | Curaçao |
            Cyprus |
            Czech Republic | Côte d'Ivoire</p>

        <h5> D</h5>
        <p> Denmark | Djibouti | Dominica | Dominican Republic</p>

        <h5>E</h5>
        <p>Ecuador | Egypt | El Salvador | Equatorial Guinea | Eritrea | Estonia | Eswatini | Ethiopia</p>

        <h5>F</h5>
        <p> Fiji | Finland | Former Yugoslav Republic of Macedonia | France</p>

        <h5> G</h5>
        <p>Gabon | Gambia | Georgia | Germany | Ghana | Gibraltar (UK) | Greece | Grenada | Guatemala | Guinea |
            Guinea</p>
        Bissau | Guyana

        <h5> H</h5>
        <p>Haiti | Honduras | Hong Kong (China) | Hungary</p>

        <h5>I</h5>
        <p>Iceland | India | Indonesia | Iran | Iraq | Ireland | Israel | Italy</p>

        <h5>J</h5>
        <p>Jamaica | Japan | Jordan</p>

        <h5> K</h5>
        <p>Kazakhstan | Kenya | Kiribati | Korea (Rep. of) | Kuwait | Kyrgyzstan</p>

        <h5> L</h5>
        <p>Laos | Latvia | Lebanon | Lesotho | Liberia | Libya | Liechtenstein | Lithuania | Luxembourg</p>

        <h5> M</h5>
        <p>Macao (China) | Madagascar | Malawi | Malaysia | Maldives | Mali | Malta | Marshall Islands | Mauritania |
            Mauritius | Mexico | Moldova | Monaco | Mongolia | Montenegro | Montserrat (UK) | Morocco | Mozambique |
            Myanmar</p>

        <h5> N</h5>
        <p>Namibia | Nauru | Nepal | Netherlands | New Zealand | Nicaragua | Niger | Nigeria | Norway</p>

        <h5>O</h5>
        <p>Oman</p>

        <h5> P</h5>
        <p>Pakistan | Palestine | Panama | Papua New Guinea | Paraguay | Peru | Philippines | Poland | Portugal</p>

        <h5> Q</h5>
        <p>Qatar</p>

        <h5> R</h5>
        <p> Romania | Russia | Rwanda</p>

        <h5> S</h5>
        <p> Samoa | San Marino | Sao Tome & Principe | Saudi Arabia | Senegal | Serbia | Seychelles | Sierra Leone |
            Singapore | Sint Maarten | Slovakia | Slovenia | Solomon Islands | Somalia | South Africa | South Sudan
            (Rep.
            of) | Spain | Sri Lanka | St Kitts & Nevis | St Lucia | St Vincent & Grenadines | Sudan | Suriname | Sweden
            |
            Switzerland | Syria</p>

        <h5> T</h5>
        <p> Tajikistan | Tanzania | Thailand | Timor Leste | Togo | Tonga | Trinidad & Tobago | Tunisia | Turkey |
            Turkmenistan | Turks & Caicos (UK)</p>

        <h5> U</h5>
        <p> Uganda | Ukraine | United Arab Emirates | United Kingdom | United States | Uruguay | Uzbekistan</p>

        <h5>V</h5>
        <p> Vanuatu | Vatican City State | Venezuela | Vietnam</p>

        <h5> W</h5>
        <h5> X</h5>
        <h5> Y</h5>
        <p> Yemen</p>

        <h5> Z</h5>
        <p> Zambia | Zimbabwe</p>
    </div>
</div>
<a style="padding: 40px 0px" href="/jsp/main/main.jsp">${back}</a>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

</body>
</html>
