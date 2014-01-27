<%@include file="open.jsp" %>

<div class="${defSpan}">
    <h1><c:out value="Get player's [${playerName}] games"/></h1>

    <c:if test="${!empty games}">
        <div class="${defContainer}">
            <hr style="border-color: #fff"/>
            <div class="row-fluid">
                <div class="span1">
                </div>
                <div class="span5">
                    <b><c:out value="[Tournament]: white player - black player"/></b>
                </div>
                <div class="span3">
                    <c:out value="white debut - black debut" />
                </div>
                <div class="span3">
                    <c:out value="winner - loser" />
                </div>
            </div>
            <c:forEach items="${games}" var="category" varStatus="status">
                <hr>
                <div class="row-fluid">
                    <div class="span1">
                        <a href="/games/edit/${category.id}" class="btn btn-small">
                            <i class="icon-edit"></i>
                        </a>
                    </div>
                    <div class="span5">
                        <b><c:out value="[${category.tournament.title} ${category.tournament.dateOfStart.year + 1900}]: ${category.whitePlayer.surname} - ${category.blackPlayer.surname}"/></b>
                    </div>
                    <div class="span3">
                        <c:out value="${category.whiteDebut.debutDescr} - ${category.blackDebut.debutDescr}" />
                    </div>
                    <div class="span3">
                        <c:out value="${category.gameResult.winner.surname} - ${category.gameResult.loser.surname}" />
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
<%@include file="close.jsp"%>