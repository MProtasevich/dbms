<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Debuts"/></h1>

    <a href="${contextPath}/debuts/add" class="btn btn-small">
        <c:out value="Add debut"/>
    </a>
    <%@include file="../../include/lists/listDebuts.jsp"%>
</div>

<%@include file="../close.jsp"%>