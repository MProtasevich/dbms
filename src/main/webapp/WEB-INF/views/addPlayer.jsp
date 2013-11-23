<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script src="/resources/js/management.js"></script>-->
    <script type="text/javascript" src="${contextPath}resources/js/management.js"></script>

    <link href="${contextPath}/resources/css/line.css" rel="stylesheet"/>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><c:out value="Add chessplayer"/></h1>

        <!-- Form for adding new question -->
        <form:form commandName="newPlayer" cssClass="form-horizontal" action="/players/add/do" method="POST">
            <fieldset id="setOfParams">
                <div class="control-group">
                    <form:label path="forename" cssClass="control-label">
                        <c:out value="Forename"/>
                        <form:errors path="forename" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="forename" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="surname" cssClass="control-label">
                        <c:out value="Surname"/>
                        <form:errors path="surname" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="surname" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="middleName" cssClass="control-label">
                        <c:out value="MiddleName"/>
                        <form:errors path="middleName" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="middleName" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="birthdate" cssClass="control-label">
                        <c:out value="Birthdate"/>
                        <form:errors path="birthdate" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="birthdate" type="date" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="title.id" cssClass="control-label">
                        <c:out value="Category"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="title.id" items="${categories}" itemValue="id" itemLabel="typeOfCategory" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="liberty.id" cssClass="control-label">
                        <c:out value="Liberty"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="liberty.id" items="${liberties}" itemValue="id" itemLabel="libertyDescr" cssClass="error"/>
                    </div>
                </div>

                <div class="control-group">
                    <div class="controls">
                        <input type="submit" class="btn" value="Submit">
                    </div>
                </div>
            </fieldset>
        </form:form>
        <!-- End of question adding -->

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