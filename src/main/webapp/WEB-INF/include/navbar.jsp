<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<script type="text/javascript">
    /*$(document).ready(function() {
        $("a").click(function() {
            $("li.active").toggleClass("active");
            $(this).parent().toggleClass("active");
        });
    });*/
    function redirect() {
        var playerSurname = prompt('Enter player\'s surname', 'Surname');
        if(playerSurname != null) {
            window.location.href="${contextPath}/getGameByPlayer/" + playerSurname;
        }
    }
</script>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="${contextPath}/">Lab1</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            CRUD
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="${contextPath}/games/add">
                                    Games
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/players/add">
                                    Players
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/tournaments/add">
                                    Tournaments
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
                                <a id="getGameByPlayer" href="#" onclick="redirect();">
                                    Get player's games
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/getUnpaid">
                                    Get players, who didn't pay fees this year
                                </a>
                            </li>
                            <li>
                                <a href="${contextPath}/getFiveOldest">
                                    Get five oldest players
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