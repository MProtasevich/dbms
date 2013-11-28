<%@include file="../include/prelude.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1>Games</h1>

        <form:form commandName="newGame" cssClass="form-horizontal" action="/games/add" method="POST">
            <%@include file="../include/forms/gameForm.jsp"%>
        </form:form>

    <%@include file="../include/forms/listGames.jsp"%>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp"%>
</html>