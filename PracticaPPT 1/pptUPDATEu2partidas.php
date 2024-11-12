<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "UPDATE partidas SET u2 = " . $_GET['u2'] . " WHERE u2 IS NULL");
		mysqli_close($bd);
    }
?>