<%@include file="../open.jsp" %>

<div class="${defSpan}">
    <h1><c:out value="Games"/></h1>

    <a href="${contextPath}/games/add" class="btn btn-small">
        <c:out value="Add new game"/>
    </a>

    <%@include file="../../include/lists/listGames.jsp"%>
</div>

<%@include file="../close.jsp" %>