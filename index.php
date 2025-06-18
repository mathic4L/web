<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>lab 1</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="test.css">
    <script src="test.js"></script>
</head>
<body>
<header class="header">
    Сергеев Валерий Дмитриевич, P3210, 437069
</header>
<form id="form" method="post" action="server.php" onsubmit="return validateXY()">
    <div>
        <label for="x">X:</label><br>
        <select id="x" name="x">
            <option>-2</option>
            <option>-1.5</option>
            <option>-1</option>
            <option>-0.5</option>
            <option>-0</option>
            <option>0.5</option>
            <option>1</option>
            <option>1.5</option>
            <option>2</option>
        </select><br>
    </div>

    <div>
        <label for="y">Y:</label><br>
        <input type="text" id="y" name="y" placeholder="type y"><br>
    </div>

    <div>
        <label for="r">R:</label><br>
        <label>
            <input type="radio" name="r" value="1">
        </label>1<br>
        <label>
            <input type="radio" name="r" value="2">
        </label>2<br>
        <label>
            <input type="radio" name="r" value="3">
        </label>3<br>
        <label>
            <input type="radio" name="r" value="4">
        </label>4<br>
        <label>
            <input type="radio" name="r" value="5">
        </label>5<br>
    </div>

    <input type="submit" value="Submit">
</form>

</body>
</html>
