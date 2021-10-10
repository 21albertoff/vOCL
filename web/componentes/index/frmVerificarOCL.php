<?php
    if(isset($_POST['guardarSentencia'])){ 
        $textoInicial2= $_POST['sentencia']; 
        if ($textoInicial2 != "") {?> 
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <p style="color: #ffffff; margin: auto;"><i class="far fa-save"></i> La sentencia se ha guardado con exito en tus registros</p>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div> 
    
<?php }} ?>

<?php

    if(isset($_POST['analizar'])){ 

        $textoInicial= $_POST['sentencia']; 
        $texto = str_replace(PHP_EOL, '%21', $textoInicial);
        $texto = str_replace("<", '%3c', $texto);
        $texto = str_replace(">", '%3e', $texto);
        $texto = str_replace(" ", '%20', $texto);

        $url = "http://192.168.65.5:8080/analizarocl/".$texto."";

        $curl_handle=curl_init();
        curl_setopt($curl_handle, CURLOPT_URL, $url);
        curl_setopt($curl_handle, CURLOPT_CONNECTTIMEOUT, 2);
        curl_setopt($curl_handle, CURLOPT_RETURNTRANSFER, 1);
        curl_setopt($curl_handle, CURLOPT_USERAGENT, 'Your application name');
        $query = curl_exec($curl_handle);
        curl_close($curl_handle);
        
        if ($query == "") {
            $estadoRegistro = 0;
        } else if (str_contains($query, "error")){
            $estadoRegistro = 0;
        } else if (str_contains($query, "Error")){
            $estadoRegistro = 2; 
            estadisticasGrafica();
            incrementarSentencias(); 
            incrementarIncorrectas();
            ?>

            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <p style="color: #ffffff; margin: auto;"><i class="fas fa-exclamation-circle"></i>  <?=$query?></p>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div> <?php 

        } else {
            $estadoRegistro = 1; 
            estadisticasGrafica();
            incrementarSentencias(); 
            incrementarCorrectas();
            ?>

            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <p style="color: #ffffff; margin: auto;"><i class="fas fa-check-circle"></i> <?=$query?></p>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div> <?php  
        } 
    }
?>