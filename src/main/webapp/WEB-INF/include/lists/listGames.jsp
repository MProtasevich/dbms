<%@include file="../prelude.jsp" %>

<c:if test="${!empty games}">
    <div class="${defContainer}">
        <c:forEach items="${games}" var="game" varStatus="status">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/games/edit/${category.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span7">
                    <b><c:out value="[${game.tournament.title}]: "/></b>
                    <c:out value="Winner: ${game.gameResult.winner.surname}, loser: ${game.gameResult.loser.surname}"/>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>