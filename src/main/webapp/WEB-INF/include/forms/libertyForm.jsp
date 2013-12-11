<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" type="hidden" value="${liberty.id}"/>
    <div class="control-group">
        <form:label path="discount" cssClass="control-label">
            <c:out value="Discount value"/>
            <form:errors path="discount" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="discount" type="number" min="0" max="1" step="0.05" placeholder="Discount" cssClass="error" maxlength="128"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="libertyDescr" cssClass="control-label">
            <c:out value="Liberty description"/>
            <form:errors path="libertyDescr" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="libertyDescr" type="text" placeholder="Debut description" cssClass="error" maxlength="128"/>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <input type="submit" class="btn" value="Submit">
        </div>
    </div>
</fieldset>