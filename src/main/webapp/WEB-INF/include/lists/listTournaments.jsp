<%@include file="../prelude.jsp"%>

<c:if test="${!empty tournaments}">
    <div class="${defContainer}">
        <hr style="border-color: #FFF">
        <div class="row-fluid">
            <div class="span1">
            </div>
            <div class="span3">
                <b><c:out value="[Tournament]: Fee"/></b>
            </div>
            <div class="span4">
                <c:out value="Date of start - date of completion}" />
            </div>
            <div class="span4">
                <c:out value="Tournament's system" />
            </div>
        </div>
        <c:forEach items="${tournaments}" var="tournament" varStatus="status">
            <hr>
            <div class="row-fluid">
                <div class="span1">
                    <a href="${contextPath}/tournaments/edit/${tournament.id}" class="btn btn-small">
                        <i class="icon-edit"></i>
                    </a>
                </div>
                <div class="span3">
                    <b><c:out value="[${tournament.title}]: ${tournament.registrationFee}"/></b>
                </div>
                <div class="span4">
                    <c:out value="${tournament.dateOfStart} - ${tournament.dateOfCompletion}" />
                </div>
                <div class="span4">
                    <c:out value="${tournament.playSystem.systemDescr}" />
                </div>
            </div>
        </c:forEach>
    </div>
</c:if>