<?php
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $x = floatval($_POST["x"]);
    $y = floatval($_POST["y"]);
    $r = floatval($_POST["r"]);

    if (!isset($_SESSION["results"])) {
        $_SESSION["results"] = [];
    }

    function checkPoint($x, $y, $r)
    {
        if ($x >= 0 && $y >= 0) {
            return $x == 0 && $y == 0;
        } else if ($x >= 0 && $y < 0) {
            return $x <= $r && $y <= $r / 2;
        } else if ($x < 0 && $y >= 0) {
            return $x >= -$r && $y <= -2 * $x;
        } else {
            return $x * $x + $y * $y <= $r * $r / 4;
        }
    }
    $start = microtime(true);

    $currentTime = date("Y-m-d H:i:s");

    $result = checkPoint($x, $y, $r);

    $executionTime = number_format(microtime(true) - $start, 5) * 100000;

    $pointStatus = $result ? "Попадает" : "Не попадает";

    $_SESSION["results"][] = [
        "x" => $x,
        "y" => $y,
        "r" => $r,
        "result" => $pointStatus,
        "time" => $currentTime,
        "execution_time" => $executionTime
    ];

}
?>


<!DOCTYPE html>
<html lang="ru">
<head>
    <link rel="stylesheet" href="test.css">
    <title>
        results
    </title>
</head>
<body>
<table>
    <tr>
        <th>x</th>
        <th>y</th>
        <th>r</th>
        <th>результат</th>
        <th>время получения результата</th>
        <th>время работы скрипта</th>
    </tr>


    <?php
        foreach ($_SESSION["results"] as $result) {
            echo "<tr>";
            echo "<td>" . $result["x"] . "</td>";
            echo "<td>" . $result["y"] . "</td>";
            echo "<td>" . $result["r"] . "</td>";
            echo "<td>" . $result["result"] . "</td>";
            echo "<td>" . $result["time"] . "</td>";
            echo "<td>" . $result["execution_time"] . "</td>";
            echo "</tr>";
        }
    ?>

</table>
</html>
</body>



