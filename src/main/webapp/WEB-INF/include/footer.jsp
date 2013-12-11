<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

<%--<script src="../assets/js/bootstrap-transition.js"></script>
<script src="../assets/js/bootstrap-alert.js"></script>
<script src="../assets/js/bootstrap-modal.js"></script>
<script src="../assets/js/bootstrap-dropdown.js"></script>
<script src="../assets/js/bootstrap-scrollspy.js"></script>
<script src="../assets/js/bootstrap-tab.js"></script>
<script src="../assets/js/bootstrap-tooltip.js"></script>
<script src="../assets/js/bootstrap-popover.js"></script>
<script src="../assets/js/bootstrap-button.js"></script>
<script src="../assets/js/bootstrap-collapse.js"></script>
<script src="../assets/js/bootstrap-carousel.js"></script>
<script src="../assets/js/bootstrap-typeahead.js"></script>--%>
<!--<script type="text/javascript">
    /*var req;

    function createRequest() {
        if (window.XMLHttpRequest) {
            req = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            try {
                req = new ActiveXObject('Msxml2.XMLHTTP');
            } catch (e){}
            try {
                req = new ActiveXObject('Microsoft.XMLHTTP');
            } catch (e){}
        }
        return req;
    }*/

    function getData(handlerPath/*, parameters*/) {
        alert("123");
        var form = document.createElement("form");
        form.id = "myForm";
        form.method = "GET";
        form.action = handlerPath;
        var input = document.createElement("input");
        input.name = "path";
        input.type = "hidden";
        input.value = window.location.pathname;
        form.appendChild(input);
        document.body.appendChild(form);
        console.log(form);
        document.getElementById("myForm").submit();

        /*var xmlhttp = createRequest();
        xmlhttp.open("GET", "${contextPath}/", false);
        xmlhttp.send();
        var content = document.querySelector("div.span10");
        document.documentElement.innerHTML = xmlhttp.responseText;
        document.getElementById("main").innerHTML = content.outerHTML;*/

        /*req = createRequest();
        if (req) {
            // Отправляем запрос методом POST с обязательным указанием файла обработчика (true - асинхронный режим включен)
            req.open("GET", handlerPath, false);
            // При использовании объекта XMLHttpRequest с методом POST требуется дополнительно отправлять header
            //req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            // Передаем необходимые параметры (несколько параметров разделяются амперсандами)
            //req.send(parameters);

            // Для статуса "OK"
            if (req.status == 200) {
                // Получаем ответ функции в виде строки
                var rData = req.responseText;
                var content = document.documentElement.outerHTML;
                document.write(rData);
                document.close();
                document.getElementById("main").append(content);
            } else {
                console.log("Не удалось получить данные:\n" + req.statusText);
            }
        } else {
            console.log("Браузер не поддерживает AJAX");
        }*/
    }

    window.onload = getData("${contextPath}/");
</script>-->