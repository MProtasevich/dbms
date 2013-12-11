<%@include file="open.jsp" %>

<div class="${defSpan}">
    <h1><c:out value="Chessplayers, who didn't pay fees this year"/></h1>

    <%@include file="../include/lists/listPlayers.jsp"%>
</div>

<%@include file="close.jsp"%>