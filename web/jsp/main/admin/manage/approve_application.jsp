<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 06.01.2019
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve</title>
</head>

<style type="text/css">
    #maket {
        width: 100%; /* Ширина всей таблицы */
    }

    TD {
        vertical-align: top; /* Вертикальное выравнивание в ячейках */
        padding: 5px; /* Поля вокруг ячеек */
    }

    TD#leftcol {
        width: 200px; /* Ширина левой колонки */

    }

    TD#rightcol {
        width: 200px;
    }
</style>
</head>
<body>
<c:set var="document" value="${document}"/>
<table cellspacing="0" id="maket">
    <tr>
        <td id="leftcol">Левая колонка
            <div>
                <p>${document.getName()} ${document.getLastName()}</p>
                <p>
                <div class="col" style="width: 280px">
                    ${document.getInformation()}
                </div>
                </p>
                <p>${document.getReward()}</p>
                <p>${document.getTime()}</p>
                <p>${document.getLeadTime()}</p>
                <p><c:choose>
                    <c:when test="${not empty document.encodedPhoto}">
                        <img src="data:image/jpeg;base64,${document.encodedPhoto}"/>
                    </c:when>
                    <c:otherwise>
                        -
                    </c:otherwise>
                </c:choose></p>
            </div>
        </td>
        <td id="rightcol">Правая колонка</td>
    </tr>
</table>

<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/main.jsp">Back</a>

</body>
</html>
