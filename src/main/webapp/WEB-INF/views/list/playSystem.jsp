<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Play systems"/></h1>
    <a href="${contextPath}/playSystems/add" class="btn btn-small">
        <c:out value="Add play system"/>
    </a>
    <%@include file="../../include/lists/listPlaySystems.jsp"%>
</div>

<%@include file="../close.jsp"%>