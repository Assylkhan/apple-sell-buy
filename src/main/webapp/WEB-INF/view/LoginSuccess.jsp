<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage title="profile">
    <div align="center">
        <h1>My profile</h1>

        <p>email: <b><s:property value="user.email"/></b></p>

        <p>username: <b><s:property value="user.username"/></b></p>

        <p>password: <b>${user != null ? user.password : ""}</b></p>
    </div>
</t:genericPage>
