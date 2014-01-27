<%@include file="../prelude.jsp"%>

<c:if test="${!empty players}">
    <div class="${defContainer}">
        <hr style="border-color: #FFF">
        <div class="row-fluid">
            <div class="span1">
            </div>
            <div class="span5">
                <b><c:out value="[Chessplayer]"/></b>
            </div>
            <div class="span3">
                <c:out value="Birthdate" />
            </div>
            <div class="span3">
                <c:out value="Player's category" />
            </div>
        </div>
        <c:forEach items="${players}" var="player">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/players/edit/${player.id}" class="btn btn-small">
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