<?php
session_start();
unset($_SESSION["imagenUsuario"]);
unset($_SESSION["nickUsuario"]);
unset($_SESSION["tipoUsuario"]);
unset($_SESSION["sentenciasUsuario"]);
unset($_SESSION["correoUsuario"]);
unset($_SESSION["nombreUsuario"]);
unset($_SESSION["apellidosUsuario"]);
unset($_SESSION["ciudadUsuario"]);
unset($_SESSION["paisUsuario"]);
unset($_SESSION["centroUsuario"]);
unset($_SESSION["biografiaUsuario"]);
header('Location: inicio.php');
exit();
?>