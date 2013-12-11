<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Liberties"/></h1>

    <a href="${contextPath}/liberties/add" class="btn btn-small">
        <c:out value="Add new liberty"/>
    </a>

    <%@include file="../../include/lists/listLiberies.jsp"%>
</div>

<%@include file="../close.jsp"%>