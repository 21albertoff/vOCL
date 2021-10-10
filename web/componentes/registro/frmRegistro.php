<form method="post" action="">
    <div class="container mt--8 pb-5">
        <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8">
            <div class="card bg-secondary border-0">
            <div class="card-body px-lg-5 py-lg-5">
                <div class="text-center text-muted mb-4">
                <h1>Registrarse</h1>
                </div>
                <form role="form">
                <div class="form-group">
                    <div class="input-group input-group-merge input-group-alternative mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-single-02"></i></span>
                    </div>
                    <input class="form-control" name="nombre" placeholder="Nombre" type="text" required>
                    </div>
                    <div class="input-group input-group-merge input-group-alternative mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-hat-3"></i></span>
                    </div>
                    <input class="form-control" name="centro" placeholder="Universidad (Opcional)" type="text">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group input-group-merge input-group-alternative mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div>
                    <input class="form-control" name="correo" placeholder="Correo Electronico" type="email" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input class="form-control" name="password1" placeholder="Contraseña" type="password" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group input-group-merge input-group-alternative">
                    <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input class="form-control" name="password2" placeholder="Repetir contraseña" type="password" required>
                    </div>
                </div>
                <div class="text-muted font-italic">
                    <?php 
                        if(isset($_POST['registro'])){ 
                            $nickUsuario= $_POST['nombre'];
                            $centro= $_POST['centro'];
                            $correo= $_POST['correo'];
                            $password1= $_POST['password1'];
                            $password2= $_POST['password2'];

                            $comprobarPassword = comprobarPassword($password1, $password2);
                            $comprobarCorreo = comprobarCorreo($correo);

                            if ($comprobarPassword == 0 && $comprobarCorreo == 0){
                                registrarse($nickUsuario, $centro, $correo, $password1); ?>

                                <div class="alert alert-success alert-dismissible fade show" role="alert">
                                    <strong>¡Cuenta Creada!</strong> Ya puede iniciar sesión.
                                </div>

                            <?php }
                            
                        }
                    ?>
                    </div>
                <div class="text-center">
                    <button type="submit" name='registro' class="btn btn-primary mt-4">Crear Cuenta</button>
                </div>
                </form>
            </div>
            </div>
        </div>
        </div>
    </div>
</form>