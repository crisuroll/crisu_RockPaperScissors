<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "UPDATE partidas SET j_u1 = " . $_GET['j_u1'] . " WHERE j_u1 IS NULL");
		mysqli_close($bd);
    }
?>