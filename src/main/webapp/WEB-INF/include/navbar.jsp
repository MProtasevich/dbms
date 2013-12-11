<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<script type="text/javascript">
    //var mainContent = $("div#main");
    /*$(document).ready(function() {
        $("a").click(function() {
            $("li.active").toggleClass("active");
            $(this).parent().toggleClass("active");
        });
    });*/
    function redirect(e) {
        var playerSurname = prompt('Enter player\'s surname', 'Surname');
        if(playerSurname != null) {
            e.target.href = e.target.href + playerSurname;
            //console.log(e.target.href);
        } else {
            return false;
        }
        return true;
    }

    /*$(document).ready(function() {
        $("a[href!='#']").click(ajaxRequest);
    });

    function ajaxRequest(e) {
        var pageURL = $(this).attr("href");
        console.log(pageURL);
        $.get(pageURL, function(data) {
            replaceData(data);

            /*if(pageURL != window.location) {
                window.history.pushState({ path: pageURL }, "", pageURL);
            }/
            $("a[href!='#']").click(ajaxRequest);
            $("input[type='submit']").click(ajaxSubmit);
        });

        $(this).parent().click();
        return false;
    }

    function ajaxSubmit(e) {
        var form = $("form");
        $.get(form.action, form.serialize());
    }

    function replaceData(data) {
        var mainContent = $("div#main");
        mainContent.html(data);
    }*/
</script>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <c:set var="labelText" value="DBMS"/>
            <a class="brand" href="${contextPath}"><c:out value="${labelText}"/></a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            CRU<s>D</s>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${contextPath}/categories">
                                    <c:out value="Categories"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/debuts">
                                    <c:out value="Debuts"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/games">
                                    <c:out value="Games"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/liberties">
                                    <c:out value="Liberties"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/memberFees">
                                    <c:out value="Member fees"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/players">
                                    <c:out value="Players"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/tournaments">
                                    <c:out value="Tournaments"/>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            Queries
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${contextPath}/getGameByPlayer/" onclick="return redirect(event);">
                                    <c:out value="Get player's games"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/getUnpaid">
                                    <c:out value="Get players, who didn't pay fees this year"/>
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/getFiveOldest">
                                    <c:out value="Get five oldest players"/>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!--/.nav-collapse -->
        </div>
    </div>
</div>