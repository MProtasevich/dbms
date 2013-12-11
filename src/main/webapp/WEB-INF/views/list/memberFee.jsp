<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Member fees"/></h1>
    <a href="${contextPath}/memberFees/add" class="btn btn-small">
        <c:out value="Add member fee"/>
    </a>
    <%@include file="../../include/lists/listMemberFees.jsp"%>
</div>

<%@include file="../close.jsp"%>