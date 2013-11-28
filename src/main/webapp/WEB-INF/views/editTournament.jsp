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
        <h1><c:out value="Edit tournament"/></h1>

        <form:form commandName="editTournament" cssClass="form-horizontal" action="/tournaments/edit" method="POST">
            <%@include file="../include/forms/tournamentForm.jsp"%>
        </form:form>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>