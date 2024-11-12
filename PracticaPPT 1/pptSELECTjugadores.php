<?php
    $bd = mysqli_connect("localhost", "cg9AdminS3", "351073_sbk", "juegoppt");

    if (!$bd) {
        echo("Access denied.");
    } else {
        $query = mysqli_query($bd, "SELECT nick FROM jugadores WHERE nick = '" . $_GET['nick'] . "'");
	  while($res = mysqli_fetch_assoc($query)) {
		 echo($res['nick']);
	  }
		mysqli_close($bd);
    }
?>