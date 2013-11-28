<%@include file="../prelude.jsp" %>

<fieldset id="setOfParams">
    <div class="control-group">
        <form:label path="date" cssClass="control-label">
            <c:out value="Date"/>
            <form:errors path="date" cssClass="text-error"/>
        </form:label>
        <div class="controls">
            <form:input path="date" type="date" placeholder="Date" cssClass="error"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="numOfTurns" cssClass="control-label">
            <c:out value="Num of turns"/>
        </form:label>
        <div class="controls">
            <form:input path="numOfTurns" type="number" min="0"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="whitePlayer.id" cssClass="control-label">
            <c:out value="White player"/>
        </form:label>
        <div class="controls">
            <form:select path="whitePlayer.id" cssClass="error">
                <c:forEach items="${players}" var="player">
                    <form:option value="${player.id}" label="${player.surname} ${player.forename} ${player.middleName}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <form:label path="blackPlayer.id" cssClass="control-label">
            <c:out value="Black player"/>
        </form:label>
        <div class="controls">
            <form:select path="blackPlayer.id" cssClass="error">
                <c:forEach items="${players}" var="player">
                    <form:option value="${player.id}" label="${player.surname} ${player.forename} ${player.middleName}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <form:label path="whiteDebut.id" cssClass="control-label">
            <c:out value="White player's debut"/>
        </form:label>
        <div class="controls">
            <form:select path="whiteDebut.id" items="${debuts}" itemLabel="debutDescr" itemvalue="id" cssClass="error"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="blackDebut" cssClass="control-label">
            <c:out value="Black player's debut"/>
        </form:label>
        <div class="controls">
            <form:select path="blackDebut.id" items="${debuts}" itemLabel="debutDescr" itemvalue="id" cssClass="error"/>
        </div>
    </div>
    <div class="control-group">
        <form:label path="gameResult.winner.id" cssClass="control-label">
            <c:out value="Winner"/>
        </form:label>
        <div class="controls">
            <form:select path="gameResult.winner.id" cssClass="error">
                <c:forEach items="${players}" var="player">
                    <form:option value="${player.id}" label="${player.surname} ${player.forename} ${player.middleName}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <form:label path="gameResult.loser.id" cssClass="control-label">
            <c:out value="Loser"/>
        </form:label>
        <div class="controls">
            <form:select path="gameResult.loser.id" cssClass="error">
                <c:forEach items="${players}" var="player">
                    <form:option value="${player.id}" label="${player.surname} ${player.forename} ${player.middleName}"/>
                </c:forEach>
            </form:select>
        </div>
    </div>
    <div class="control-group">
        <form:label path="tournament.id" cssClass="control-label">
            <c:out value="Tournament"/>
        </form:label>
        <div class="controls">
            <form:select path="tournament.id" cssClass="error">
                <c:forEach items="${tournaments}" var="tournament">
                    <form:option value="${tournament.id}" label="${tournament.title} ${tournament.dateOfCompletion}"/>
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