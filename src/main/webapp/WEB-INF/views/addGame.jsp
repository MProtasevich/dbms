<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
    <!--<script src="/resources/js/management.js"></script>-->
    <script type="text/javascript" src="${contextPath}resources/js/management.js"></script>

    <style type="text/css" src="${contextPath}resources/css/line.css"></style>
</head>

<body>
<div class="${defContainer}">
    <%@include file="../include/navbar.jsp"%>
    <div class="${defSpan}">
        <h1><sf:message code="label.tests.edit"/></h1>

        <sf:message code="label.tstsst" var="emptyQuestion"/>

        <!-- Form for adding new question -->
        <form:form commandName="newQuestion" cssClass="form-horizontal"
                   action="/questions/addQuestion" method="POST">
            <sf:message code="label.question.addAnswer" var="addAnswer"/>
            <fieldset id="setOfParams">
                <div class="control-group">
                    <form:label path="question" cssClass="control-label">
                        <sf:message var="questionPlch" code="label.quiz.question"/>
                        <c:out value="${questionPlch}"/>
                        <form:errors path="question" cssClass="text-error"/>
                    </form:label>
                    <div class="controls">
                        <form:textarea path="question" rows="3" cols="86" placeholder="${questionPlch}" cssClass="error" name="question"/>
                    </div>
                </div>
                <div class="control-group">
                    <form:label path="title.id" cssClass="control-label">
                        <sf:message code="label.title"/>
                    </form:label>
                    <div class="controls">
                        <form:select path="title.id" items="${categories}" itemValue="id" itemLabel="title"/>
                        <hr class="answer">
                    </div>
                </div>

                <sf:message code="label.quiz.right_answer" var="right"/>
                <sf:message code="label.question.answer" var="replace"/>
                <script type="text/javascript">
                    /*add_quiz("${right}", "${replace}");
                     add_quiz("${right}", "${replace}");*/
                    $(document).ready(function() {
                        var $addAnswer = $("#addAnswer");
                        $addAnswer.click().click();
                    });
                </script>
            </fieldset>

            <div class="control-group">
                <div class="controls">
                    <sf:message var="addLabel" code="label.quiz.add"/>
                    <sf:message var="emptyVar" code="label.tstsst"/>
                    <input type="submit" class="btn" value="${addLabel}" onclick="return checkNewQuestion()"/>
                    <a href="#" class="btn" id="addAnswer">
                        <c:out value="${addAnswer}"/>
                    </a>
                </div>
            </div>
        </form:form>
        <!-- End of question adding -->

        <!-- List of already added questions -->
        <c:if test="${!empty questions}">
            <div class="${defContainer}">
                <c:forEach items="${questions}" var="question" varStatus="status">
                    <form action="/questions/editQuestion/${question.id}" method="GET">
                        <hr>
                        <div class="row-fluid">
                            <div class="span1">
                                <button type="submit" class="btn btn-small">
                                    <i class="icon-edit"></i>
                                </button>
                            </div>
                            <div class="span7">
                                <b><c:out value="[${question.category.category}]: "/></b>
                                <c:out value="${question.question}"/>
                            </div>
                            <div class="span4">
                                <sf:message code="label.quiz.right_answer" var="rightAnswer"/>
                                <c:forEach items="${question.answers}" var="answer">
                                    <div class="row-fluid info">
                                        <c:choose>
                                            <c:when test="${answer.correct}">
                                                <i class="icon-ok" title="${rightAnswer}"></i>
                                            </c:when>
                                            <c:otherwise>
                                                <i class="icon-remove"></i>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:out value="${answer}"/>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </form>
                </c:forEach>
            </div>
        </c:if>
        <!-- End of list -->
    </div>
</div>
</body>
<%@include file="../include/footer.jsp" %>

</html>