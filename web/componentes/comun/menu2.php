<?php include "componentes/comun/depuracion.php";?>

<nav class="navbar navbar-top navbar-expand navbar-dark bg-default border-bottom">
    <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <!-- Search form -->
        <div class="navbar-collapse navbar-custom-collapse collapse" id="navbar-collapse">
            <a href="index.php">
                <img src="<?=$logoWeb?>" style="width: 30%;">
            </a>
        </div>
        
        <ul class="navbar-nav align-items-center">
        
            
        <li class="nav-item dropdown">
            <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true">
            <span class="shortcut-media avatar rounded-circle bg-gradient-primary" style="background: linear-gradient( 
                87deg, #172b4d 0, #172b4d 100%) !important;">
                <i class="fas fa-sliders-h"></i>
            </span>
            </a>
            <div class="dropdown-menu dropdown-menu-lg dropdown-menu-dark bg-default dropdown-menu-right">
            <div class="row shortcuts px-4">
                <a href="estadisticas.php" class="col-4 shortcut-item">
                <span class="shortcut-media avatar rounded-circle bg-gradient-primary">
                    <i class="far fa-chart-bar"></i>
                </span>
                <small>Estadisticas</small>
                </a>
                <a href="ayuda.php" class="col-4 shortcut-item">
                <span class="shortcut-media avatar rounded-circle bg-gradient-primary">
                    <i class="far fa-life-ring"></i>
                </span>
                <small>Ayudas</small>
                </a>
                <a href="ajustes.php" class="col-4 shortcut-item">
                <span class="shortcut-media avatar rounded-circle bg-gradient-primary">
                    <i class="fas fa-cog"></i>
                </span>
                <small>Ajustes</small>
                </a>
            </div>
            </div>
        </li>
        </ul>


        <!-- Menu -->
        <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
            <li class="nav-item dropdown">
                <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <div class="media align-items-center">
                    <span class="avatar avatar-sm rounded-circle">
                    <img alt="Image placeholder" style="width: 36px; height: 36px;" src="<?="data:image/png;base64,".base64_encode($imagenUsuario)?>">
                    </span>
                    <div class="media-body  ml-2  d-none d-lg-block">
                    <span class="mb-0 text-sm  font-weight-bold"><?=$nombreUsuario?></span>
                    </div>
                </div>
                </a>
                <div class="dropdown-menu  dropdown-menu-right ">
                <div class="dropdown-header noti-title">
                    <h6 class="text-overflow m-0">¡Bienvenido!</h6>
                </div>
                <a href="perfil.php" class="dropdown-item">
                    <i class="ni ni-single-02"></i>
                    <span>Mi perfil</span>
                </a>
                <a href="registros.php" class="dropdown-item">
                    <i class="ni ni-calendar-grid-58"></i>
                    <span>Mis actividades</span>
                </a>
                <div class="dropdown-divider"></div>
                <a href="cerrar.php" class="dropdown-item">
                    <i class="ni ni-user-run"></i>
                    <span>Cerrar Sesion</span>
                </a>
                </div>
            </li>
        </ul>
    </div>
    </div>
</nav>  