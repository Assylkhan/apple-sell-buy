<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericPage title="new item">
    <div>
        <h1 align="center">Spring and Struts Integration</h1>

        <h1>itemId - ${empty item ? '' : item.id}</h1>

        <h2 align="center">Users Login</h2>

        <h1 id="alert"></h1>
        <s:actionerror/>

        <s:form action="postItem" enctype="multipart/form-data" method="post">

            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_name">item name:</label>
                    <input type="text" value="${empty item ? '' : item.name}"
                           id="postItem_item_name"
                           class="form-control" name="item.name">
                </div>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label
                            for="postItem_item_description">
                        item description:
                    </label>
            <textarea id="postItem_item_description"
                      name="item.description"
                      class="form-control">${empty item ? '' : item.description}</textarea>
                </div>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_region">item region:</label>
                    <input type="text" value="${empty item ? '' : item.region}"
                           id="postItem_item_region"
                           class="form-control" name="item.region">
                </div>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_price">item price:</label>
                    <input type="text" value="${empty item ? '' : item.price}"
                           id="postItem_item_price"
                           class="form-control" name="item.price">
                </div>
            </div>
            <div class="row" id="images">
            <c:set var="first_item_image_id" value="item_image-0"/>
            <c:choose>
                <c:when test="${empty item}">
                    <div class="row" id="image-0">
                        <div class="horizontalCenter form-group col-xs-5">
                            <label for="${first_item_image_id}">item image:</label>
                            <input id="${first_item_image_id}" value=""
                                   type="file" name="imageUpload">
                            <input type="hidden" name="mediaTypes" value="IMAGE"/>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${item.itemImages}" var="image" step="step">
                        <div class="row" id="image-${step - 1}">
                            <div class="horizontalCenter form-group col-xs-5">
                                <label for="${first_item_image_id}">item image:</label>
                                <input id="${first_item_image_id}" value="<c:url value='${image.mediaRef}'/>"
                                       type="file" name="imageUpload">
                                <input type="hidden" name="mediaTypes" value="IMAGE"/>
                            </div>
                        </div>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <button id="addMoreImage" type="button">add more image</button>
                </div>
            </div>

            <div class="row">
                <div class="horizontalCenter  form-group col-xs-5">
                    <s:submit value="upload all"/>
                </div>
            </div>
        </s:form>
    </div>
</t:genericPage>
