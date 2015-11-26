<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
    <c:forEach items="${items}" var="item">
        <li class="row" style="background: greenyellow;">
            <div class="col-md-3">
                <img src="<c:url value='/static/image/macBook.jpg'/>">
            </div>
            <div class="col-md-6">
                <div class="row">
                    <s:url value="userItem" var="userItemAction">
                        <s:param name="id" value="%{item.id}"/>
                    </s:url>
                    <a href="<s:property value="#userItemAction"/>">
                            ${item.name}
                    </a>
                </div>
                <div class="row">${item.region}</div>
                <div class="row">${item.publicationDate}</div>
            </div>
            <div class="col-md-3">
                <div class="row">${item.price}$</div>
            </div>
        </li>
    </c:forEach>
</ul>
</body>
</html>
