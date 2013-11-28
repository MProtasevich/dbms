<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Get player's [${playerName}] games"/></h1>

        <c:if test="${!empty games}">
            <div class="${defContainer}">
                <c:forEach items="${games}" var="game" varStatus="status">
                    <hr>
                    <div class="row-fluid">
                        <div class="span1">
                            <a href="/games/edit/${game.id}" class="btn btn-small">
                                <i class="icon-edit"></i>
                            </a>
                        </div>
                        <div class="span5">
                            <b><c:out value="[${game.tournament.title} ${game.tournament.dateOfStart.year + 1900}]: ${game.whitePlayer.surname} - ${game.blackPlayer.surname}"/></b>
                        </div>
                        <div class="span3">
                            <c:out value="${game.whiteDebut.debutDescr} - ${game.blackDebut.debutDescr}" />
                        </div>
                        <div class="span3">
                            <c:out value="${game.gameResult.winner.surname} - ${game.gameResult.loser.surname}" />
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>