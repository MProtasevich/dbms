<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit game"/></h1>

    <form:form commandName="game" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/gameForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>