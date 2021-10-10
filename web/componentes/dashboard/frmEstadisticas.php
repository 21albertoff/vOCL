<?php 
    $consultarNumSentenciasOCL = consultarNumSentenciasOCL();
    while($row = mysqli_fetch_array($consultarNumSentenciasOCL)){
        $analizadas = $row['analizadas'];
    }

    $consultarNumSentenciasIncorrectasOCL = consultarNumSentenciasIncorrectasOCL();
    while($row = mysqli_fetch_array($consultarNumSentenciasIncorrectasOCL)){
        $incorrectas = $row['incorrectas'];
    }

    $consultarNumSentenciasCorrectasOCL = consultarNumSentenciasCorrectasOCL();
    while($row = mysqli_fetch_array($consultarNumSentenciasCorrectasOCL)){
        $correctas = $row['correctas'];
    }

    $consultarNumSUsuarios = consultarNumSUsuarios();
    while($row = mysqli_fetch_array($consultarNumSUsuarios)){
        $cantidadUsuarios = $row['cantidad'];
    }
    ?>

<!-- Card Estadisticas -->
<div class="row">
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
        <!-- Card Cuerpo -->
        <div class="card-body">
            <div class="row">
            <div class="col">
                <h5 class="card-title text-uppercase text-muted mb-0">Sentencias OCL Analizadas</h5>
                <span class="h2 font-weight-bold mb-0"><?=$analizadas?></span>
            </div>
            <div class="col-auto">
                <div class="icon icon-shape bg-gradient-gray text-white rounded-circle shadow">
                <i class="fas fa-calculator"></i>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
        <!-- Card Cuerpo -->
        <div class="card-body">
            <div class="row">
            <div class="col">
                <h5 class="card-title text-uppercase text-muted mb-0">Sentencias OCL Correctas</h5>
                <span class="h2 font-weight-bold mb-0"><?=$correctas?></span>
            </div>
            <div class="col-auto">
                <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                <i class="fas fa-check"></i>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
        <!-- Card Cuerpo -->
        <div class="card-body">
            <div class="row">
            <div class="col">
                <h5 class="card-title text-uppercase text-muted mb-0">Sentencias OCL incorrectas</h5>
                <span class="h2 font-weight-bold mb-0"><?=$incorrectas?></span>
            </div>
            <div class="col-auto">
                <div class="icon icon-shape bg-gradient-red text-white rounded-circle shadow">
                <i class="fas fa-times"></i>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    <div class="col-xl-3 col-md-6">
        <div class="card card-stats">
        <!-- Card Cuerpo -->
        <div class="card-body">
            <div class="row">
            <div class="col">
                <h5 class="card-title text-uppercase text-muted mb-0">Total de usuarios</h5>
                <span class="h2 font-weight-bold mb-0"><?=$cantidadUsuarios?></span>
            </div>
            <div class="col-auto">
                <div class="icon icon-shape bg-gradient-primary text-white rounded-circle shadow">
                <i class="fas fa-users"></i>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>
    </div>
