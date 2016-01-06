<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<t:genericPage title="new item">
    <div align="center">
        <h1>Spring and Struts Integration</h1>

        <h2>Users Login</h2>

        <h1 id="alert"></h1>
        <s:actionerror/>

        <form id="postItem" action="/postItem" name="postItem" method="execute">
            <div class="row">
                <div class="form-group col-xs-12">
                    <label class="label" for="postItem_item_name">item name:</label>
                    <input type="text" value=""
                           id="postItem_item_name"
                           class="form-control" name="item.name">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <label class="label"
                           for="postItem_item_description">
                        item description:
                    </label>
                    <textarea id="postItem_item_description"
                              name="item.description"
                              class="form-control"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <label class="label" for="postItem_item_region">item region:</label>
                    <input type="text" value=""
                           id="postItem_item_region"
                           class="form-control" name="item.region">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-xs-12">
                    <label class="label" for="postItem_item_price">item price:</label>
                    <input type="text" value=""
                           id="postItem_item_price"
                           class="form-control" name="item.price">
                </div>
            </div>
            <div class="row" id="images">
                <div class="row" id="image-1">
                    <div class="form-group col-xs-12">
                        <label class="label" for="item_image-1">item image:</label>
                        <input type="file" value=""
                               id="item_image-1"
                               class="form-control" name="medias[0].mediaRef">
                        <input type="hidden" name="medias[0].type" value="image"/>
                    </div>
                </div>
            </div>
            <button id="addMoreImage" type="button">add more image</button>
            <button type="submit">save</button>
        </form>
    </div>
</t:genericPage>
