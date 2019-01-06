<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrapper">
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="row" id="main">
            <div id="content">
                <img src="/image/bg_header.jpg" width="1620" height="177">
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel with-nav-tabs panel-primary">
                    <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary">
                                All News</a></li>
                        </ul>
                    </div>


                    <div class="panel-body">
                        <div class="tab-content">
                            <div class="tab-pane fade in active" id="tab1primary">
                                <div class="well">
                                    <c:forEach var="news" items="${news}">
                                    <div class="media">
                                        <a class="pull-left" href="#">
                                            <c:choose>
                                                <c:when test="${not empty news.encodedPhoto}">
                                                    <img class="media-object" src="data:image/jpeg;base64,${news.encodedPhoto}"/>

                                                </c:when>
                                                <c:otherwise>
                                                    -
                                                </c:otherwise>
                                            </c:choose>
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">${news.getNewsId()}</h4>
                                            <p class="text">${news.getTopic()}</p>
                                            <p>${news.getInformation()}</p>
                                            <ul class="list-inline list-unstyled">
                                                <li><span><i
                                                        class="glyphicon glyphicon-calendar"></i> ${news.getTime()}</span>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>


        <!-- /#wrapper -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>


    </div>
</div>
<!-- /#page-wrapper -->
</div><!-- /#wrapper -->

</body>
</html>