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
              <h1 class="h1 text-white d-inline-block"><i class="fas fa-cog"></i> Ajustes</h1>
            </div> 
            <div class="col">
              <!-- Modificar ajutes -->
              <?php include "componentes/dashboard/frmModificarAjustes.php"; ?>            
            </div>
          </div>             
        </div>
      </div>
    </div>

    <form method="post" action="">
    <!-- Formulario de ajustes -->
    <div class="container-fluid mt--6">
      <div class="row" style="margin:20px;">
        <div class="col-xl-12">
          <div class="card card-body">
            <form>
              <h6 class="heading-small text-muted mb-4">Ajustes de la web</h6>
              <div class="pl-lg-4">
                <div class="row">
                  <div class="col-lg-2">
                    <div class="form-group">
                      <label class="form-control-label" for="input-email">Color principal</label>
                      <input type="color" class="form-control form-control-color" name="colorPrincipal" value="<?=$colorPrincipal?>" title="Elige el color principal">
                    </div>
                  </div>
                  <div class="col-lg-10">
                    <div class="form-group">
                      <label class="form-control-label" for="input-email">Logo de la web</label>
                      <input type="text" class="form-control" name="logoWeb" placeholder="Añade alguna url de alguna imagen" value="<?=$logoWeb?>">
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label">Descripcion de la web</label>
                      <textarea rows="3" class="form-control" name="descripcionWeb" placeholder="Escribe una descripción para la web"><?=$DescripcionWeb?></textarea required>
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label">Descripcion de bienvenida</label>
                      <textarea rows="3" class="form-control" name="descripcionBienvenida" placeholder="Escribe una breve descripción sobre la bienvenida"><?=$mensajeInicio?></textarea required>
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label">Pie de pagina</label>
                      <input type="text" id="input-email" name="piePagina" class="form-control" value="<?=$pieDePagina?>"placeholder="Escribir un pie de pagina">
                    </div>
                  </div>
                  <div class="col-lg-6">
                    <div class="form-group">
                      <label class="form-control-label">Modo depuración</label>
                      <select name="modoDepuracion" class="form-control" id="exampleFormControlSelect1">
                        <?php if ($depuracion == "0"){ ?>
                          <option value="0" selected >Desactivado</option>
                          <option value="1">Activado</option>
                        <?php } else {?>
                          <option value="0">Desactivado</option>
                          <option value="1" selected >Activado</option>
                        <?php }?>
                      </select>
                    </div>
                  </div>
                  <div class="col-lg-12">
                    <div class="form-group text-right">
                      <button type="submit" name='modificarAjustes' class="btn btn-lg btn-success"><i class="fas fa-save"></i> Aplicar cambios</button>
                    </div>
                  </div>
              </div>
            </form>
          </div>
        </div>
    </form>
      <!-- Footer -->
      <?php include "componentes/comun/footer.php"; ?>
    </div>
  </div>
  
  <!-- JS Comun -->
  <?php include "componentes/comun/jquery.php"; ?>
</body>

</html>