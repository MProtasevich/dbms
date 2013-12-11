<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit liberty"/></h1>

    <form:form commandName="liberty" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/libertyForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>