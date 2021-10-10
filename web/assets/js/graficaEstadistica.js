$(document).ready(function(){
    $.ajax({
      url: "http://localhost/oclOFICIAL/componentes/dashboard/ctrGraficaEstadistica.php",
      method: "GET",
      success: function(data) {
        var lunes = data[0].lunes;
        var martes = data[0].martes;
        var miercoles = data[0].miercoles;
        var jueves = data[0].jueves;
        var viernes = data[0].viernes;
        var sabado = data[0].sabado;
        var domingo = data[0].domingo;
        var resultados = [lunes, martes, miercoles, jueves, viernes, sabado, domingo];
        var dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"];

        var chartdata = {
            labels: dias,
            datasets : [
              {
                label: 'Dias de la semana',
                data: resultados,
                backgroundColor: "#1976D2",
              },
            ]
        
          };
    
          var ctx = $("#graficaestadistica");
    
          var barGraph = new Chart(ctx, {
            type: 'bar',
            data: chartdata,
            responsive: true,
    
          });
        },
        error: function(data) {
          console.log(data);
        }
      });
    });