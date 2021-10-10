<?php
header('Content-Type: application/json');

//Configuracion base de datos
define('DB_HOST', 'localhost');
define('DB_USERNAME', 'root');
define('DB_PASSWORD', '');
define('DB_NAME', 'vocl');

$mysqli = new mysqli(DB_HOST, DB_USERNAME, DB_PASSWORD, DB_NAME);

if(!$mysqli){
  die("Fallo de conexion: " . $mysqli->error);
}

//Consulta
$query = ("SELECT `lunes`, `martes`, `miercoles`, `jueves`, `viernes`, `sabado`, `domingo` FROM `grafica`");
$result = $mysqli->query($query);
$data = array();
foreach ($result as $row) {
  $data[] = $row;
}

//Pintar json
print json_encode($data);

//Liberar espacio y cerrar conexion
$result->close();
$mysqli->close();
?>