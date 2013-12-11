<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" type="hidden" value="${category.id}"/>
    <div class="control-group">
        <form:label path="typeOfCategory" cssClass="control-label">
            <c:out value="Type of category"/>
            <form:errors path="typeOfCategory" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="typeOfCategory" type="text" placeholder="Category description" cssClass="error" maxlength="32"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <input type="submit" class="btn" value="Submit">
        </div>
    </div>
</fieldset>