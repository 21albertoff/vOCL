<?php
@session_start();



# Ajustes web
$tituloWeb      = "vOCL - Tu verificador de OCL";
$propietarioWeb = "Alberto Fuentes";
$consultarAjustes = consultarAjustes();
while($row = mysqli_fetch_array($consultarAjustes)){
    $colorPrincipal = $row['colorPrincipal'];
    $logoWeb = $row['logoWeb'];
    $DescripcionWeb = $row['descripcionWeb'];
    $mensajeInicio = $row['descricionBienvenida'];
    $pieDePagina = $row['descripcionPie'];
    $depuracion = $row['depuracion'];
}



# Datos usuario
$imagenUsuario          = $_SESSION["imagenUsuario"] ?? "https://th.bing.com/th/id/OIP.uqs5SxPZC4LpEP59r_6R1gHaHa?pid=ImgDet&rs=1";
$nombreUsuario          = $_SESSION["nickUsuario"] ?? "";
$tipoUsuario            = $_SESSION["tipoUsuario"] ?? 0;
$sentenciasAnalizadas   = $_SESSION["sentenciasUsuario"] ?? 0;
$correoUsuario          = $_SESSION["correoUsuario"] ?? "";
$Nombre1Usuario         = $_SESSION["nombreUsuario"] ?? "";
$ApellidosUsuario       = $_SESSION["apellidosUsuario"] ?? "";
$ciudadUsuario          = $_SESSION["ciudadUsuario"] ?? "";
$PaisUsuario            = $_SESSION["paisUsuario"] ?? "";
$centroUsuario          = $_SESSION["centroUsuario"] ?? "";
$informacionUsuario     = $_SESSION["biografiaUsuario"] ?? "";

# Index
$estadoRegistro     = 0;

#Inicio
$tituloAyuda        = "Aprende a trabajar con vOCL";
$descripcionAyuda   = "OCL 2.0 (Object Constraint Language 2.0) es un lenguaje para la descripción formal de expresiones en los modelos UML. Fue adoptado en octubre de 2003 por el grupo OMG como parte de UML 2.0. Sus expresiones pueden representar invariantes, precondiciones, postcondiciones, inicializaciones, guardias, reglas de derivación, así como consultas a objetos para determinar sus condiciones de estado.";
$urlImagenAyuda     = "https://image.slideserve.com/1296430/using-ocl-in-class-diagrams-l.jpg";
?>