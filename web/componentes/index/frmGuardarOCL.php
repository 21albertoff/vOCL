<?php 
if(isset($_POST['analizar']) || isset($_POST['guardarSentencia'])){ 

    $textoInicial1= $_POST['sentencia']; 
    $textoInicial1 = str_replace(PHP_EOL, '\n', $textoInicial1); ?>
    
    <script>
        $(document).ready(function(){
            var codemirror = $('.codemirror-textarea').nextAll('.CodeMirror')[0].CodeMirror;
            codemirror.getDoc().setValue("<?=$textoInicial1?>");
        });
    </script>
<?php  } ?>

<?php 

if(isset($_POST['guardarSentencia'])){

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
        } else {
            $estadoRegistro = 1; 
        } 

    $textoInicial2= $_POST['sentencia']; 
    if ($textoInicial2 != "")
        guardarRegistro($textoInicial2, $estadoRegistro, $nombreUsuario);
} 

?>