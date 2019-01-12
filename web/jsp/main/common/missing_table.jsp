<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Missing</title>
    <script data-require="jquery@2.0.3" data-semver="2.0.3" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet"
          id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.0/css/font-awesome.min.css">

    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.css">
    <script data-require="jquery@1.10.19" data-semver="1.10.19" type="text/javascript" charset="utf8"
            src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>

    <script>
        <%@include file="/js/modal_script.js"%>
        <%@include file="/js/table.js"%>
    </script>
    <style>
        .col {
            word-wrap: break-word; /* Перенос слов */
        }

        img {
            width: 250px;
            transition: width 0.5s ease;
        }

    </style>
</head>
<body>

<div style="padding: 100px 0px">
    <div class="well">
        <table class="table table-striped table-bordered table-hover" id="table_id">
            <thead>
            <tr>
                <th>#</th>
                <th>Photo</th>
                <th>Name</th>
                <td>Birthday</td>
                <td>Physical description</td>
                <td>Nationality</td>
                <td>Characteristics</td>
                <td>Sex</td>
                <c:if test="${sessionScope.role =='ADMIN'}">
                    <th style="width: 36px;"></th>
                </c:if>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="person" items="${people}">
                <tr>
                    <c:if test="${person.getStatus() == 'missing'}">


                        <td>${person.getPersonId()}</td>
                        <td id="statya">
                            <c:choose>
                                <c:when test="${not empty person.encodedPhoto}">
                                    <img src="data:image/jpeg;base64,${person.encodedPhoto}"/>
                                </c:when>
                                <c:otherwise>
                                    -
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${person.getName()} ${person.getLastName()}</td>
                        <td>${person.getBirthday()}</td>
                        <td>
                            <p>Height:
                                <c:choose>
                                    <c:when test="${not empty person.getHeight()}">
                                        ${person.getHeight()}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose></p>
                            <p>Weight:
                                <c:choose>
                                    <c:when test="${not empty person.getWeight()}">
                                        ${person.getWeight()}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </p>
                            <p>Color of hair:
                                <c:choose>
                                    <c:when test="${not empty person.getColorOfHair()}">
                                        ${person.getColorOfHair()}
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </p>
                        </td>
                        <td>${person.getNationality()}</td>
                        <td style="width: 320px;">
                            <div class="col" style="width: 280px">
                                    ${person.getCharacteristics()}
                            </div>
                        </td>
                        <td>${person.getSex()}</td>
                        <c:if test="${sessionScope.role =='ADMIN'}">
                            <td>

                                <form action="/interpol" method="get">
                                    <input type="hidden" value="REMOVE_PERSON" name="command">
                                    <a href="interpol?command=REMOVE_PERSON&id=${doc.getPersonId()}"><i
                                            class="icon-remove"></i></a>
                                </form>
                            </td>
                        </c:if>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<a href="/jsp/main/main.jsp">Back</a>
<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>


</body>
</html>