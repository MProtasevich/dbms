<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Categories"/></h1>

    <a href="${contextPath}/categories/add" class="btn btn-small">
        <c:out value="Add category"/>
    </a>

    <%@include file="../../include/lists/listCategories.jsp"%>
</div>

<%@include file="../close.jsp"%>