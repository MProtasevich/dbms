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
        <h1><c:out value="Add chessplayer"/></h1>

        <form:form commandName="newPlayer" cssClass="form-horizontal" action="/players/add" method="POST">
            <%@include file="../include/forms/playerForm.jsp"%>
        </form:form>

        <%@include file="../include/forms/listPlayers.jsp"%>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>