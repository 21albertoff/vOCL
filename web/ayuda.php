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
  <!-- Contenido Principal -->
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
              <h1 class="h1 text-white d-inline-block"><i class="far fa-life-ring"></i> Gestión de ayuda</h1>
            </div>
            <div class="col">
              <!-- Agregar ayuda -->
              <?php include "componentes/dashboard/frmAgregarAyuda.php"; ?>

              <!-- Eliminar ayuda -->
              <?php include "componentes/dashboard/frmEliminarAyuda.php"; ?>

            </div> 
          </div>             
        </div>
      </div>
    </div>

    <form method="post" action="">
    <!-- Formulario de ayuda -->
    <div class="container-fluid mt--6">
      <div class="row" style="margin:20px;">
        <div class="col-xl-12">
          <div class="card card-body">
              <h6 class="heading-small text-muted mb-4">Informacion de la ayuda</h6>
              <div class="pl-lg-4">
                <div class="row">
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label" for="input-email">Titulo</label>
                      <input type="text" name="tituloAyuda" class="form-control" placeholder="Escribe el titulo para la ayuda" required>
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label" for="input-email">URL imagen</label>
                      <input type="url" name="urlAyuda" id="input-email" class="form-control" placeholder="Añade alguna url de alguna imagen">
                    </div>
                  </div>
                  <div class="col-lg-12">
                    <div class="form-group">
                      <label class="form-control-label">Descripcion de la ayuda</label>
                      <textarea rows="3" name="descripcionAyuda" class="form-control" placeholder="Escribe una breve descripción sobre la ayuda"></textarea required>
                    </div>
                  </div>
                  <div class="col-lg-12">
                    <div class="form-group text-right">
                      <button type="submit" name="agregarAyuda" class="btn btn-lg btn-success"><i class="fas fa-save"></i> Añadir ayuda</button>
                    </div>
                  </div>
              </div>
          </div>
        </div>
        </form>

        <!--Registros de ayudas -->
        <div class="card">
          <div class="table-responsive">
            <table class="table align-items-center table-flush">
              <thead class="thead-light">
                <tr>
                  <th scope="col" class="sort"  data-sort="budget">Ayuda</th>
                  <th scope="col" data-sort="status">Descripcion</th>
                  <th scope="col" class="sort" data-sort="completion"></th>
                </tr>
              </thead>
              <tbody class="list">

                <!-- Agregar ayuda -->
                <?php include "componentes/dashboard/frmConsultarAyudas.php"; ?>
                
              </tbody>
            </table>
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