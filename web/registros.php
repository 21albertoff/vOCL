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

  <!-- Main content -->
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
            <div class="col-8 text-left">
              <!-- Eliminar registro -->
              <?php include "componentes/registros/frmEliminarRegistro.php"; ?>
            </div>
            <div class="col-4 text-right">
              <a href="index.php" class="btn btn-lg btn-neutral">Analizar nueva sentencia OCL</a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Page content -->
    <div class="container-fluid mt--6">
      <div class="row">
        <div class="col">
          <div class="card">
            <!-- Light table -->
            <div class="table-responsive">
              <table class="table align-items-center table-flush">
                <thead class="thead-light">
                  <tr>
                    <th scope="col" data-sort="budget">Sentencia</th>
                    <th scope="col" class="sort" data-sort="status">Estado</th>
                    <th scope="col" class="sort" data-sort="completion">Fecha</th>
                    <th scope="col" class="sort" data-sort="completion"></th>
                  </tr>
                </thead>
                <tbody class="list">
                  
                  <!-- Consultar Registros -->
                  <?php include "componentes/registros/frmConsultarRegistros.php"; ?>
                  
                </tbody>
              </table>
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
</body>

</html>