<%@include file="../prelude.jsp" %>

<c:if test="${!empty memberFees}">
    <div class="${defContainer}">
        <c:forEach items="${memberFees}" var="memberFee">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/memberFees/edit/${memberFee.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <c:set var="player" value="${memberFee.chessplayer}"/>
                <div class="span7">
                    <b><c:out value="${player.surname} ${player.forename} ${player.middleName} paid ${memberFee.feeAmount} C.U. in ${memberFee.year}"/></b>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>