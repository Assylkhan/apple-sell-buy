<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Spring and Struts Integration</title>
</head>
<body>
<div align="center">
  <h1>Spring and Struts Integration</h1>

  <h2>Registration</h2>
  <s:form action="registrationProcess" method="execute">
    <s:textfield label="username" name="user.username"/>
    <s:textfield label="email" name="user.email"/>
    <b><s:fielderror value="user.asik"/></b>
    <s:password label="password" name="user.password" />
    <s:submit key="register"></s:submit>
  </s:form>
</div>
</body>
</html>
