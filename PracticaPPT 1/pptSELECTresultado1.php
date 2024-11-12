<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "SELECT j_u1 FROM partidas");
	  while($res = mysqli_fetch_assoc($query)) {
		 echo($res['j_u1']);
	  }
		mysqli_close($bd);
    }
?>