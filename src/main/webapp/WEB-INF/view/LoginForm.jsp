<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring and Struts Integration</title>
</head>
<body>
<div align="center">
    <h1>Spring and Struts Integration</h1>

    <h2>Users Login</h2>
    <s:form action="loginProcess" method="execute">
        <s:textfield label="Username" name="user.username" />
        <s:password label="Password" name="user.password" />
        <s:submit key="login"></s:submit>
    </s:form>
</div>
</body>
</html>