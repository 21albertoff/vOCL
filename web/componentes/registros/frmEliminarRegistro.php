<?php 
    if(isset($_POST['eliminarRegistro'])){ 
        $idRegistro = $_POST['idRegistro']; 
        eliminarRegistro($idRegistro); ?>

        <div class="alert alert-danger alert-dismissible fade show" style="margin: auto;"role="alert">
            <p style="color: #ffffff; margin: auto;"><i class="fas fa-trash-alt"></i> El registro se ha eliminado con exito</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div> 

<?php } ?>