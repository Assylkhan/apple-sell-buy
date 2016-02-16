<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@attribute name="imagePath" required="false" %>
<ul class="list-unstyled">

    <c:forEach items="${items}" var="item">
        <s:url id="userItemAction" action="userItem">
            <s:param name="id">${item.id}</s:param>
        </s:url>
        <li class="row" style="background: greenyellow;">
            <div class="col-md-3">
                <s:a href="%{userItemAction}">
                    <t:itemImageInList imagePath="${empty item.itemImages ?
                '/static/image/macBook.jpg' : item.itemImages[0].mediaRef}"/>
                </s:a>
            </div>
            <div class="col-md-6">
                <div class="row">
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
        <br/>
    </c:forEach>
</ul>
