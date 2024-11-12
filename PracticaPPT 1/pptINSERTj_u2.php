<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "UPDATE partidas SET j_u2 = " . $_GET['j_u2'] . " WHERE j_u2 IS NULL");
		mysqli_close($bd);
    }
?>