<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericPage title="login">
  <div align="center">
    <h1>Spring and Struts Integration</h1>

    <h2>Users Login</h2>

    <s:actionerror/>

    <s:form action="postItem" method="execute">
      <s:textfield class="form-control" label="item name" name="item.name"/>
      <s:textarea class="form-control" label="item description" name="item.description">
      </s:textarea>
      <s:textfield class="form-control" label="region" name="item.region"/>
      <s:textfield label="price" name="item.price"/>

      <s:submit key="change"></s:submit>
    </s:form>
  </div>
</t:genericPage>

