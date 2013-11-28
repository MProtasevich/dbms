<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script type="text/javascript" src="../../resources/js/datepicker.js"></script>-->
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Add tournament"/></h1>

        <form:form commandName="newTournament" cssClass="form-horizontal" action="/tournaments/add" method="POST">
            <%@include file="../include/forms/tournamentForm.jsp"%>
        </form:form>

        <%@include file="../include/forms/listTournaments.jsp"%>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>