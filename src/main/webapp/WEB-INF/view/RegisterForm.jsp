<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage title="registration">
    <div align="center">
        <h1>Spring and Struts Integration</h1>

        <h2>Registration</h2>
        <s:actionerror/>
        <s:form action="registrationProcess" method="execute">
            <s:textfield label="username" name="user.username"/>
            <s:textfield label="email" name="user.email"/>
            <s:password label="password" name="user.password"/>
            <s:submit key="register"></s:submit>
        </s:form>
    </div>
</t:genericPage>
