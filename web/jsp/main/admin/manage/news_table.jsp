<%--
  Created by IntelliJ IDEA.
  User: Женёк
  Date: 06.01.2019
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News</title>
</head>
<body>
<form action="/interpol" method="get">
    <input type="hidden" value="NEWS_ADD_PAGE" name="command">
    <div class="btn-toolbar">
        <button type="submit" class="btn btn-primary">Add event</button>
    </div>
</form>
</body>
</html>
