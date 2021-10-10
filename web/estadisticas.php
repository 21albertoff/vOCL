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

<body>
  <!-- Contenido principal -->
  <div class="main-content" id="panel">
    
    <!-- Menu -->
    <?php
    if ($tipoUsuario == 0) {
      include "componentes/comun/menu0.php";
    }
    
    if ($tipoUsuario == 1) {
      include "componentes/comun/menu.php";
    }

    if ($tipoUsuario == 2) {
      include "componentes/comun/menu2.php";
    }
    ?>
   
    <!-- Cabecera -->
    <div class="header bg-primary pb-6">
      <div class="container-fluid">
        <div class="header-body">
          <div class="row align-items-center py-4">
            <div class="col">
              <h1 class="h1 text-white d-inline-block"> <i class="far fa-chart-bar"></i> Estadisticas</h1>
            </div> 
          </div>

          <!-- Estadisticas -->
          <?php include "componentes/dashboard/frmEstadisticas.php"; ?>

        </div>
      </div>
    </div>

    <!-- Grafica -->
    <div class="container-fluid mt--6">
      <div class="row">
        <div class="col-xl-12">
          <div class="card">
            <div class="card-header">
              <div class="row align-items-center">
                <div class="col">
                  <h5 class="text-dark text-uppercase ls-1 mb-1">Actividad semanal</h5>
                </div>
              </div>
            </div>
            <div class="card-body">
              <div class="chart">
                <canvas id="graficaestadistica" class="chart-canvas"></canvas>
              </div>
            </div>
          </div>
        </div>
      </div>

      <!-- Footer -->
      <?php include "componentes/comun/footer.php"; ?>
    </div>
  </div>
  
  <!-- JS Comun -->
  <?php include "componentes/comun/jquery.php"; ?>
  <script type="text/javascript" src="assets/js/graficaEstadistica.js"></script>
  
</body>

</html>