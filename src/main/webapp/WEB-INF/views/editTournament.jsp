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
        <h1><c:out value="Edit tournament"/></h1>

        <!-- Form for adding new question -->
        <form:form commandName="editTournament" cssClass="form-horizontal" action="/tournaments/edit/do" method="POST">
            <fieldset id="setOfParams">
                <form:input path="id" value="${editTournament.id}" type="hidden" />
                <form:input path="chessplayers" value="${editTournament.chessplayers}" type="hidden" />
                <form:input path="games" value="${editTournament.games}" type="hidden" />
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
                    </form:label>
                    <div class="controls">
                        <form:input path="registrationFee" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="playSystem.id" cssClass="control-label">
                        <c:out value="Play system"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="playSystem.id" items="${playSystems}" itemLabel="systemDescr" itemValue="id" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="firstPlaceWinnings" cssClass="control-label">
                        <c:out value="First place winnings"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="firstPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="secondPlaceWinnings" cssClass="control-label">
                        <c:out value="Second place winnings"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="secondPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="thirdPlaceWinnings" cssClass="control-label">
                        <c:out value="Third place winnings"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="thirdPlaceWinnings" type="number" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="dateOfStart" cssClass="control-label">
                        <c:out value="Date of start"/>
                    </form:label>
                    <div class="controls">
                        <form:input path="dateOfStart" type="date" cssClass="error"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="dateOfCompletion" cssClass="control-label">
                        <c:out value="Date of completion"/>
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
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>