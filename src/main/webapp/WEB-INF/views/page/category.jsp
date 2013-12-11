<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit category"/></h1>
    <form:form commandName="category" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/categoryForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>