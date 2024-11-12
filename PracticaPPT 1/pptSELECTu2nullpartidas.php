<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "SELECT u1 FROM partidas WHERE u2 IS NULL");
        while($res = mysqli_fetch_assoc($query)) {
            echo($res['u1']);
         }
		mysqli_close($bd);
    }
?>