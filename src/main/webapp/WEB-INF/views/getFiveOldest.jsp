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
        <h1><c:out value="Five Oldest chessplayers, who played this year"/></h1>

        <c:if test="${!empty players}">
            <div class="${defContainer}">
                <c:forEach items="${players}" var="player" varStatus="status">
                    <form action="/players/edit/${player.id}" method="GET">
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
                            <div class="span2">
                                <c:out value="${player.birthdate}" />
                            </div>
                            <div class="span2">
                                <c:out value="${player.title}" />
                            </div>
                            <div class="span2">
                                <c:out value="${player.winnings}"/>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </c:if>
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>