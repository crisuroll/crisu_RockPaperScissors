<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "INSERT INTO partidas (u1) VALUES (" . $_GET['u1'] . ")");
		mysqli_close($bd);
    }
?>