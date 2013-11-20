<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script src="/resources/js/management.js"></script>-->
    <script type="text/javascript" src="${contextPath}resources/js/management.js"></script>
    <script type="text/javascript">
        var checkin = $('#dateOfStart').datepicker({
            onRender: function(date) {
                return '';
            }
        }).on('changeDate', function(ev) {
                    if (ev.date.valueOf() > checkout.date.valueOf()) {
                        var newDate = new Date(ev.date);
                        newDate.setDate(newDate.getDate() + 1);
                        checkout.setValue(newDate);
                    }
                    checkin.hide();
                    $('#dateOfCompletion')[0].focus();
                }).data('datepicker');
        var checkout = $('#dateOfCompletion').datepicker({
            onRender: function(date) {
                return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
            }
        }).on('changeDate', function(ev) {
                    checkout.hide();
                }).data('datepicker');
    </script>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Get player's games"/></h1>

        <!-- List of already added questions -->
        <c:if test="${!empty games}">
            <div class="${defContainer}">
                <c:forEach items="${games}" var="player" varStatus="status">
                    <form action="/game/edit/${player.id}" method="GET">
                        <hr>
                        <div class="row-fluid">
                            <div class="span1">
                                <button type="submit" class="btn btn-small">
                                    <i class="icon-edit"></i>
                                </button>
                            </div>
                            <div class="span5">
                                <b><c:out value="[${player.tournament.title} ${player.tournament.dateOfStart.year + 1900}]: ${player.whitePlayer.surname} - ${player.blackPlayer.surname}"/></b>
                            </div>
                            <div class="span3">
                                <c:out value="${player.whiteDebut.debutDescr} - ${player.blackDebut.debutDescr}" />
                            </div>
                            <div class="span3">
                                <c:out value="${player.gameResult.winner.surname} - ${player.gameResult.loser.surname}" />
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