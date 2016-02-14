<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericPage title="items">
    <ul>
        <c:forEach items="${items}" var="item">
            <li class="row" style="background: greenyellow;">
                <div class="col-md-3">
                    <img style="height: 100px; width: 150px" src="${empty item.mediasForItem ? "/static/image/macBook.jpg" : item.mediasForItem[0].mediaRef}">
                </div>
                <div class="col-md-6">
                    <div class="row">
                        <s:url id="userItemAction" action="userItem">
                            <s:param name="id">${item.id}</s:param>
                        </s:url>
                        <s:a href="%{userItemAction}">
                            ${item.name}
                        </s:a>
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
</t:genericPage>
