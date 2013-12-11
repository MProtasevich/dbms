<%@include file="../prelude.jsp" %>

<c:if test="${!empty debuts}">
    <div class="${defContainer}">
        <c:forEach items="${debuts}" var="debut">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/debuts/edit/${debut.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span7">
                    <b><c:out value="[${debut.debutDescr}]: "/></b>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>