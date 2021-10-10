<?php 
    if(isset($_POST['cargarSentencia'])){ 
        $codigoRegistro = $_POST['codigoSentencia']; 
        $codigoRegistro = str_replace(PHP_EOL, '\n', $codigoRegistro); ?>
        <script>
        $(document).ready(function(){
            var codemirror = $('.codemirror-textarea').nextAll('.CodeMirror')[0].CodeMirror;
            codemirror.getDoc().setValue("<?=$codigoRegistro?>");
        });
        </script>

<?php } ?>