<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../include/header.jsp"/>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Edit game"/></h1>

        <form:form commandName="editGame" cssClass="form-horizontal" action="/game/edit" method="POST">
            <%@include file="../include/forms/gameForm.jsp"%>
        </form:form>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>
</html>