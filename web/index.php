<!DOCTYPE html>
<html>

<head>
  <?php 
    include "funciones/config.php";
    include "funciones/main.php";
    include "componentes/comun/rutas.php";
    include "componentes/comun/header.php";
  ?>
  <!-- Libreria de codemirror -->
  <link rel="stylesheet" type="text/css" href="assets/vendor/codemirror/lib/codemirror.css">
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
    
    <form method="post" action="">
    <!-- Cabecera -->
    <div class="header bg-white pb-6">
      <div class="container-fluid">
        <div class="header-body">
          <div class="row align-items-center py-4">
            
            <div class="col-8 col-xl-8 text-left">
              <input id="fichero" type="file">
              <?php if ($tipoUsuario != 0) { ?>
                <label for="fichero" class="btn btn-lg btn-secondary"><i class="fas fa-upload"></i> Cargar archivo UML</label>
              <?php } ?>
                <button id="botonLimpiar" class="btn btn-lg btn-outline-danger" onclick="limpiarTexto();"><i class="fas fa-eraser"></i> Limpiar texto</button>               
            </div>
            <div class="col-4 col-xl-4 text-right">
              <?php if ($tipoUsuario != 0) { ?>
                <input type="hidden" name="estadoSentencia" value="<?=$estadoRegistro?>"></input>
                <button type="submit" name='guardarSentencia' class="btn btn-lg btn-success"><i class="fas fa-save"></i> Guardar</button>
              <?php } ?>
            </div>

          </div>
        </div>
      </div>
    </div>
    
    <div class="container-fluid mt--6">
      <div class="row">
        
        <!-- Verificador -->
        <div class="col-xl-8">
          <div class="card " style= "margin-left: 1.1rem;">

            <textarea class="codemirror-textarea" id="cmta" name="sentencia" ></textarea>
           
          </div>
          <div class="row">
            <div class="col-9 text-left">
              <!--Verificar sentencias OCL-->
              <?php include "componentes/index/frmVerificarOCL.php"; ?>
            </div>
            <div class="col-3 text-right">
                <button type="submit" name='analizar' id="analizarBoton" class="btn btn-lg btn-primary"><i class="fas fa-check-double"></i> Verificar sentencia OCL</button>
            </div>
              </div>
          </form>
          <br>

           

        </div>
        
        <!-- Panel de ayuda -->
        <?php include "componentes/index/frmCargarAyuda.php"; ?>

      </div>

      <!-- Footer -->
      <?php include "componentes/comun/footer.php"; ?>
    </div>
  </div>
  
  <!-- JS Comun -->
  <?php include "componentes/comun/jquery.php"; ?>

  <!-- CodeMirror Scripts -->
  <script type="text/javascript" src="assets/vendor/codemirror/lib/codemirror.js"></script>
  <script type="text/javascript" src="assets/js/default.js"></script>
  <script type="text/javascript" src="assets/js/obtenerTexto.js"></script>
  <script type="text/javascript" src="assets/vendor/codemirror/mode/go/go.js"></script>
  
  <!--Guardar sentencias OCL--> 
  <?php include "componentes/index/frmGuardarOCL.php"; ?>

  <!--Cargar sentencias OCL-->
  <?php include "componentes/index/frmCargarRegistro.php"; ?>
  
  <script>

    //Funcion para limpiar Texto
    function limpiarTexto() {
      $(document).ready(function(){
        var codemirror = $('.codemirror-textarea').nextAll('.CodeMirror')[0].CodeMirror;
        codemirror.getDoc().setValue("");
      });
    }
    
  </script>
</body>

</html>