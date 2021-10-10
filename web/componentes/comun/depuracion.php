<?php 
    if ($depuracion == "1"){ ?>

        <div class="card-body">
            <h4>DEPURACION ACTIVADA</h4>
            <div class="card-body">
                <p><b>Color principal:</b><?=$colorPrincipal?> <b>Titulo:</b><?=$tituloWeb?> <b>propietario:</b><?=$propietarioWeb?> <b>Logo:</b><?=$logoWeb?> </p>
                <p><b>Descripcion:</b><?=$DescripcionWeb?> <b>Bienvenida:</b><?=$mensajeInicio?></p>
                <p><b>Pie:</b><?=$pieDePagina?></p><br>
                <p><b>Usuario:</b><?=$nombreUsuario?> <b>Rol:</b><?=$tipoUsuario?> <b>SentenciasAnalizadas:</b><?=$sentenciasAnalizadas?> <b>CorreoUsuario:</b><?=$correoUsuario?> </p>
                <p><b>Nombre:</b><?=$Nombre1Usuario." ".$ApellidosUsuario?> <b>Informacion:</b><?=$informacionUsuario?></p></p>
                <p><b>Ciudad Usuario:</b><?=$ciudadUsuario?> <b>Pais:</b><?=$PaisUsuario?> <b>Centro:</b><?=$centroUsuario?></p>
                <p><b>Estado Registro:</b><?=$estadoRegistro?></p>

            </div>
        </div>


<?php  } ?>