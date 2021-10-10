<?php 
    $consultarAyudas = consultarAyudas();
    while($row = mysqli_fetch_array($consultarAyudas)){
      $idAyudas = $row['idAyudas'];
      $tituloAyuda = $row['tituloAyuda'];
      $descripcionAyuda = $row['descripcionAyuda']; ?>        
      <tr>

        <th scope="row">
            <div class="media align-items-center">
                <a class="mr-4">
                    <b class="badge badge-lg badge-primary">#<?=$idAyudas?></b>
                </a>
                <div class="media-body" style="text-overflow: ellipsis; width: 150px; white-space: nowrap; overflow: hidden;">
                    <span class="name mb-0 text-sm"><?=$tituloAyuda?></span>
                </div>
            </div>
        </th>

        <td>
            <span class="text" style="text-overflow: ellipsis; width: 150px; white-space: nowrap; overflow: hidden;"><?=$descripcionAyuda?></span>
        </td>
        <td class="text-right">
          <form method="post" action="">

            <input type="hidden" name="idAyudas" value="<?=$idAyudas?>"></input>
            <button class="btn btn-sm text-danger" type="submit" name='eliminarAyuda' aria-haspopup="true">
              <i class="fas fa-trash"></i> Eliminar
            </button>
          </form>
        </td>
      </tr>
                
<?php } ?>