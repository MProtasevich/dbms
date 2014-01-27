<%@include file="../open.jsp"%>

<div class="${defSpan}">
    <h1><c:out value="Edit player"/></h1>

    <form:form commandName="player" cssClass="form-horizontal" action="/players/edit" method="POST">
        <c:set var="playerId" value="${player.id}"/>
        <%@include file="../../include/forms/playerForm.jsp"%>
    </form:form>
</div>

<%@include file="../close.jsp"%>