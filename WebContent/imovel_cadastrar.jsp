<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
    	<div class="row">
    		<div class="col-md-12">
		    	<div class="ibox float-e-margins">
		        	<div class="ibox-title">
		            	<h5>Cadastro de Imóvel</h5>
					</div>
		            <div class="ibox-content">
		            	<form id="formImovelInserir" name="formImovelInserir" class="form-horizontal" action="" method="POST">
			            	<input type="hidden" id="idImovel" name="idImovel" value="0"/>
			            	<input type="hidden" id="idEndereco" name="idEndereco" value="0"/>
			                <div class="form-group">
			                    <label class="col-lg-2 control-label">Descrição do imóvel*</label>
			                   	<div class="col-lg-10"><input type="text" id="dsImovel" name="dsImovel" class="form-control"></div>
			                </div>    
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Status*</label>
			                   	<div class="col-lg-10">
			                   		<select class="form-control m-b" id="stImovel" name="stImovel">
			                	        <option value="true" selected>Ativo</option>
			                            <option value="false">Inativo</option>
			                        </select>
			                    </div>
			           		</div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Rua*</label>
								<div class="col-lg-10"><input type="text" id="dsRua" name="dsRua" class="form-control"></div>
			          		</div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Número*</label>
								<div class="col-lg-10"><input type="text" id="dsNumero" name="dsNumero" class="form-control"></div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Complemento</label>
								<div class="col-lg-10"><input type="text" id="dsComplemento" name="dsComplemento" class="form-control"></div>
			                </div>
			                <div class="form-group">
			                  	<label class="col-lg-2 control-label">Bairro</label>
								<div class="col-lg-10"><input type="text" id="nmBairro" name="nmBairro" class="form-control"></div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">CEP</label>
								<div class="col-lg-10"><input type="number" id="nrCep" name="nrCep" class="form-control cep" ></div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">País</label>
								<div class="col-lg-10"><select id="idPais" name="idPais" class="form-control m-b" onchange="eventoLocalizarEstadosByIdPais()"></select></div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Estado</label>
								<div class="col-lg-10"><select id="idEstado" name="idEstado" class="form-control m-b"></select></div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2 control-label">Cidade</label>
								<div class="col-lg-10"><select id="idCidade" name="idCidade" class="form-control m-b"></select></div>
			                </div>
			                <div class="form-group">
			                  	<label class="col-lg-2 control-label">Latitude</label>
								<div class="col-lg-10"><input type="number" id="nrLatitude" name="nrLatitude" class="form-control" onblur="javascript:atualizarParametrosGoogleMaps()"></div>
			                </div>
			                <div class="form-group">
			                  	<label class="col-lg-2 control-label">Longitude</label>
								<div class="col-lg-10"><input type="number" id="nrLongitude" name="nrLongitude" class="form-control" onblur="javascript:atualizarParametrosGoogleMaps()"></div>
			                </div>
			                <div class="form-group">
			               	    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDQTpXj82d8UpCi97wzo_nKXL7nYrd4G70"></script>
			                	<label class="col-lg-2 control-label">Mapa</label>
								<div class="col-lg-10">
									<div class="google-map" id="mapa"></div>
								</div>
			                </div>
			                <div class="form-group">
			                   	<label class="col-lg-2">*Campos obrigatórios</label>
			                   	<div class="col-lg-10">
			                   		<button class="btn btn-sm btn-primary" type="submit" formaction="javascript:eventoSalvarImovelRedirectLocalizarImovel()">Salvar</button>
			                   		<button class="btn btn-sm btn-white" type="submit" formaction="javascript:eventoSalvarImovel()">Salvar e cadastrar outro imóvel</button>
			                   		<button class="btn btn-sm btn-white" type="button" onclick="eventoCancelarCadastroImovel()">Cancelar</button>
			                   	</div>
			                </div>			
		      			</form>
		      		</div>
		 		</div>
 			</div>
 		</div>
    </jsp:body>
</t:genericpage>
<script src="js/imovel.js" language="JavaScript"></script>
<script src="js/endereco.js" language="JavaScript"></script>
<script src="js/pais.js" language="JavaScript"></script>
<script src="js/estado.js" language="JavaScript"></script>
<script src="js/cidade.js" language="JavaScript"></script>
<script src="js/imovGoogleMaps.js" language="JavaScript"></script>
<script>
$(document).ready(function(){
	eventoLocalizarPaises();
	validateForm();
	obterImovelByUrl(window.location);
	inicializarGoogleMapsCadastrarImovel();
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

function inicializarGoogleMapsCadastrarImovel(){
	var nrLatitude = $("#nrLatitude").val();
	var nrLongitude = $("#nrLongitude").val();
	var dsMarcador = $("#dsImovel").val();
	var dsEndereco = $("#dsRua").val() + ", " + $("#dsNumero").val() + " " + $("#dsComplemento").val();
	var nrCep = $("#nrCep").val();
	var flClick = true;
	inicializarGoogleMaps(nrLatitude, nrLongitude, dsMarcador, dsEndereco, nrCep, flClick);
}

//Obter Imóvel para atualização
function obterImovelByUrl(url){
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
    $("#nrLatitude").val(imovel.endereco.nrLatitude);
    $("#nrLongitude").val(imovel.endereco.nrLongitude);
}

function eventoCancelarCadastroImovel(){
	redirectLocalizarImovel();
}

function redirectLocalizarImovel(){
	window.location.href = "imovel_localizar.jsp";
}

function eventoSalvarImovelRedirectLocalizarImovel(){
	eventoSalvarImovel();
	redirectLocalizarImovel();
}

function eventoSalvarImovel(){
	var idEndereco = $("#idEndereco").val();
	var dsRua = $("#dsRua").val();
	var dsNumero = $("#dsNumero").val();
	var dsComplemento = $("#dsComplemento").val();
	var nmBairro = $("#nmBairro").val();
	var nrCep = $("#nrCep").val();
	var nrLatitude = $("#nrLatitude").val();
	var nrLongitude = $("#nrLongitude").val();
	var jsonEndereco = getJsonEndereco(idEndereco, dsRua, dsNumero, dsComplemento, nmBairro, nrCep, nrLatitude, nrLongitude);
	
	var idImovel = $("#idImovel").val();
	var dsImovel = $("#dsImovel").val();
	var stImovel = $("#stImovel").val();
	var jsonImovel = getJsonImovel(idImovel, dsImovel, stImovel, jsonEndereco);
	
	if ($("#idImovel").val() == 0){
		inserirImovel(jsonImovel);
	}
	else{
		atualizarImovel(jsonImovel);
	}
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	if ($("#tpMensagem").val() != "Error"){
		$("#formImovelInserir")[0].reset();
	}
}

function eventoLocalizarPaises(){
	var jsonPaises = localizarPaises();
	var option;
	$("#idPais").empty();
	for (var i = 0; i < jsonPaises.length; i++){
		option = new Option(jsonPaises[i].nmPais, jsonPaises[i].idPais);
		$('#idPais').append(option);
		if (jsonPaises[i].nmPais == 'Brasil'){
			$("#idPais option[value='" + jsonPaises[i].idPais + "']").attr('selected','selected');
		}
	}
	eventoLocalizarEstadosByIdPais();
}

function eventoLocalizarEstadosByIdPais(){
	var idPais = $("#idPais").val();
	var jsonEstados = localizarEstadosByIdPais(idPais);
	var option;
	$("#idEstado").empty();
	for (var i = 0; i < jsonEstados.length; i++){
		option = new Option(jsonEstados[i].dsEstado, jsonEstados[i].idEstado);
		$('#idEstado').append(option);
	}
}

function eventoLocalizarByIdEstado(){
	var idEstado = $("#idEstado").val();
	var jsonCidades = localizarCidadesByEstados(idEstado);
	var option;
	$("#idCidade").empty();
	for (var i = 0; i < jsonCidades.length; i++){
		option = new Option(jsonCidades[i].dsCidade, jsonCidades[i].idCidade);
		$('#idCidade').append(option);
	}
}
</script>
              