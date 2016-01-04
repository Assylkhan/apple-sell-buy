<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericPage title="items">
    <div class="row">
        <div class="col-md-5 col-md-offset-4">
            <form action="<c:url value='/search'>
                    <c:param name="filter">
                    </c:param>
                </c:url>">
            </form>
        </div>
    </div>

    <div class="row">
        <c:forEach items="${items}" var="item">
        <div class="row">

        </div>
        </c:forEach>
    </div>
</t:genericPage>
