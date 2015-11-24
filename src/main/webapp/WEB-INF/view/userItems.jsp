<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href='<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.css"/>'>
    <script src='<c:url value="/webjars/jquery/2.1.4/jquery.js"/>'></script>
    <script src='<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.js"/>'></script>
    <link rel="stylesheet" href="/static/css/main.css">
    <title>items</title>
</head>
<body>
<ul>
    <li class="row">
        <div class="col-md-3"><img src="<c:url value='/static/image/macBook.jpg'/>"></div>
        <div class="col-md-6">${user.item.name},
        ${user.item.region}, ${user.item.publicationDate}</div>
        <div class="col-md-3">
            <div class="row">${user.price}$</div>
            <div class="row"><a href="">open</a></div>
        </div>
    </li>
</ul>
</body>
</html>
