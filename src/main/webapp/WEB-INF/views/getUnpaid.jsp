<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script src="/resources/js/management.js"></script>-->
    <script type="text/javascript" src="${contextPath}resources/js/management.js"></script>

    <style type="text/css">
        hr {
            -moz-border-bottom-colors: none;
            -moz-border-image: none;
            -moz-border-left-colors: none;
            -moz-border-right-colors: none;
            -moz-border-top-colors: none;
            border-color: #909090;
            border-style: solid none;
            border-width: 1px 0;
            margin: 18px 0;
        }

        hr.answer {
            border-color: #cccccc;
            width: 30%;
        }
    </style>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Chessplayer, who didn't pay fees this year"/></h1>

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
                            <div class="span3">
                                <c:out value="${player.birthdate}" />
                            </div>
                            <div class="span3">
                                <c:out value="${player.category.typeOfCategory}" />
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