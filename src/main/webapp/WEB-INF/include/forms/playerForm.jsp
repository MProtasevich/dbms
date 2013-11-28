<%@include file="../prelude.jsp" %>

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
            <form:select path="category.id" cssClass="error">
                <c:forEach items="${categories}" var="category">
                    <form:option value="${category.id}" label="${category.typeOfCategory}"/>
                </c:forEach>
            </form:select>
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