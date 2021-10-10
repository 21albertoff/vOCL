<?php 
    $consultarRegistros = consultarRegistros($nombreUsuario);
    while($row = mysqli_fetch_array($consultarRegistros)){
        $idRegistros = $row['idRegistros'];
        $codigoRegistro = $row['codigoRegistro'];
        $estadoRegistro = $row['estadoRegistro'];
        $fechaRegistro = $row['fechaRegistro']; ?>
        
        <tr>

        <th scope="row">
            <div class="media align-items-center">
            <a class="mr-4">
                <b>#<?=$idRegistros?></b>
            </a>
            <div class="media-body" style="text-overflow: ellipsis; width: 150px; white-space: nowrap; overflow: hidden;">
                <span  class="name mb-0 text-sm"><?=$codigoRegistro?></span>
            </div>
            </div>
        </th>

        <td>
            <?php if ($estadoRegistro == 1) {?>
            <span class="badge badge-dot mr-2">
                <i class="bg-success"></i>
                <span class="status">SIN ERRORES</span>
            </span>
            <?php } elseif ($estadoRegistro == 2) {?>
            <span class="badge badge-dot mr-2">
                <i class="bg-danger"></i>
                <span class="status">CON ERRORES</span>
            </span>
            <?php } else {?>
            <span class="badge badge-dot mr-2">
                <i class="bg-dark"></i>
                <span class="status">SIN ANALIZAR</span>
            </span>
            <?php } ?>
        </td>

        <td class="budget">
            <?=$fechaRegistro?>
        </td>

        <td class="text-right">
            <div class="row">
                <div class="col-10 text-right">
                    <form method="post" action="index.php">
                        <input type="hidden" name="codigoSentencia" value="<?=$codigoRegistro?>"></input>
                        <button class="btn btn-sm btn-primary" type="submit" name='cargarSentencia' aria-haspopup="true">
                            <i class="fas fa-eye"></i> Ver sentencia
                        </button>
                    </form>
                </div>

                <div class="col-2">
                    <form method="post" action="">
                        <input type="hidden" name="idRegistro" value="<?=$idRegistros?>"></input>
                        <button class="btn btn-sm text-danger" type="submit" name='eliminarRegistro' aria-haspopup="true">
                            <i class="fas fa-trash"></i> Eliminar
                        </button>
                    </form>
                </div>
            </div>

        </td>

        </tr>
<?php } ?>