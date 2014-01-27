<%@include file="../prelude.jsp"%>

<fieldset id="setOfParams">
    <form:input path="id" type="hidden" value="${memberFee.id}"/>
    <div class="control-group">
        <form:label path="feeAmount" cssClass="control-label">
            <c:out value="Fee amount"/>
            <form:errors path="feeAmount" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="feeAmount" type="number" placeholder="Debut description" cssClass="error" min="0.0" step="0.01"/>
        </div>
    </div>

    <div class="control-group">
        <form:label path="year" cssClass="control-label">
            <c:out value="Year"/>
            <form:errors path="year" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="year" type="number" placeholder="Debut description" cssClass="error" min="1900"/>
        </div>
    </div>

    <div class="control-group">
        <form:label path="chessplayer.id" cssClass="control-label">
            <c:out value="Chessplayer"/>
            <form:errors path="chessplayer.id" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:select path="chessplayer.id" cssClass="error">
                <c:forEach items="${players}" var="tournament">
                    <form:option value="${player.id}" label="${player.surname} ${player.forename} ${player.middleName}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>

    <div class="control-group">
        <div class="controls">
            <input type="submit" class="btn" value="Submit">
        </div>
    </div>
</fieldset>