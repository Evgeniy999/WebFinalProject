<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 31.12.2018
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class="container">
    <div class="contextual">
        <h1 class="titre">Overview</h1>

        <p>INTERPOL is the world’s largest international police organization, with 194 member
            countries </p>
        <p>Our&nbsp;role is to enable police around the world to work together to make the world a safer place. Our
            high-tech infrastructure of technical and operational support helps meet the growing challenges of fighting
            crime in the 21st century.</p>
        <div class="col-2Wrapper">

            <div class="container">
                <h3>Supporting police worldwide</h3>
            </div>
        </div>
        <div class="article last-article">

            <p>We work to ensure that police around the world have access to the tools and services
                necessary to do their jobs effectively. We provide targeted training, expert investigative
                support, relevant data and secure communications channels.</p>
            <p>This combined framework helps police on the ground understand crime trends, analyse
                information, conduct operations and, ultimately, arrest as many criminals as possible.</p>


            <div class="container">
                <h3>Neutrality</h3>
            </div>
        </div>
        <div class="article last-article">

            <p>At INTERPOL, we aim to facilitate international police cooperation even where diplomatic
                relations do not exist between particular countries. Action is taken within the limits of
                existing laws in different countries and in the spirit of the Universal Declaration of Human
                Rights. Our Constitution prohibits ‘any intervention or activities of a political, military,
                religious or racial character'.</p>
        </div>


        <div class="container">
            <h3>Vision and mission</h3>
        </div>
        <div class="article last-article">

            <p>
                The vision: <br>"Connecting police for a safer world".</p>
            <p>
                The mission:<br>"Preventing and fighting crime through enhanced cooperation and innovation
                on police and security matters"</p>
            <p>Read the full ﻿<a href="/About-INTERPOL/Vision-and-mission" target="_self">vision and
                mission</a>.</p>
        </div>


        <div class="container">
            <h3>A global presence</h3>
        </div>

        <div class="article last-article">

            <p>INTERPOL’s General Secretariat is based in Lyon, France, supported by the Global Complex for
                Innovation in Singapore, seven regional bureaus, and Special Representative offices at the
                African Union, the European Union and the United Nations.</p>
            <p>Each of our member countries maintains a National Central Bureau staffed by its own highly
                trained law enforcement officials.</p></div>

        <div class="clear"></div>
    </div>
</div>

<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">Back</a>
</body>
</html>
