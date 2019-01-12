<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page-wrapper">
    <div class="container-fluid">

        <!-- Page Heading -->
        <div class="row" id="main">
            <div id="content">
                <img src="/image/bg_header.jpg" width="1620" height="177">
            </div>
        </div>
        <!-- /.row -->

        <a href="#"> Gallery</a>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel with-nav-tabs panel-primary">
                    <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary">
                                <%--<span--%>
                                <%--class="glyphicon glyphicon-font"></span>--%>
                                News</a></li>
                            <li><a href="#tab2primary" data-toggle="tab"><span
                                    class="glyphicon glyphicon-heart-empty"></span> Documents </a></li>
                            <li><a href="#tab3primary" data-toggle="tab">Primary 3</a></li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown">Galleria <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#tab4primary" data-toggle="tab"> Wanted persons </a></li>
                                    <li><a href="#tab5primary" data-toggle="tab"> Missing persons </a></li>
                                </ul>
                            </li>
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
                                                        <img class="media-object" src="#"/>
                                                    </c:otherwise>
                                                </c:choose>
                                            </a>
                                            <div class="media-body">
                                                <%--<h4 class="media-heading">${news.getNewsId()}</h4>--%>
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

                            <div class="tab-pane fade" id="tab2primary">
                                <div class="well">
                                    <div class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object"
                                                 src="http://www.moneybook.ro/moneybook-feed.png">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">My statements</h4>
                                            <p class="text">By Manager</p>
                                            <p><img width="300" height="300"
                                                    src="http://i1.wp.com/www.moneybook.ro/wp-content/uploads/2016/08/maieu-ALB_1.jpg?resize=300%2C300"
                                                    class="attachment-image" alt="image1" title="image"
                                                    sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://i1.wp.com/www.moneybook.ro/wp-content/uploads/2015/11/8Martie.png?resize=300%2C265"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://i0.wp.com/www.moneybook.ro/wp-content/uploads/2014/12/pisici.jpg?w=537"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://i0.wp.com/www.moneybook.ro/wp-content/uploads/2014/10/beagle1.jpg?w=448"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px">
                                            </p>
                                            <ul class="list-inline list-unstyled">
                                                <li><span><i
                                                        class="glyphicon glyphicon-calendar"></i> 2018-12-19</span>
                                                </li>
                                                <%--<li>|</li>--%>
                                                <%--<span><i--%>
                                                <%--class="glyphicon glyphicon-comment"></i> 2 comments</span>--%>
                                                <%--<li>|</li>--%>
                                                <%--<li>--%>
                                                <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                                                <%--</li>--%>
                                                <%--<li>|</li>--%>
                                                <%--<li>--%>
                                                <%--<!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->--%>
                                                <%--<span><i class="fa fa-facebook-square"></i></span>--%>
                                                <%--<span><i class="fa fa-twitter-square"></i></span>--%>
                                                <%--<span><i class="fa fa-google-plus-square"></i></span>--%>
                                                <%--</li>--%>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="well">
                                    <div class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object"
                                                 src="http://www.moneybook.ro/moneybook-feed.png">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading"></h4>
                                            <p class="text-right">Manager</p>
                                            <p><img width="300" height="300"
                                                    src="http://dev.webofiice.ro/anunt/oc-content/uploads/0/7_thumbnail.jpg"
                                                    class="attachment-image" alt="image1" title="image"
                                                    sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://dev.webofiice.ro/anunt/oc-content/uploads/0/6_thumbnail.jpg"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://i0.wp.com/www.moneybook.ro/wp-content/uploads/2014/12/pisici.jpg?w=537"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px">
                                                <img width="300" height="300"
                                                     src="http://i0.wp.com/www.moneybook.ro/wp-content/uploads/2014/10/beagle1.jpg?w=448"
                                                     class="attachment-image" alt="image1" title="image"
                                                     sizes="(max-width: 300px) 100vw, 300px"></p>
                                            <ul class="list-inline list-unstyled">
                                                <li><span><i class="glyphicon glyphicon-calendar"></i> 2 days, 8 hours </span>
                                                    <%--</li>--%>
                                                    <%--<li>|</li>--%>
                                                    <%--<span><i--%>
                                                    <%--class="glyphicon glyphicon-comment"></i> 2 comments</span>--%>
                                                    <%--<li>|</li>--%>
                                                    <%--<li>--%>
                                                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                    <%--<span class="glyphicon glyphicon-star"></span>--%>
                                                    <%--<span class="glyphicon glyphicon-star-empty"></span>--%>
                                                    <%--</li>--%>
                                                    <%--<li>|</li>--%>
                                                    <%--<li>--%>
                                                    <%--<!-- Use Font Awesome http://fortawesome.github.io/Font-Awesome/ -->--%>
                                                    <%--<span><i class="fa fa-facebook-square"></i></span>--%>
                                                    <%--<span><i class="fa fa-twitter-square"></i></span>--%>
                                                    <%--<span><i class="fa fa-google-plus-square"></i></span>--%>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>


                                </div>
                            </div>
                            <div class="tab-pane fade" id="tab3primary">Primary 3</div>
                            <div class="tab-pane fade" id="tab4primary">Primary 4</div>
                            <div class="tab-pane fade" id="tab5primary">Primary 5</div>
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