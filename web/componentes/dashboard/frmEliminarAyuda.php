<?php 
    if(isset($_POST['eliminarAyuda'])){ 
        $idAyuda = $_POST['idAyudas']; 
        eliminarAyuda($idAyuda); ?>

        <div class="alert alert-danger alert-dismissible fade show" style="margin: auto;"role="alert">
            <p style="color: #ffffff; margin: auto;"><i class="fas fa-trash-alt"></i> La ayuda se ha eliminado con exito</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div> 

<?php } ?>
