<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
       
		
		<div class="row">
		<div class="col-lg-3">
	        <div class="ibox float-e-margins">
	            <div class="ibox-title">
	                <span class="label label-success pull-right">Ativos</span>
	                <h5>Imóveis cadastrados</h5>
	            </div>
	            <div class="ibox-content">
	                <h1 class="no-margins" id="divTotalImoveis"></h1>
	                <div class="stat-percent font-bold text-success" id="divTotalImoveisAtivos"><i class="fa fa-bolt"></i></div>
	                <small>Total imóveis</small>
	            </div>
	        </div>
		</div>
        <div class="col-lg-3">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <span class="label label-info pull-right">Annual</span>
                    <h5>Orders</h5>
                </div>
                <div class="ibox-content">
                    <h1 class="no-margins">275,800</h1>
                    <div class="stat-percent font-bold text-info">20% <i class="fa fa-level-up"></i></div>
                    <small>New orders</small>
                </div>
            </div>
        </div>
      	<div class="col-lg-3">
          	<div class="ibox float-e-margins">
              <div class="ibox-title">
                  <span class="label label-primary pull-right">Today</span>
                  <h5>Vistits</h5>
              </div>
              <div class="ibox-content">
                  <h1 class="no-margins">106,120</h1>
                  <div class="stat-percent font-bold text-navy">44% <i class="fa fa-level-up"></i></div>
                  <small>New visits</small>
              </div>
          	</div>
      	</div>
      <div class="col-lg-3">
          <div class="ibox float-e-margins">
              <div class="ibox-title">
                  <span class="label label-danger pull-right">Low value</span>
                  <h5>User activity</h5>
              </div>
              <div class="ibox-content">
                  <h1 class="no-margins">80,600</h1>
                  <div class="stat-percent font-bold text-danger">38% <i class="fa fa-level-down"></i></div>
                  <small>In first month</small>
              </div>
          </div>
   </div>
		</div>
		<div class="row">
		<div class="col-lg-12">
	        <div class="ibox float-e-margins">
	            
	            <div class="ibox-content">
	                
	                
	                <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQTpXj82d8UpCi97wzo_nKXL7nYrd4G70"></script>
             	
	
			<div class="google-map" id="mapa"></div>
		
	                
	                
	            </div>
	        </div>
		</div>
		</div>
		
    </jsp:body>
</t:genericpage>
<script src="js/imovGoogleMaps.js" language="JavaScript"></script>
<script>
$(document).ready(function(){
	var jsonImovel = localizarImoveis();
	calcularIndiceImoveisAtivos(jsonImovel);
	inicializarGoogleMapsImoveisCadastrados(jsonImovel);
});

function inicializarGoogleMapsImoveisCadastrados(jsonImovel){
	var nrLatitude = 0;
	var nrLongitude = 0;
	var dsMarcador = "";
	var dsEndereco = "";
	var nrCep = "";
	var flClick = false;
	inicializarGoogleMaps(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep, flClick);
	
	carregarMarcadoresImovel(jsonImovel);
}

function carregarMarcadoresImovel(jsonImovel){
	var marcadores = [];
	var marcador;
	var imovel;
	var endereco;
	
	for (var i = 0; i < jsonImovel.length; i++) {
	    imovel = jsonImovel[i];
  		endereco = imovel.endereco;
		marcador = {nrLatitude: endereco.nrLatitude,
					nrLongitude: endereco.nrLongitude,
					dsMarcador: imovel.dsImovel,
					dsEndereco: endereco.dsRua,
					nrCep: endereco.nrCep
           			};
		marcadores.push(marcador);
	}
	
	carregarMarcadores(marcadores);
}

function calcularIndiceImoveisAtivos(jsonImovel){
	var totalImoveis = 0;
	var totalImoveisAtivos = 0;
	for (var i = 0; i < jsonImovel.length; i++) {
	    imovel = jsonImovel[i];
	    totalImoveis++;
  		if (imovel.stImovel){
  			totalImoveisAtivos++;
  		}
	}
	$("#divTotalImoveis").html(totalImoveis);
	$("#divTotalImoveisAtivos").html(totalImoveisAtivos);
}

//Localizar Imóveis
function localizarImoveis(){
	var jsonRetorno = executarAjax("GET", "rest/imovel", "");
	return jsonRetorno;
}
</script>