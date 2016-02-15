<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericPage title="item">
    <div align="center">
        <h1>${item.name}</h1>

        <p>price: <b><s:property value="item.price"/></b></p>

        <p>description: <b><s:property value="item.description"/></b></p>

        <div>
            <p>Видео</p>
            <ul>
                <c:forEach items="${item.itemVideos}" var="itemVideo">
                    <li style="border-bottom: solid 1px; border-top: solid 1px;">
                        <p>${itemVideo.mediaRef}</p>
                            <%--<img style="height: 200px; width: 340px" src="${itemVideo.mediaRef}">--%>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div>
            <p>Картинки</p>
            <ul>
                <c:forEach items="${item.itemImages}" var="itemImage">
                    <li>
                        <img src="${itemImage.mediaRef}">
                    </li>
                </c:forEach>
            </ul>
        </div>
            <%--<s:url id="userItemAction" action="userItem">--%>
            <%--<s:param name="id">${item.id}</s:param>--%>
            <%--</s:url>--%>
            <%--<s:a href="%{userItemAction}">--%>
            <%--${item.name}--%>
            <%--</s:a>--%>
        <a href="<c:url value='/editItem'>
            <c:param name="id" value="${item.id}"/>
        </c:url>">edit</a>
            <%--<a class="btn btn-default" href="">change</a>--%>
    </div>
</t:genericPage>
