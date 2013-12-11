<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" value="${tournament.id}" type="hidden" />
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
            <form:input path="registrationFee" type="number" cssClass="error" min="0" step="0.1"/>
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
            <form:input path="firstPlaceWinnings" type="number" cssClass="error" min="0" step="0.1"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="secondPlaceWinnings" cssClass="control-label">
            <c:out value="Second place winnings"/>
        </form:label>
        <div class="controls">
            <form:input path="secondPlaceWinnings" type="number" cssClass="error" min="0" step="0.1"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="thirdPlaceWinnings" cssClass="control-label">
            <c:out value="Third place winnings"/>
        </form:label>
        <div class="controls">
            <form:input path="thirdPlaceWinnings" type="number" cssClass="error" min="0" step="0.1"/>
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