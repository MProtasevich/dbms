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
        <h1><c:out value="Edit player"/></h1>

        <!-- Form for adding new question -->
        <form:form commandName="editPlayer" cssClass="form-horizontal" action="/players/edit/do" method="POST">
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
                    <form:label path="category.id" cssClass="control-label">
                        <c:out value="Category"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="category.id" items="${categories}" itemValue="id" itemLabel="typeOfCategory" cssClass="error"/>
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
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>