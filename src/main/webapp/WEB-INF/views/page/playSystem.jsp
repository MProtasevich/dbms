<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit play system"/></h1>
    <form:form commandName="debut" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/playSystemForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>