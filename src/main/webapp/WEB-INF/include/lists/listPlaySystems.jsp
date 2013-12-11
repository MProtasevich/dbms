<%@include file="../prelude.jsp" %>

<c:if test="${!empty playSystems}">
    <div class="${defContainer}">
        <c:forEach items="${playSystems}" var="playSystem">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/playSystems/edit/${playSystem.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span7">
                    <b><c:out value="[${playSystem.systemDescr}]: "/></b>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>