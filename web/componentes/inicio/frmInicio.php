<form method="post" action="">
    <div class="container mt--8 pb-5">
    <div class="row justify-content-center">
        <div class="col-lg-5 col-md-7">
        <div class="card bg-secondary border-0 mb-0">
            <div class="card-body px-lg-5 py-lg-5">
            <div class="text-center text-muted mb-4">
                <h1>Iniciar Sesión</h1>
            </div>
            <form role="form">
                <div class="form-group mb-3">
                <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                    <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div>
                    <input class="form-control" name="correo" placeholder="Correo Electronico" type="email">
                </div>
                </div>
                <div class="form-group">
                <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                    <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input class="form-control" name="password" placeholder="Contraseña" type="password">
                </div>
                    <?php 
                        if(isset($_POST['inicio'])){ 
                            $correo= $_POST['correo'];
                            $password= $_POST['password'];

                            $comprobarCuenta = comprobarCuenta($correo, $password);
                            if ($comprobarCuenta == 0 ){ 
                                $datosCuenta = obtenerDatosCuenta($correo);
                                while ($fila = mysqli_fetch_array($datosCuenta)) {
                                    $_SESSION["imagenUsuario"] = $fila['imagenUsuario'];
                                    $_SESSION["nickUsuario"] = $fila['nickUsuario'];
                                    $_SESSION["tipoUsuario"] = $fila['tipoUsuario'];
                                    $_SESSION["sentenciasUsuario"] = $fila['sentenciasUsuario'];
                                    $_SESSION["correoUsuario"] = $fila['correoUsuario'];
                                    $_SESSION["nombreUsuario"] = $fila['nombreUsuario'];
                                    $_SESSION["apellidosUsuario"] = $fila['apellidosUsuario'];
                                    $_SESSION["ciudadUsuario"] = $fila['ciudadUsuario'];
                                    $_SESSION["paisUsuario"] = $fila['paisUsuario'];
                                    $_SESSION["centroUsuario"] = $fila['centroUsuario'];
                                    $_SESSION["biografiaUsuario"] = $fila['biografiaUsuario'];
                                }
                                header('Location: index.php');
                            }
                            
                        }
                    ?>
                </div>
                <div class="text-center">
                <button type="submit" name='inicio' class="btn btn-primary my-4">Iniciar Sesión</button>
                </div>
            </form>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-12 text-right">
            <a href="registro.php" class="text-light"><small>Crear nueva cuenta</small></a>
            </div>
        </div>
        </div>
    </div>
    </div>
</form>