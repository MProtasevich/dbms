<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Chessplayer, who didn't pay fees this year"/></h1>

        <%@include file="../include/forms/listPlayers.jsp"%>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>