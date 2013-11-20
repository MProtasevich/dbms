<meta charset="utf-8">
<title>Lab1</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Le styles -->
<c:set value="${pageContext.request.contextPath}/resources/" var="resources" />
<c:set value="${resources}css/" var="css" />
<c:set value="${resources}js/" var="js"/>
<link href="${css}bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="${css}datepicker.css" rel="stylesheet" type="text/css">
<link href="${css}line.css" rel="stylesheet" type="text/css">
<style>
    body {
        padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        background-color: #f5f5f5;
    }
</style>
<link href="${css}bootstrap-responsive.min.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

<%--    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="../assets/ico/favicon.png">--%>

<script src="${js}jquery.min.js"></script>
<script src="${js}bootstrap.min.js"></script>
<script src="${js}bootstrap-datepicker.js"></script>