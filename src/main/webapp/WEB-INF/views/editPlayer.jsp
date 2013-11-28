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
        <h1><c:out value="Edit player"/></h1>

        <form:form commandName="editPlayer" cssClass="form-horizontal" action="/players/edit" method="POST">
            <%@include file="../include/forms/playerForm.jsp"%>
        </form:form>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>