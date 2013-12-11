<%@include file="../include/prelude.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="../include/header.jsp"/>
</head>

<body>
<%@include file="../include/navbar.jsp" %>

<div class="${defContainer}" id="main">
    <div class="${defSpan}">
        <h1><c:out value="${labelText}"/></h1>
        <p><c:out value="${labelText}"/></p>
    </div>
</div>
</body>
</html>