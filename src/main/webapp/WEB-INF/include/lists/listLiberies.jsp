<%@include file="../prelude.jsp" %>

<c:if test="${!empty liberties}">
    <div class="${defContainer}">
        <c:forEach items="${liberties}" var="liberty">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/liberties/edit/${liberty.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span7">
                    <b><c:out value="[${liberty.libertyDescr}]: "/></b>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>