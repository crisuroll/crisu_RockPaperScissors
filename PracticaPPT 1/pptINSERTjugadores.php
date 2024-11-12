<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "INSERT INTO jugadores (nick) VALUES ('" . $_GET['nick'] . "')");
		mysqli_close($bd);
    }
?>1