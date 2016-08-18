<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
    	<div class="ibox float-e-margins">
        	<div class="ibox-title">
            	<h5>Cadastrar imóvel</h5>
			</div>
            <div class="ibox-content">
            	<form id="formImovelInserir" name="formImovelInserir" class="form-horizontal" action="javascript:cadastrarImovel()" method="POST">
            		<input type="hidden" id="idImovel" name="idImovel" value="0"/>
            		<input type="hidden" id="idEndereco" name="idEndereco" value="0"/>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Descrição do imóvel*</label>
                    	<div class="col-lg-9"><input type="text" id="dsImovel" name="dsImovel" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Rua*</label>
						<div class="col-lg-9"><input type="text" id="dsRua" name="dsRua" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Número*</label>
						<div class="col-lg-9"><input type="text" id="dsNumero" name="dsNumero" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Complemento</label>
						<div class="col-lg-9"><input type="text" id="dsComplemento" name="dsComplemento" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Bairro</label>
						<div class="col-lg-9"><input type="text" id="nmBairro" name="nmBairro" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">CEP</label>
						<div class="col-lg-9"><input type="number" id="nrCep" name="nrCep" class="form-control cep" ></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Coordenadas</label>
						<div class="col-lg-9"><input type="text" id="ptCoordenadas" name="ptCoordenadas" class="form-control"></div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3 control-label">Status*</label>
                    	<div class="col-lg-9">
                    		<select class="form-control m-b" id="stImovel" name="stImovel">
                                <option value="true" selected>Ativo</option>
                                <option value="false">Inativo</option>
                            </select>
                    	</div>
                    </div>
                    <div class="form-group">
                    	<label class="col-lg-3">*Campos obrigatórios</label>
                    	<div class="col-lg-9">
                    		<button class="btn btn-sm btn-primary" type="submit">Cadastrar</button>
                    	</div>
                    </div>
      			</form>
      			<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQTpXj82d8UpCi97wzo_nKXL7nYrd4G70"></script>
      			
                    <div class="ibox ">
                        <div class="ibox-title">
                            <h5>Google Maps Basic example</h5>
                        </div>
                        <div class="ibox-content">
                            
                            <div class="google-map" id="map1"></div>
                        </div>
                    </div>
               
      		</div>
 		</div>
    </jsp:body>
</t:genericpage>
<script>
$(document).ready(function(){
	validateForm();
	editarImovel(window.location);
	inicializarGoogleMaps();
});

function validateForm(){
	$("#formImovelInserir").validate({
        rules: {
        	dsImovel: {
                required: true,
                minlength: 1,
                maxlength: 45
            },
            dsRua: {
                required: true,
                minlength: 1,
                maxlength: 45
            },
            dsNumero: {
                required: true,
                minlength: 1,
                maxlength: 45
            },
            nrCep: {
                digits: true
            },
            stImovel: {
                required: true
            },
        }
    });
}

//Obter Imóvel para atualização
function editarImovel(url){
	var hashParametros = listarParametrosUrl(url);
	if (hashParametros != null){
		var jsonImovel = localizarImovelById(hashParametros.idImovel);
		montarFormImovel(jsonImovel);
	}
}

//Monta o formulário com os dados do imóvel
function montarFormImovel(imovel){
	$("#idImovel").val(imovel.idImovel);
	$("#dsImovel").val(imovel.dsImovel);
	$('#stImovel option[value=' + imovel.stImovel + ']').attr({ selected : "selected" });
	$("#idEndereco").val(imovel.endereco.idEndereco);
	$("#dsRua").val(imovel.endereco.dsRua);
    $("#dsNumero").val(imovel.endereco.dsNumero);
    $("#dsComplemento").val(imovel.endereco.dsComplemento);
    $("#nmBairro").val(imovel.endereco.nmBairro);
    $("#nrCep").val(imovel.endereco.nrCep);
    $("#ptCoordenadas").val(imovel.endereco.ptCoordenadas);
}

//Localizar Imovel por id
function localizarImovelById(idImovel){
	var jsonRetorno = executarAjax("GET", "imovel/" + idImovel, "");
	return jsonRetorno;
}

//Decide se será cadastrado um imóvel novo ou se irá atualizar um imóvel já cadastrado
function cadastrarImovel(){
	if ($("#idImovel").val() == 0){
		inserirImovel();
	}
	else{
		atualizarImovel();
	}
}

//Inserir Imóvel
function inserirImovel(){
	var jsonRetorno = executarAjax("POST", "imovel", getJsonImovel());
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	if ($("#tpMensagem").val() != "Error"){
		$("#formImovelInserir")[0].reset();
	}
}

//Atualizar Imóvel
function atualizarImovel(idImovel){
	var jsonRetorno = executarAjax("PUT", "imovel", getJsonImovel());
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	if ($("#tpMensagem").val() != "Error"){
		$("#formImovelInserir")[0].reset();
	}
}

//Json Imóvel
function getJsonImovel(){
	var paramNrCep = 0;
	if ($("#nrCep").val() != ""){
		paramNrCep = parseInt($("#nrCep").val());
	}
	var jsonConteudo = {idImovel: $("#idImovel").val(),
						dsImovel: $("#dsImovel").val(),
						//stImovel: parseInt($("#stImovel").val()),
						stImovel: $("#stImovel").val(),
            			endereco: {idEndereco: parseInt($("#idEndereco").val()), 
            				   	   dsRua: $("#dsRua").val(),
            		        	   dsNumero: $("#dsNumero").val(),
            		          	   dsComplemento: $("#dsComplemento").val(),
            		           	   nmBairro: $("#nmBairro").val(),
            		               nrCep: paramNrCep,
            		               ptCoordenadas: $("#ptCoordenadas").val()
            				      }
        	           };
	return jsonConteudo;
}

function inicializarGoogleMaps(){
	  // When the window has finished loading google map
    google.maps.event.addDomListener(window, 'load', carregarParametrosGoogleMaps(-10.923194, -37.049741));
}

function carregarParametrosGoogleMaps(latitude, longitude){
	 var myLatLng = {lat: latitude, lng: longitude};

	 // Options for Google map
    // More info see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions1 = {
        zoom: 12,
        center: myLatLng,
        // Style for Google Maps
        styles: [{"featureType":"water","stylers":[{"saturation":43},{"lightness":-11},{"hue":"#0088ff"}]},{"featureType":"road","elementType":"geometry.fill","stylers":[{"hue":"#ff0000"},{"saturation":-100},{"lightness":99}]},{"featureType":"road","elementType":"geometry.stroke","stylers":[{"color":"#808080"},{"lightness":54}]},{"featureType":"landscape.man_made","elementType":"geometry.fill","stylers":[{"color":"#ece2d9"}]},{"featureType":"poi.park","elementType":"geometry.fill","stylers":[{"color":"#ccdca1"}]},{"featureType":"road","elementType":"labels.text.fill","stylers":[{"color":"#767676"}]},{"featureType":"road","elementType":"labels.text.stroke","stylers":[{"color":"#ffffff"}]},{"featureType":"poi","stylers":[{"visibility":"off"}]},{"featureType":"landscape.natural","elementType":"geometry.fill","stylers":[{"visibility":"on"},{"color":"#b8cb93"}]},{"featureType":"poi.park","stylers":[{"visibility":"on"}]},{"featureType":"poi.sports_complex","stylers":[{"visibility":"on"}]},{"featureType":"poi.medical","stylers":[{"visibility":"on"}]},{"featureType":"poi.business","stylers":[{"visibility":"simplified"}]}]
    };

    // Get all html elements for map
    var mapElement1 = document.getElementById('map1');

    // Create the Google Map using elements
    var map1 = new google.maps.Map(mapElement1, mapOptions1);
    
    var marker = new google.maps.Marker({
        position: myLatlng,
        title:"Hello World!",
        map: map1,
    });

    // To add the marker to the map, call setMap();
    marker.setMap(mapElement1);
}

</script>
              