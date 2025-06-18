<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<%!
    public String buttons() {
        Double[] values = new Double[]{-2.0, -1.5, -1.0, -0.5, 0.0, 0.5, 1.0, 1.5, 2.0};
        return Stream.of(values)
                .map(x -> "<input type=\"button\" name=\"xSetter\" value=\"" + x + "\">")
                .collect(Collectors.joining()) + "<br>";
    }

    public String radios() {
        Integer[] values = new Integer[]{1, 2, 3, 4, 5};
        return Stream.of(values)
                .map(x -> "<label>\n" +
                        "<input type=\"radio\" name=\"r\" value=\"" + x + "\">" + x + "\n" +
                        "</label><br>")
                .collect(Collectors.joining()) + "<br>";
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>lab 1</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="form.css">
</head>
<body>
<div id="upper">
    <header>
        Sergeyev Valeriy Dmitrievisch, P3210, 123
    </header>
    <form id="myForm">
        <label>X:</label><br>
        <%= buttons() %>
        <input type="text" id="x" name="x" readonly value=""><br>

        <label>Y:</label><br>
        <input type="text" id="y" name="y"><br>

        <label>R:</label><br>
        <%= radios()%>

        <input type="submit" value="Submit">
    </form>
</div>
<div id="screen">
    <div id="drawing">
        <div id="dot"></div>
        <div id="outer1">
        </div>
        <div id="outer2">
            <div id="l">
                <div id="rect"></div>
                <div id="tr"></div>
            </div>
            <div id="r">
                <div id="empty"></div>
                <div id="circle"></div>
            </div>
        </div>
    </div>
</div>
<%--drawer--%>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        let xField = document.getElementById("x");
        let yField = document.getElementById("y");
        let r = document.getElementsByName("r");
        let rightArea;

        let drawing = document.getElementById("drawing");
        let outer1 = document.getElementById("outer1");
        let outer2 = document.getElementById("outer2");
        let tr = document.getElementById("tr");

        document.getElementsByName("xSetter").forEach(setX);
        document.getElementById("screen").addEventListener("click", uiWrong);
        document.getElementById("drawing").addEventListener("click", uiRight);
        r.forEach(function (radio) {
            radio.addEventListener("input", function () {
                valueDrawing(radio)
            });
        });

        function setX(radio) {
            radio.addEventListener("click", function () {
                xField.value = radio.value;
            })
        }

        function uiWrong(event) {
            if (!rightArea) {
                window.alert("wrong area");
            }
            rightArea = false;
        }

        function uiRight(event) {
            rightArea = true;
            let par = drawing.getBoundingClientRect();
            xField.value = (event.clientX - par.left) / 100;
            yField.value = (event.clientY - par.top) / 100;
            dot(event.clientY - par.top, event.clientX - par.left);
        }

        function valueDrawing(radio) {
            let mult = radio.value * 100;
            drawing.style.width = mult + "px";
            drawing.style.height = mult + "px";
            outer1.style.width = mult + "px";
            outer1.style.height = mult + "px";
            outer2.style.width = mult + "px";
            outer2.style.height = mult + "px";
            tr.style.borderTopWidth = mult / 2 + "px";
            tr.style.borderLeftWidth = mult / 2 + "px";
        }

        function dot(x, y) {
            let dot = document.getElementById("dot")
            dot.style.top = x + "px";
            dot.style.left = y + "px";

        }
    })

</script>
<%--ajax--%>
<script>
    document.addEventListener("DOMContentLoaded", () => {
        document.getElementById("myForm").addEventListener("submit", function (e) {
            e.preventDefault();
            if (validation()) {
                newSubmit();
            }
        });
    });

    function validation() {
        const x = document.getElementById("x").value;
        const y = document.getElementById("y").value
        const rRadios = document.getElementsByName("r");

        if (x === "") {
            window.alert("wrong x");
            return false;
        }

        if (isNaN(parseFloat(y)) || y <= -3 || y >= 3) {
            window.alert("wrong y")
            return false;
        }

        let rProvided = false;
        rRadios.forEach(function (radio) {
            if (radio.checked) {
                rProvided = true;
            }
        });
        if (!rProvided) {
            window.alert("wrong r")
            return false;
        }
        return true;
    }

    function newSubmit() {
        let body = document.getElementsByTagName("body")[0];
        body.removeChild(document.getElementById("screen"));
        body.removeChild(document.getElementById("upper"));
        let output = document.createElement("div");
        output.id = "output";
        body.appendChild(output);

        const xhr = new XMLHttpRequest();
        xhr.open('POST', 'http://localhost:8080/weblab2real/check', true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                output.innerText = "xhr.response";
            } else {
                alert("not received")
            }
        };
        const formData = new FormData();
        formData.append("x", "0");
        formData.append("y", "0");
        formData.append("r", "3");
        xhr.send(formData);
    }
</script>
</body>
</html>







