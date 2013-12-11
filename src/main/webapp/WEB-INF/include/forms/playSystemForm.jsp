<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" type="hidden" value="${memberFee.id}"/>
    <div class="control-group">
        <form:label path="systemDescr" cssClass="control-label">
            <c:out value="Play system description"/>
            <form:errors path="systemDescr" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="systemDescr" type="text" placeholder="Play system description" cssClass="error" maxlength="128"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <input type="submit" class="btn" value="Submit">
        </div>
    </div>
</fieldset>