<%@include file="../prelude.jsp"%>

<c:if test="${!empty players}">
    <div class="${defContainer}">
        <c:forEach items="${players}" var="player">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="/players/edit/${player.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span5">
                    <b><c:out value="[${player.surname} ${player.forename}]:"/></b>
                </div>
                <div class="span3">
                    <c:out value="${player.birthdate}" />
                </div>
                <div class="span3">
                    <c:out value="${player.category.typeOfCategory}" />
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>