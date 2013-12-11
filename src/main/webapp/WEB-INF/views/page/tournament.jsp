<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit tournament"/></h1>

    <form:form commandName="tournament" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/tournamentForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>