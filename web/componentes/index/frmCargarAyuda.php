<!-- Panel de ayuda -->
<?php  
    $consultarAyudas = cargarAyudas();
    while($row = mysqli_fetch_array($consultarAyudas)){
        $urlImagenAyuda = "nada";
        $tituloAyuda = $row['tituloAyuda'];
        $descripcionAyuda = $row['descripcionAyuda'];  
        $urlImagenAyuda = $row['imagenAyuda'];?>
  
        <div class="col-xl-4">
            <div class="card">
            <div class="card-header bg-transparent">
                <div class="row align-items-center">
                <div class="col">
                    <h6 class="text-uppercase text-muted ls-1 mb-1"><i class="fas fa-book"></i> Guía de Ayuda</h6>
                    <h5 class="h3 mb-0"><?=$tituloAyuda;?></h5>
                </div>
                </div>
            </div>
            <div class="card-body">
                <p><?=$descripcionAyuda?></p>
                <?php if ($urlImagenAyuda != null) { ?>
                    <img class="card-img-top" src="<?=$urlImagenAyuda;?>" alt="Imagen de ayuda">
                <?php  } ?>
            </div>
            </div>
        </div>

<?php } ?>