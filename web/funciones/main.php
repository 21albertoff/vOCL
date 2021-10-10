<?php
    #REGISTRO
    function registrarse($NickUsuario, $Centro, $Correo, $Password){
        $imagenPorDefecto = "0xffd8ffe000104a46494600010100000100010000ffdb0043000402030303020403030304040404050906050505050b080806090d0b0d0d0d0b0c0c0e1014110e0f130f0c0c1218121315161717170e11191b19161a14161716ffdb0043010404040505050a06060a160f0c0f1616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616161616ffc2001108012c012c03012200021101031101ffc4001b00010002030101000000000000000000000006070104050302ffc40014010100000000000000000000000000000000ffda000c03010002100310000001ba4000000000000000000000000000000000000000000000000000000000000000000038e76104e5967aa7fa2d6571dd254f0f7000000000000000000060cf1385013b5c5c000003de65061797ad39691d10000000000000000205d9ab4c0000000006e698ba37ea1b70fa00000000000003e3ee2a40b9e000000000002c7ae3a25ccc6400000000000055f6852a6900000000000002e2eac4a5a0000000000007cd197a5187c00000000000002793b824ec00000000000052f7455e460000000000000164cbb95d5000000000000117947c9453a1cf0000000000074b9b639300000000000000011caaef78190467000000000374dcb734b7c000000000000000020f02bd78a544ee710c3380000f69991ab4f6fd40000000000000003114258a9e7277c0e475c41b93678aa3ead6c15d76e543c7d80791eaaefdc9eb5f6000000000001a1e3549d0e1833812b9d53592f754b2426ae2740db7960f67379449fe2bd8c13f81e88036ecaaabe8bd50f980000000034372a4347500000067000c6432c0000000cd9b58fa979395d5000001a844603ede200000000000000000001dbb6a8ab309580001009dd2a6b00000000000000000000074f982f5fa8fc800008dd592f88000000000000000000000004aecca46ec3e803053bcbf4f3000000000000000000000005c94dda64901ffc40029100001040103030402030100000000000004010203054000061311203010121421153122335070ffda0008010100010502ff00a6976618fa23717dc97c73b5f99b1d36eec1161dc24a685be124d4134533332cecc70f56168514bdf0cb2c2facbe5d432472c7937975edd2aaaaf8ab0f9c296b8c88d871f725a7df941265127ae2a3306c5dc677c4157cf4a6b822daa8e6e1c8e4632c8952cdc0da65f24187bb09e20306a48f8a7e1eec9b92d30a925e6abc2b47f258e16ce7f5afc15fd4bfdb85b2d7eb057f52a74970b65a7f1c2b3671d8616ce674afc2dd70f1d9e15243c15785bac7e5afc1a81fe55861c8d47b2cc67086e06d213886c4dc607cb1bcf48129a5b511adc5dc957f7e504594b9ebc58c41f1eee97dcaa8a8be2ad027364ad0e10e0c9b3ac1cc43ea8a17c104524cfada1d451b228f30bad0c8d11b75ba9284d4d7e16c74da4b15d43b7885d0d42247a8628a16e3aaa2258de410e96e0f59eaad60313cb348c8a3b5bc91ef02fd743cd14f1e01e5c22436b69398ef44fdd6de4f06813c52d3c2f7358db0bd1e2434b9cb7fa084cc2cb516b119e7b53a30a030994a9bb5155143b7360d0fb8635d436d5f269850eed7247a59624d496013127bd059a2b704eed144ce43bb5aaa8b416dcfe5b12a30c538890a271d3e976ed97ca8fc4f72359766b8d2f26191f14b52634d13c3bb0de8dcba231433517aa779d3b4616791f34d99b54be613bf7815d5f9b504a8a7a2f54ed95c8c8cc95d3939db689f9159dbba67e2accfda33f1d876ef09bdc6e7852ac25b57dc9d975272da7f814b272d5faafea65eb2ff0081b5557f11e9ffc40014110100000000000000000000000000000080ffda0008010301013f0134ff00ffc40014110100000000000000000000000000000080ffda0008010201013f0134ff00ffc4003b10000102020509030b0403000000000000010203001112214041510413222330315261712032421033505362728182a1b1d1149192a2344370ffda0008010100063f02ff00a6c96f02704d71a8c9fe2a31a3413f2c79ff00ea23ce83d531ac690ae95449c4a9a3ceb1149a712b1c8db644d35f008ad7411c09d852696507940465827ed880b6d4149378b51632335dee7e2264ccece936669f122e319c6cd7e24e16839264eaf7d43edb60eb46b176301d6fe230366cdb675ae6ee42c0153d5aaa5880a0660eeb215a8c801330b78de6ae42c272659d26eb4f4b26646f78fd2c4dbb7035f4b250f569958da5ceba323637978acd8d68e15d8d479d8df1d2c6aeb637cf4b1bc8c166c6b5f12ec74fd6267636917ca66c79d1de64cfe1626daba7a5d2c852a130448c2d93b877798b09ca54349ceef4b2d340d6b7bb9d80023569ef980902406eb31caf274fbe91f7db069a1d4e101a6c7538da0bf91a6bbdbfc448891d9c9b124deb3b8466db1d558daa6a141ce34c4ca29a3893b0a2d20acf280bcb15f208086d0129170b6e9b201c53546a728972588d1cdabe68f323f908f3491d571ac79b4f4ae26e153a79d4228b4da50390b44cc1431ad563740733bbbc374049d07784ed8adc504a45e628647a091e23bcc51cad1f3a629b4b0a1cac39c7952c05e6253a0d5c81d8a0feb518de2354e89f09a8eca92c848c4c14e4fad56374527964e02e1e5a6caca4fde282e4877871e9b7a4aad67ba9c60baf2a64fd3b53112ce671382eb8d730a4f34d71fe401ef09468bed9f9a3be9fde2b711fca34b296ff0078d0a6e7411261a4a399acc4de754bea7b531518193e52759e15716d4bce7c06260bce1acfd2d13119878eb93fd86cca946406f8a5feb4d4816a4b8d9929266203a3bdb94303b2fd1b677d6bfc5b013e6d752e2ad82de5784429d70cd4a3336dcc28e9b5f6d8272549dda4ab721dbb72ba44c7694b56e489985bcaf199dbd209d26b44f68a2f74d1f40168ee747d7b4967d5a7d00dba3c0a06278f65e5fb5e81657eccbb2a271f40a460a3e5ffc4002b10010001020503030403010100000000000111002131404151713061812091a110b1d1f050e1f170c1ffda0008010100013f21ff00a6b681f7f424153b3f8290b8fb4bef5da7eddaa4cf1dac07f92a85dd41f62a6506b36747ed95bf9da938da0b079dea7d45462dd5c50d876ddfc95829d1332d8a905c2c5a76fca99b93157a771b3129b750c4c5e62f640b331eceb46671340d9a7abb6bed65b04231f29a52cb8bd75027c277a1040946a6506c4b0ed534b101f60a7aed3cf9886bfd5ca412c44f0c724a2b103bd59a2e4983864da0e051eeddc9cf521e516c9ddb9b2e2726eff6f84324e1bda94a315b93c7faafbe48cb372a21b3fbe4fcccfdf24571f3e26d939abb7c01fde48ab5b02f32ce4e662179cdf2455b39f706392587973e0bb4588080c91562e31da8c16495ec64520bb32d3fbe5711e13d9da92187aeb1269ec6de68c10601a195d29a5aea6f875a622bc0776b07e5f59ef98b462b96bdff000a66e0c474a7a568d2a00aedbb62f34bf6805fcef4d2ddae7dcd3a079f74334eb007ef2d1c6d8033b7fe5b3e2a44bf23f2562ee187de9aa9cb8770a5e41e4a9935705f015194748b30c100315d29f0c76d07ceb56d39589f6d2044574c78eb62f754aba455cbfc4a9c4d3f592843feab22dee1878bb14fed4dce3cef4fd124861ed4482e149f9b5a01338878e93b09c520a247d91fcd7eb7a907d0a39af069c8a38b4f877f5d8583df5f8a7a180341b1ea248898238569e1fa9c6a186355856089d9281cf002bfc3d1b26e45324718c4fed425c9c67cd4a03fd4d2b8762c1e297d22dd0644c4ab7030e8763dfaaa2616d7daa965e01a0d8e81f5d2a283a690484c12adc21b3f373d30c8394e852a0c7846f9a44b34156ec1d266b96f4db4ce157d0bb6fe28a4423827412fb3a1bba157cc119d9f9d83df4fb74304ef7ba19e9918fcac6881246e3ea5ea1a9d8ac571786d9e292426f169f1ea831888e317f8090d85385ff3ea839b48f2ff005fc023f0f849a1138093d370acc4f16ffcfe065ec6f725bd189c5263c5cfbff02e66033dfebfffda000c0301000200030000001000000000000000000000000000000000000000000000000000000000000000000000420020000000000000000000011400001040400000000000000001880000000041c000000000000000700000000000b08000000000000100000000000000000000000000034000000000000028000000000000b00000000000000000000000000028000000000000508000000000000014100000000028000000000000000030804000300000000000000000104010f0470000420000000000040000c300204738428200000000600000020c0002000000020000012400000000000000000001c00000c000000000000000000000520000620000000000000000000010b0002800000000000000000000002803ffc40014110100000000000000000000000000000080ffda0008010301013f1034ff00ffc40014110100000000000000000000000000000080ffda0008010201013f1034ff00ffc4002b100100010302050304030101000000000001110021314151406171819130a1b11020c1f050d1e1f170ffda0008010100013f10ff00d31405508259acb267c6d983bb4b483176fd37a5836d26f94d5cc54a280da0fb053a40b3257c9ed4d2976077bbda860ea60c3a993bf1b1d6e58e1d7a3de9c40c8c3cd9eeb72a925fee70da8dbea46aff0068382c00c1d3b3d4a22f72623fd74e2508a8012ab8a66532f4cb5e651f04ccb2bbad4be84b52d0498ee6cf3d9e7416c80ae99dce7c399a464431e96adf2f6a5271eaa966de79a0d4f8a825cc29c2baa78570028a37f91d0e6ce94ced292bbbabebbd422559d937267da8291da91091e1131092b00969e0965b30d83b7bad61ebdc53392c8a54d3f4b2708b7e53192e793079a9297d79ab17079b580f667b530124256e70730a3971fd91470491f6af557c1c1e1e27b9107b0518e091d2fbba5be478261b227da9b3453cd5a31c13499165e1c1215a87b5227783e1518e0a529b93bb82ca9d5008ce66fb138350f0a9ce34f97c382ca9e19bf23b8761ef4e78258bfc62e5d4f9e0b2a87bd0c176d78d9ed59e07242d458c87588ef40230200d0e0b2a30c9270a21abc204912dd78b3cce050363cb8b9ee3c0569c1cd084e487395ebd4e74ce088c22443afae75068f6d4177ff5410898a0b0153c23785e924c72a67503dcef4545247a6df972a7389fb3444a049306ebf6c50470d022248972a2c253803cbccff8da9f10c0e15b269e90bb1455ab2259fcbc8a12490275abf069c4cbbd34102d02e4303adf9d140b71203c9dd490c24472fa39fb57a410d875daac8666795e478e879ab5f08e0e221898fb1b90e36a9667d3f3eaef4e53e6c107e9b536e42dfd41416244dbfb28d93c86c3d856856ac87f08f7a39992e07b9e5a245c88f3eb05e9caeff550cbc203779440375abe65412bdf57679ab07d9858ba3a88e735b7c131eabd4e59fb0cd24d47d02f4c85ab4fb0a654c51db7ed52fcfb841d07c0dfa518de04effaede2b7f9b24e4991e4f0238c0404ec0a4e242c80d165d7b55cfd0538191509de8a6981651b2f979a52685fce967b494538f40a68c840756a10bc8315f5cf65b9d23102c0a1ed80f9a7e82b8db0c96d8129910a54b6b51f8cfaeb5c6006cb5761ab4de5acb1b63429fb166941bcc02b71a1426c22c3bbe547ac3021d986a1c7fae3dc8a8b3f3ff550808e3fb66a2c5cc83f35a1b8859da4d2221785f2468559084e5d303c34ed14c9e0581daa4a2df418a9e540e449c218474685e9a540e9b1f3ebeacdba30b4561f974a91ddb5d00681e915d1acc2913403d28836a9a4173e83c154a211dca010a4a5a0f835f3e9b6b5b50012af62946295e9a973627c7146808b4227e2a006d1686639393d26270429fa1cbda810e2dc22c6c163ad5fa4d002b4a244dfd08596b823b1d58295aaeeddfd8a5b71625245461b977fc3c7deda931e626f2f7425ee71c7e43246ac1e19ed4188e0308933f77259d202af8291a6d47468ec414f1aaf445985d5176f81dbee388ce06ffe003bd09bd39e34cd2e3562d8b2f6878a4861fb6ffe529c5ff81e7f809bc08ce812789a63e409b8927db1e2507b043fc00a681ac29cd5f14e7ead1cd1b4d74aeb765fc019a65279284dfcfd7fffd9";
        $sentencia = "INSERT INTO `usuarios`(`nickUsuario`, `passwordUsuario`, `correoUsuario`, `tipoUsuario`, `imagenUsuario`, `centroUsuario`) VALUES ( '$NickUsuario', '$Password', '$Correo', 1, '$imagenPorDefecto', '$Centro')"; 
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    function comprobarPassword($Password1, $Password2){
        $resultado = 0;
        if ($Password1 != $Password2) { ?>
            <small>Por favor, vuelva a intentarlo: <span class="text-danger font-weight-700">Las contraseñas no son iguales</span></small>
        <?php  $resultado = 1; }
        return $resultado;
    }

    function comprobarCorreo($Correo){
        $resultado = 0;
        $sentencia = "SELECT COUNT(*) AS `cantidad` FROM `usuarios` WHERE `correoUsuario` LIKE '$Correo'";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
        while ($fila = mysqli_fetch_array($ejecutar)) {
            $resultado = $fila['cantidad'];
        }

        if ($resultado != 0){ ?>
            <small>Por favor, prueba a iniciar sesión: <span class="text-danger font-weight-700">Este correo ya esta en uso</span></small>
        <?php }
        return $resultado;
    }

    #INICIO
    function comprobarCuenta($Correo, $Password){
        $resultado = 0;
        $passwordUsuario = "0-0";
        $sentencia = "SELECT `passwordUsuario` FROM `usuarios` WHERE `correoUsuario` LIKE '$Correo'";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
        while ($fila = mysqli_fetch_array($ejecutar)) {
            $passwordUsuario = $fila['passwordUsuario'];
        }
        if ($passwordUsuario != $Password){ ?>
            <small>Por favor, vuelve a intentarlo: <span class="text-danger font-weight-700">El correo y/o la contraseña son incorrectos</span></small>
        <?php $resultado = 1; }
        return $resultado;
    }

    function obtenerDatosCuenta($Correo){
        $sentencia = "SELECT * FROM `usuarios` WHERE `correoUsuario` LIKE '$Correo'";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    #PERFIL
    function actualizarPerfil($NickUsuario, $Correo, $NombreUsuario, $ApellidoUsuario, $Imagen, $Ciudad, $Pais, $Centro, $Biografia){
        $sentencia = "UPDATE `usuarios` SET `nickUsuario`='$NickUsuario',`nombreUsuario`='$NombreUsuario',`apellidosUsuario`='$ApellidoUsuario',`imagenUsuario`='$Imagen',`centroUsuario`='$Centro',`ciudadUsuario`='$Ciudad',`paisUsuario`='$Pais',`biografiaUsuario`='$Biografia' WHERE `correoUsuario` LIKE '$Correo'";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }


    #INDEX
    function guardarRegistro($CodigoRegistro, $EstadoRegistro, $nombreUsuario){
        $sentencia = "INSERT INTO `registros`(`codigoRegistro`, `estadoRegistro`, `idUsuarios`) VALUES ('$CodigoRegistro','$EstadoRegistro', (SELECT `idUsuarios` FROM `usuarios` WHERE `nickUsuario` LIKE '$nombreUsuario'))";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    function cargarRegistros($idRegistro){
        $sentencia = "SELECT `codigoRegistro` FROM `registros` WHERE `idRegistros` = $idRegistro";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    function cargarAyudas(){
        $sentencia = "SELECT `tituloAyuda`, `descripcionAyuda`, `imagenAyuda` FROM `ayudas` ORDER BY rand() LIMIT 1";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    #REGISTROS
    function consultarRegistros($nombreUsuario){
        $sentencia = "SELECT `idRegistros`, `codigoRegistro`, `estadoRegistro`, `fechaRegistro` FROM `registros` WHERE `idUsuarios` = (SELECT `idUsuarios` FROM `usuarios` WHERE `nickUsuario` LIKE '$nombreUsuario') ORDER BY `fechaRegistro` DESC";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function eliminarRegistro($idRegistro){
        $sentencia = "DELETE FROM `registros` WHERE `idRegistros` = $idRegistro";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    #AYUDAS
    function insertarAyuda($tituloAyuda, $descripcionAyuda, $imagenAyuda){
        if ($imagenAyuda == ""){
            $sentencia = "INSERT INTO `ayudas`(`tituloAyuda`, `descripcionAyuda`) VALUES ('$tituloAyuda','$descripcionAyuda')";
        } else {
            $sentencia = "INSERT INTO `ayudas`(`tituloAyuda`, `descripcionAyuda`, `imagenAyuda`) VALUES ('$tituloAyuda','$descripcionAyuda', '$imagenAyuda')";
        }
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    function consultarAyudas(){
        $sentencia = "SELECT `idAyudas`, `tituloAyuda`, `descripcionAyuda` FROM `ayudas`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function eliminarAyuda($idAyuda){
        $sentencia = "DELETE FROM `ayudas` WHERE `idAyudas` = $idAyuda";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    #ESTADISTICAS
    function consultarNumSentenciasOCL(){
        $sentencia = "SELECT `analizadas` FROM `estadisticas`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function consultarNumSentenciasCorrectasOCL(){
        $sentencia = "SELECT `correctas` FROM `estadisticas`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function consultarNumSentenciasIncorrectasOCL(){
        $sentencia = "SELECT `incorrectas` FROM `estadisticas`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function incrementarSentencias(){
        $sentencia = "UPDATE `estadisticas` SET `analizadas`= (SELECT `analizadas` FROM `estadisticas`) + 1";
        mysqli_query($GLOBALS["db"], $sentencia);
    }

    function incrementarCorrectas(){
        $sentencia = "UPDATE `estadisticas` SET `correctas`= (SELECT `correctas` FROM `estadisticas`) + 1";
        mysqli_query($GLOBALS["db"], $sentencia);
    }

    function incrementarIncorrectas(){
        $sentencia = "UPDATE `estadisticas` SET `incorrectas`= (SELECT `incorrectas` FROM `estadisticas`) + 1";
        mysqli_query($GLOBALS["db"], $sentencia);
    }

    function consultarNumSUsuarios(){
        $sentencia = "SELECT COUNT(*) AS `cantidad` FROM `usuarios`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }

    function estadisticasGrafica(){
        $day = date("l");
        switch ($day) {
            case "Sunday":
                $sentencia = "UPDATE `grafica` SET `domingo`= (SELECT `domingo` FROM `grafica`) + 1";
            break;
            case "Monday":
                $sentencia = "UPDATE `grafica` SET `lunes`= (SELECT `lunes` FROM `grafica`) + 1";
            break;
            case "Tuesday":
                $sentencia = "UPDATE `grafica` SET `martes`= (SELECT `martes` FROM `grafica`) + 1";
            break;
            case "Wednesday":
                $sentencia = "UPDATE `grafica` SET `miercoles`= (SELECT `miercoles` FROM `grafica`) + 1";
            break;
            case "Thursday":
                $sentencia = "UPDATE `grafica` SET `jueves`= (SELECT `jueves` FROM `grafica`) + 1";
            break;
            case "Friday":
                $sentencia = "UPDATE `grafica` SET `viernes`= (SELECT `viernes` FROM `grafica`) + 1";
            break;
            case "Saturday":
                $sentencia = "UPDATE `grafica` SET `sabadado`= (SELECT `sabadado` FROM `grafica`) + 1";
            break;
        }
        mysqli_query($GLOBALS["db"], $sentencia);

    }

    #AJUSTES
    function actualizarAjustes($color, $logo, $descripcion1, $descripcion2, $piePagina, $propietarioWeb,  $depuracion){
        $sentencia = "UPDATE `ajustes` SET `colorPrincipal`='$color',`logoWeb`='$logo',`descripcionWeb`='$descripcion1',`descricionBienvenida`='$descripcion2',`descripcionPie`='$piePagina',`propietarioWeb`='$propietarioWeb',`depuracion`='$depuracion'";
        $ejecutar = mysqli_query($GLOBALS["db"], $sentencia);
    }

    function consultarAjustes(){
        $sentencia = "SELECT `colorPrincipal`, `logoWeb`, `descripcionWeb`, `descricionBienvenida`, `descripcionPie`, `propietarioWeb`, `depuracion` FROM `ajustes`";
        return mysqli_query($GLOBALS["db"], $sentencia);
    }




?>