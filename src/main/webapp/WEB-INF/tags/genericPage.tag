<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="title" required="true" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <link rel="stylesheet" href='<c:url value="/webjars/bootstrap/3.3.5/css/bootstrap.css"/>'>
    <script src='<c:url value="/webjars/jquery/2.1.4/jquery.js"/>'></script>
    <script src='<c:url value="/webjars/bootstrap/3.3.5/js/bootstrap.js"/>'></script>
    <script src="<c:url value='/static/js/application.js'/>"></script>

    <link rel="stylesheet" href="<c:url value='/static/css/main.css'/>" type="text/css">
    <%--<link rel="icon" href='<c:url value="/static/image/logoTitle.ico"/>' type="image/x-icon">--%>
    <title>${title}</title>
</head>
<body>
<header class="header">
    <div class="navbar">
        <ul class="list-unstyled pull-left">
            <li><a href="<c:url value='/items'/>">home</a></li>
        </ul>
        <ul class="list-unstyled pull-right">
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <li>
                        <a href="<c:url value='/fillItem'/>">new item</a>
                    </li>
                    <li>
                        <a href="<c:url value='/userItems'/>">
                            my items
                        </a>
                    </li>
                    <li><a href="<c:url value='/logout'/>">logout</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value='/login'/>">login</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</header>

<div class="content">
    <jsp:doBody/>
</div>
<%--<div class="push"></div>--%>
<footer class="footer">

</footer>
</body>
</html>
