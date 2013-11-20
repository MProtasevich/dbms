<%@ page import="java.util.Calendar" %>
<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script src="/resources/js/management.js"></script>-->
    <script type="text/javascript" src="${contextPath}resources/js/management.js"></script>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Five Oldest chessplayers, who played this year"/></h1>

        <!-- List of already added questions -->
        <c:if test="${!empty players}">
            <div class="${defContainer}">
                <c:forEach items="${players}" var="player" varStatus="status">
                    <form action="/players/edit/${player.id}" method="GET">
                        <hr>
                        <div class="row-fluid">
                            <div class="span1">
                                <button type="submit" class="btn btn-small">
                                    <i class="icon-edit"></i>
                                </button>
                            </div>
                            <div class="span5">
                                <b><c:out value="[${player.surname} ${player.forename}]:"/></b>
                            </div>
                            <div class="span2">
                                <c:out value="${player.birthdate}" />
                            </div>
                            <div class="span2">
                                <c:out value="${player.category.typeOfCategory}" />
                            </div>
                            <div class="span2">
                                <c:set var="winnings" value="0" />
                                <c:set var="curYear" value="<%=Calendar.getInstance().get(Calendar.YEAR)%>"/>
                                <c:forEach items="${player.firstPlaceTournaments}" var="firstPlaceTournament">
                                    <c:if test="${firstPlaceTournament.dateOfCompletion.year + 1900 == curYear && firstPlaceTournament.firstPlacePlayer.id == player.id}">
                                        <c:set var="winnings" value="${winnings + firstPlaceTournament.firstPlaceWinnings}" />
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${player.secondPlaceTournaments}" var="secondPlaceTournament">
                                    <c:if test="${secondPlaceTournament.dateOfCompletion.year + 1900 == curYear && secondPlaceTournament.secondPlacePlayer.id == player.id}">
                                        <c:set var="winnings" value="${winnings + secondPlaceTournament.secondPlaceWinnings}" />
                                    </c:if>
                                </c:forEach>
                                <c:forEach items="${player.thirdPlaceTournaments}" var="thirdPlaceTournament">
                                    <c:if test="${thirdPlaceTournament.dateOfCompletion.year + 1900 == curYear && thirdPlaceTournament.thirdPlacePlayer.id == player.id}">
                                        <c:set var="winnings" value="${winnings + thirdPlaceTournament.thirdPlaceWinnings}" />
                                    </c:if>
                                </c:forEach>
                                <c:out value="${winnings}"/>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </c:if>
        <!-- End of list -->
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>