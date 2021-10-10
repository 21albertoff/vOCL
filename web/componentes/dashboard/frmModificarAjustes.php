<?php 
    if(isset($_POST['modificarAjustes'])){ 
        $colorPrincipal = $_POST['colorPrincipal'];
        $logoWeb = $_POST['logoWeb'];
        $descripcionWeb = $_POST['descripcionWeb'];
        $descripcionBienvenida = $_POST['descripcionBienvenida'];
        $piePagina = $_POST['piePagina'];
        $modoDepuracion = $_POST['modoDepuracion'];
        actualizarAjustes($colorPrincipal, $logoWeb,  $descripcionWeb, $descripcionBienvenida, $piePagina, $propietarioWeb, $modoDepuracion); ?>

        <div class="alert alert-success alert-dismissible fade show" style="margin: auto;"role="alert">
            <p style="color: #ffffff; margin: auto;"><i class="fas fa-cog"></i> Se actualizaron los ajustes con exito</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div> 

<?php } ?>
