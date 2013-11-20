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
        <h1><c:out value="Add tournament"/></h1>

        <!-- Form for adding new question -->
        <form:form commandName="newTournament" cssClass="form-horizontal" action="/tournaments/add/do" method="POST">
            <fieldset id="setOfParams">
                <div class="control-group">
                    <form:label path="title" cssClass="control-label">
                        <c:out value="Title"/>
                        <form:errors path="title" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="title" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="registrationFee" cssClass="control-label">
                        <c:out value="Registration Fee"/>
                        <form:errors path="registrationFee" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="registrationFee" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="playSystem.id" cssClass="control-label">
                        <c:out value="MiddleName"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="playSystem.id" items="${playSystems}" itemLabel="systemDescr" itemValue="id" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="firstPlaceWinnings" cssClass="control-label">
                        <c:out value="First place winnings"/>
                        <form:errors path="firstPlaceWinnings" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="firstPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="secondPlaceWinnings" cssClass="control-label">
                        <c:out value="Second place winnings"/>
                        <form:errors path="secondPlaceWinnings" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="secondPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="thirdPlaceWinnings" cssClass="control-label">
                        <c:out value="Third place winnings"/>
                        <form:errors path="thirdPlaceWinnings" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="thirdPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="dateOfStart" cssClass="control-label">
                        <c:out value="Date of start"/>
                        <form:errors path="dateOfStart" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="dateOfStart" type="date" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="dateOfCompletion" cssClass="control-label">
                        <c:out value="Date of completion"/>
                        <form:errors path="dateOfCompletion" cssClass="text-error"/>
                    </form:label>
                    <div class="controls app">
                        <form:input path="dateOfCompletion" type="date" cssClass="error"/>
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
        <c:if test="${!empty tournaments}">
            <div class="${defContainer}">
                <c:forEach items="${tournaments}" var="player" varStatus="status">
                    <form action="/tournaments/edit/${player.id}" method="GET">
                        <hr>
                        <div class="row-fluid">
                            <div class="span1">
                                <button type="submit" class="btn btn-small">
                                    <i class="icon-edit"></i>
                                </button>
                            </div>
                            <div class="span3">
                                <b><c:out value="[${player.title}]: ${player.registrationFee}"/></b>
                            </div>
                            <div class="span4">
                                <c:out value="${player.dateOfStart} - ${player.dateOfCompletion}" />
                            </div>
                            <div class="span4">
                                <c:out value="${player.playSystem.systemDescr}" />
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