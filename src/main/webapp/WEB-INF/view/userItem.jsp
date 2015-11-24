<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericPage title="profile">
  <div align="center">
    <h1>${item.name}</h1>

    <p>price: <b><s:property value="item.price"/></b></p>

    <p>description: <b><s:property value="item.description"/></b></p>

    <a class="btn btn-default" href="">change</a>
  </div>
</t:genericPage>