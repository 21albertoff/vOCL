<!DOCTYPE html>
<html>

<head>
  <?php
    include "funciones/config.php";
    include "funciones/main.php";
    include "componentes/comun/rutas.php";
    include "componentes/comun/header.php";
    $imagenUsuarioP = $imagenUsuario;
    $nombreUsuarioP = $nombreUsuario;
    $centroUsuarioP = $centroUsuario;
    $PaisUsuarioP = $PaisUsuario;
    $ciudadUsuarioP = $ciudadUsuario;
    $informacionUsuarioP = $informacionUsuario;
    $Nombre1UsuarioP = $Nombre1Usuario;
    $ApellidosUsuarioP = $ApellidosUsuario;
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
    <div class="header pb-6 d-flex align-items-center" style="min-height: 500px; background-image: url(assets/img/theme/profile-cover.jpg); background-size: cover; background-position: center top;">
      
      <span class="mask bg-gradient-default opacity-8"></span>
      
      <!-- Contenido cabecera -->
      <div class="container-fluid d-flex align-items-center">
        <div class="row">
          <div class="col-lg-7 col-md-10">
            <h1 class="display-3 text-white">Hola <?=$nombreUsuario?></h1>
            <p class="text-white mt-0 mb-5">Esta es tu página de perfil. Puedes ver las sentencias que has analizado con vOCL y gestionar tus datos.</p>
            <?php
              if(isset($_POST['actualizarPerfil'])){
                $img = $_FILES['imagenPerfil']["name"];
                if ($img != "") {
                  $tipoArchivo = $_FILES['imagenPerfil']['type'] ;
                  $nombreArchivo = $_FILES['imagenPerfil']['name'];
                  $tamanoArchivo = $_FILES['imagenPerfil']['size'];
                  $imagenSubida = fopen($_FILES['imagenPerfil']['tmp_name'], 'r');
                  $binariosImagen = fread($imagenSubida, $tamanoArchivo);
                  $binariosImagen2 = mysqli_escape_string($db, $binariosImagen);

                }
                $imagenUsuarioP = $binariosImagen2 ?? $binariosImagen2 = mysqli_escape_string($db, $imagenUsuario);
                $nombreUsuarioP = $_POST['nombreUsuario'] ?? $nombreUsuario;
                $Nombre1UsuarioP = $_POST['nombre'] ?? "";
                $ApellidosUsuarioP = $_POST['apellidos'] ?? "";
                $centroUsuarioP = $_POST['centro'] ?? "";
                $PaisUsuarioP = $_POST['pais'] ?? "";
                $ciudadUsuarioP = $_POST['ciudad'] ?? "";
                $informacionUsuarioP = $_POST['biografia'] ?? "";

                actualizarPerfil($nombreUsuarioP, $correoUsuario, $Nombre1UsuarioP, $ApellidosUsuarioP, $imagenUsuarioP, $ciudadUsuarioP, $PaisUsuarioP, $centroUsuarioP, $informacionUsuarioP);
                $imagenUsuarioP = $binariosImagen ?? $imagenUsuario;

                ?>
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <strong>¡Perfil actualizado!</strong> Los datos de tu perfil se han cambiado correctamente.
                </div>
              <?php }
            ?>
            <a href="registros.php" class="btn btn-neutral">Ver registros</a>
          </div>
        </div>
      </div>
    </div>

    <div class="container-fluid mt--6">
      <div class="row">
        
        <!-- Perfil vista previa -->
        <div class="col-xl-4 order-xl-2">
          <div class="card card-profile">
            <img src="assets/img/theme/img-1-1000x600.jpg" alt="Image placeholder" class="card-img-top">
            <div class="row justify-content-center">
              <div class="col-lg-3 order-lg-2">
                <div class="card-profile-image">
                    <img src="<?="data:image/png;base64,".base64_encode($imagenUsuarioP)?>" style="width: 140px; height: 140px;" class="rounded-circle">
                </div>
              </div>
            </div>
            <div class="card-header text-center border-0 pt-8 pt-md-4 pb-0 pb-md-4">
            </div>
            <div class="card-body pt-0">
              <div class="row">
                <div class="col">
                  <div class="card-profile-stats d-flex justify-content-center">
                    <div>
                      <span class="heading"><?=$sentenciasAnalizadas?></span>
                      <span class="description">Sentencias OCL Analizadas</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="text-center">
                <h5 class="h3">
                <?=$nombreUsuarioP?><span class="font-weight-light"></span>
                </h5>
                <div>
                  <i class="ni education_hat mr-2"></i><?=$centroUsuarioP?>
                </div>
                <div class="h5 font-weight-300">
                  <i class="ni location_pin mr-2"></i><?=$ciudadUsuarioP?>, <?=$PaisUsuarioP?>
                </div>
                <div class="h5 mt-4">
                  <i class="ni business_briefcase-24 mr-2"></i><?=$informacionUsuarioP?>
                </div>
              </div>
            </div>
          </div>
          <form enctype="multipart/form-data" method="post" action="">
          <button type="submit" name='actualizarPerfil' class="btn btn-success col-lg">
            <i class="fas fa-save"></i> Aplicar Cambios
          </button>
        </div>

        <!-- Formulario perfil -->
        <div class="col-xl-8 order-xl-1">
          <div class="card">
            <div class="card-header">
              <div class="row align-items-center">
                <div class="col-8">
                  <h3 class="mb-0">Editar perfil </h3>
                </div>
              </div>
            </div>
            <div class="card-body">
              <form>
                <h6 class="heading-small text-muted mb-4">Informacion del usuario</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-username">Nombre de usuario</label>
                        <input type="text" name="nombreUsuario" class="form-control" placeholder="Nombre de usuario" value="<?=$nombreUsuarioP?>">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-email">Correo Electronico</label>
                        <input type="email" name="correoUsuario" class="form-control" placeholder="ejemplo@correo.com" value="<?=$correoUsuario?>" disabled>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-first-name">Nombre</label>
                        <input type="text" name="nombre" class="form-control" placeholder="Nombre" value="<?=$Nombre1UsuarioP?>">
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label class="form-control-label" for="input-last-name">Apellidos</label>
                        <input type="text" name="apellidos" class="form-control" placeholder="Apellidos" value="<?=$ApellidosUsuarioP?>">
                      </div>
                    </div>
                    <div class="col-lg-12">
                      <div class="form-group">    
                        <label class="form-control-label" for="input-last-name">Imagen de perfil</label>
                        <input type="file" name="imagenPerfil" id="imagenPerfil" class="form-control-file">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4" />
                <h6 class="heading-small text-muted mb-4">Informacion de contacto</h6>
                <div class="pl-lg-4">
                  <div class="row">
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-city">Ciudad</label>
                        <input type="text" name="ciudad" class="form-control" placeholder="Ciudad" value="<?=$ciudadUsuarioP?>">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Pais</label>
                        <input type="text" name="pais" class="form-control" placeholder="Pais" value="<?=$PaisUsuarioP?>">
                      </div>
                    </div>
                    <div class="col-lg-4">
                      <div class="form-group">
                        <label class="form-control-label" for="input-country">Centro de estudio</label>
                        <input type="text" name="centro" class="form-control" placeholder="Centro de estudio" value="<?=$centroUsuarioP?>">
                      </div>
                    </div>
                  </div>
                </div>
                <hr class="my-4" />
                <h6 class="heading-small text-muted mb-4">Mas datos</h6>
                <div class="pl-lg-4">
                  <div class="form-group">
                    <label class="form-control-label">Sobre mi</label>
                    <textarea rows="4" name="biografia" class="form-control" placeholder="Habla un poco sobre ti"><?=$informacionUsuarioP?></textarea>
                  </div>
                </div>
              </form>
            </div>
          </div>
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