<%@include file="../prelude.jsp" %>

<c:if test="${!empty categories}">
    <div class="${defContainer}">
        <c:forEach items="${categories}" var="category">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/categories/edit/${category.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span7">
                    <b><c:out value="[${category.typeOfCategory}]: "/></b>
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>