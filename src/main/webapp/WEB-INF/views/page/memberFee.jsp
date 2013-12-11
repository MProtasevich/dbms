<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit member fee"/></h1>
    <form:form commandName="memberFee" cssClass="form-horizontal" action="${action}" method="POST">
        <%@include file="../../include/forms/memberFeeForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>