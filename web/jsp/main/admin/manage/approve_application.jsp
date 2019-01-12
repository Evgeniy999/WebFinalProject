<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="infotag" uri="/WEB-INF/tag/infoTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <style type="text/css">
        .col {
            word-wrap: break-word; /* Перенос слов */
        }

        #maket {
            width: 100%; /* Ширина всей таблицы */
        }

        TD {
            vertical-align: top; /* Вертикальное выравнивание в ячейках */
            padding: 5px; /* Поля вокруг ячеек */
        }

        TD#leftcol {
            width: 470px; /* Ширина левой колонки */

        }

        TD#rightcol {
            width: 400px;
        }
    </style>
</head>
<body style="padding-right: 100px">
<c:set var="document" value="${document}"/>
<table cellspacing="0" id="maket">
    <tr>
        <td id="leftcol">
            <p>Statement</p>
            <div>
                <p>Name: ${document.getName()} ${document.getLastName()}</p>
                <p>Information: </p>
                <p>
                <div class="col" style="width: 280px">
                    ${document.getInformation()}
                </div>
                </p>
                <p>Type statement: ${document.getStatement()}</p>
                <p>Reward($): ${document.getReward()}</p>
                <p>Time: ${document.getTime()}</p>
                <p>Lead time: ${document.getLeadTime()}</p>
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
        <td id="rightcol">Form
            <form action="/interpol" method="post" enctype="multipart/form-data">
                <input type="hidden" value="APPROVE_APPLIC" name="command">
                <c:choose>
                    <c:when test="$${document.getStatement() =='missing'}">
                         <input type="hidden" value="1" name="status">
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" value="2" name="status">
                    </c:otherwise>
                </c:choose>
                <input type="hidden" value="${document.getStatement()}" name="status">
                <input type="hidden" value="${document.getDocId()}" name="docId">
                <%--<input type="hidden" value="${document.encodedPhoto}" name="photo">--%>
                <div class="form-horizontal">
                    <fieldset>
                        <%--<div class="panel panel-primary">--%>
                        <%--<div class="panel-heading">Enter Your Details Here--%>
                        <%--</div>--%>
                        <div class="panel-body">
                            <form name="myform">
                                <div class="form-group">
                                    <label for="name">First Name *</label>
                                    <input id="name" name="name" class="form-control" type="text" min="1">
                                    <span id="error_name" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="last">Last Name *</label>
                                    <input id="last" name="last" class="form-control" type="text" min="1">
                                    <span id="error_last" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="birthday">Date Of Birth *</label>
                                    <input type="date" name="birthday" id="birthday" class="form-control"
                                           min="1">
                                    <span id="error_birthday" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="weight">Weight </label>
                                    <input id="weight" name="weight" class="form-control" type="text"
                                           min="1">
                                    <span id="error_weight" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="height">Height </label>
                                    <input id="height" name="height" class="form-control" type="text"
                                           min="1">
                                    <span id="error_height" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="hair">Color hair </label>
                                    <input id="hair" name="hair" class="form-control" type="text" min="1">
                                    <span id="error_hair" class="text-danger"></span>
                                </div>
                                <div class="form-group">
                                    <label for="nationality">Nationality </label>
                                    <input type="text" id="nationality" name="nationality"
                                           class="form-control"
                                           min="1">
                                    <span id="error_nationality" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="gender">Gender</label>
                                    <select name="gender" id="gender" class="form-control">
                                        <option selected>Male</option>
                                        <option>Female</option>
                                        <option>Other</option>
                                    </select>
                                    <span id="error_gender" class="text-danger"></span>
                                </div>

                                <div class="form-group">
                                    <label for="characteristics">Characteristics </label>
                                    <textarea class="form-control" id="characteristics"
                                              name="characteristics"> </textarea>

                                </div>
                                <%--<div style="padding:10px" class="form-group">--%>
                                    <%--<label for="photo">Choose images to upload (PNG, JPG)</label>--%>
                                    <%--<input type="file" id="photo" name="photo" accept=".jpg, .jpeg, .png">--%>
                                <%--</div>--%>

                                <button id="submit" type="submit" value="submit"
                                        class="btn btn-primary center">
                                    Submit
                                </button>
                            </form>
                        </div>
                    </fieldset>
                </div>
                </div>
            </form>
        </td>
    </tr>
</table>

<!-- Post Info -->
<div style='position:fixed;bottom:0;left:0;
            background:lightgray;width:100%;'>
    <infotag:getinfo/>
</div>

<a href="/jsp/main/admin/manage/doc_table.jsp">Back</a>

</body>
</html>
