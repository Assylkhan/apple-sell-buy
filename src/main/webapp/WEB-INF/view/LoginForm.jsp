<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericPage title="login">
    <div align="center">
        <h1>Spring and Struts Integration</h1>

        <h2>Users Login</h2>

        <s:actionerror/>
        <p style="color: darkred; font-weight: bold">${noSuchUser}</p>
        <s:form action="loginProcess" method="execute">
            <s:textfield class="form-control" label="email" name="user.email"/>
            <s:password class="form-control" label="password" name="user.password"/>
            <s:submit key="login"></s:submit>
        </s:form>
    </div>
</t:genericPage>
