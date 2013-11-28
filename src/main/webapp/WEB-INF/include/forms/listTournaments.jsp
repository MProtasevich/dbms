<%@include file="../prelude.jsp"%>

<c:if test="${!empty tournaments}">
    <div class="${defContainer}">
        <c:forEach items="${tournaments}" var="player" varStatus="status">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="/tournaments/edit/${player.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span3">
                    <b><c:out value="[${player.title}]: ${player.registrationFee}"/></b>
                </div>
                <div class="span4">
                    <c:out value="${player.dateOfStart} - ${player.dateOfCompletion}" />
                </div>
                <div class="span4">
                    <c:out value="${player.playSystem.systemDescr}" />
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>