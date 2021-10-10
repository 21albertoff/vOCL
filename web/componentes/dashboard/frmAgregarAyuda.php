<?php 
    if(isset($_POST['agregarAyuda'])){ 
        $tituloAyuda = $_POST['tituloAyuda']; 
        $urlAyuda = $_POST['urlAyuda']; 
        $descripcionAyuda = $_POST['descripcionAyuda']; 
        insertarAyuda($tituloAyuda, $descripcionAyuda, $urlAyuda); ?>

        <div class="alert alert-success alert-dismissible fade show" style="margin: auto;"role="alert">
            <p style="color: #ffffff; margin: auto;"><i class="fas fa-life-ring"></i> La ayuda se ha añadido con exito</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div> 

<?php } ?>
