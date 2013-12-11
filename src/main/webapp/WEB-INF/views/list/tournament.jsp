<%@include file="../open.jsp"%>
<!--<script type="text/javascript" src="../../resources/js/datepicker.js"></script>-->

<div class="${defSpan}">
    <h1><c:out value="Add tournament"/></h1>

    <a href="${contextPath}/tournaments/add" class="btn btn-small">
        <c:out value="Add new tournament"/>
    </a>

    <%@include file="../../include/lists/listTournaments.jsp"%>
</div>

<%@include file="../close.jsp"%>