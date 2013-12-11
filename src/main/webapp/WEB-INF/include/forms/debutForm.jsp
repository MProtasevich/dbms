<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" type="hidden" value="${debut.id}"/>
    <div class="control-group">
        <form:label path="debutDescr" cssClass="control-label">
            <c:out value="Debut description"/>
            <form:errors path="debutDescr" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="debutDescr" type="text" placeholder="Debut description" cssClass="error" maxlength="128"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <input type="submit" class="btn" value="Submit">
        </div>
    </div>
</fieldset>