<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Add chessplayer"/></h1>

    <a href="${contextPath}/players/add" class="btn btn-small">
        <c:out value="Add new chessplayer"/>
    </a>

    <%@include file="../../include/lists/listPlayers.jsp"%>
</div>

<%@include file="../close.jsp"%>