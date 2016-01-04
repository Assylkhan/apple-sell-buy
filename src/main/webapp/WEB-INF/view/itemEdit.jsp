<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericPage title="edit item">
  <div align="center">
    <h1>Spring and Struts Integration</h1>

    <h2>Users Login</h2>

    <s:actionerror/>

    <s:form action="itemEdit" method="execute">
      <s:textfield class="form-control" label="item name" name="item.name"/>
      <s:textfield label="price" name="item.price"/>
      <s:submit key="change"></s:submit>
    </s:form>
  </div>
</t:genericPage>
