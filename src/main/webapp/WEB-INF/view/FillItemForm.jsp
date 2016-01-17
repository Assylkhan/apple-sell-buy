<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<t:genericPage title="new item">
    <div>
        <h1 align="center">Spring and Struts Integration</h1>

        <h2 align="center">Users Login</h2>

        <h1 id="alert"></h1>
        <s:actionerror/>

        <s:form action="postItem" enctype="multipart/form-data" method="post">

            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_name">item name:</label>
                    <input type="text" value=""
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
                      class="form-control"></textarea>
                </div>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_region">item region:</label>
                    <input type="text" value=""
                           id="postItem_item_region"
                           class="form-control" name="item.region">
                </div>
            </div>
            <div class="row">
                <div class="horizontalCenter form-group col-xs-5">
                    <label for="postItem_item_price">item price:</label>
                    <input type="text" value=""
                           id="postItem_item_price"
                           class="form-control" name="item.price">
                </div>
            </div>
            <div class="row" id="images">
                <div class="row" id="image-0">
                    <div class="horizontalCenter form-group col-xs-5">
                        <label for="item_image-0">item image:</label>
                        <input id="item_image-0" type="file" name="fileUpload">
                        <input type="hidden" name="mediaTypes" value="IMAGE"/>
                    </div>
                </div>
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
