<!DOCTYPE html>
<html>

<head>
  <?php 
    include "funciones/config.php";
    include "funciones/main.php";
    include "componentes/comun/rutas.php";
    include "componentes/comun/header.php";
  ?>
</head>

<body class="bg-default">

  <!-- Menu -->
  <nav id="navbar-main" class="navbar navbar-horizontal navbar-transparent navbar-main navbar-expand-lg navbar-light">
    <div class="container">
      <a class="navbar-brand" href="index.php">
        <img src="assets/img/brand/white.png">
      </a>
      <div class="navbar-collapse navbar-custom-collapse collapse" id="navbar-collapse">
        <hr class="d-lg-none" />
        <ul class="navbar-nav align-items-lg-center ml-lg-auto">
          <li class="nav-item d-none d-lg-block ml-lg-4">
            <a href="registro.php" class="btn btn-neutral btn-icon">
              <span class="nav-link-inner--text">¡Registrarse ahora!</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Contenido principal -->
  <div class="main-content">

    <!-- Cabecera -->
    <div class="header bg-gradient-primary py-7 py-lg-8 pt-lg-9">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-xl-5 col-lg-6 col-md-8 px-5">
              <h1 class="text-white">¡Bienvenid@!</h1>
              <p class="text-lead text-white"><?=$mensajeInicio?></p>
            </div>
          </div>
        </div>
      </div>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none" version="1.1" xmlns="http://www.w3.org/2000/svg">
          <polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
      </div>
    </div>

    <!-- Formulario Inicio Sesion -->
    <?php include "componentes/inicio/frmInicio.php"; ?>

  </div>
  
  <!-- Footer -->
  <footer class="py-5" id="footer-main">
    <div class="container">
      <div class="row align-items-center justify-content-xl-between">
        <div class="col-xl-6">
          <div class="copyright text-center text-xl-left text-muted">
            Hecho con <i class="fa fa-heart" style="color: #e94545;"></i> por <?=$propietarioWeb?>
          </div>
        </div>
        <div class="col-xl-6">
          <ul class="nav nav-footer justify-content-center justify-content-xl-end">
            <li class="nav-item">
            </li>
            <li class="nav-item">
            </li>
            <li class="nav-item">
              <a class="nav-link"><?=$pieDePagina?></a>
            </li>
            <li class="nav-item">
              <a href="https://github.com/creativetimofficial/argon-dashboard/blob/master/LICENSE.md" class="nav-link" target="_blank">MIT License</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
  <!-- JS Comun -->
  <?php include "componentes/comun/jquery.php"; ?>

</body>

</html>