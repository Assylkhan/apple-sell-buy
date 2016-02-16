<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericPage title="items">
    <h2>items</h2>

    <form action="/items.action" method="get">
        <div class="row">
            <input name="searchText" value="${empty searchText ? '' : searchText}"
                   placeholder="search" class="form-control" type="text"/>
        </div>
        <div class="row">
            <button type="submit" class="btn btn-default">SEARCH</button>
        </div>
    </form>
    <br/>
    <t:itemsList/>
</t:genericPage>
