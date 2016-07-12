<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:body>
    	<div class="ibox float-e-margins">
        	<div class="ibox-title">
            	<h5>Cadastrar imóvel</h5>
			</div>
            <div class="ibox-content">
            	<form id="formImovelInserir" name="formImovelInserir" class="form-horizontal" action="javascript:inserirImovel()" method="post">
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
                                <option value="1" selected>Ativo</option>
                                <option value="0">Inativo</option>
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
      		</div>
 		</div>
    </jsp:body>
</t:genericpage>
<script>

$(document).ready(function(){
	validateForm();
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

function inserirImovel(){
	setRecurso("Imovel", conteudoRecursoAcao(1), "");
	var jsonRecurso = getJsonRecurso();
	var jsonConteudo = getJsonInserirImovel();
	var jsonRetorno = executarAjax(jsonRecurso, jsonConteudo);
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	$("#formImovelInserir")[0].reset();
}

function atualizarImovel(idImovel){
	setRecurso("Imovel", conteudoRecursoAcao(3), "");
	var jsonRecurso = getJsonRecurso();
	var jsonConteudo = getJsonAtualizarImovel(idImovel);
	var jsonRetorno = executarAjax(jsonRecurso, jsonConteudo);
}

function getJsonInserirImovel(){
	var paramNrCep = 0;
	if ($("#nrCep").val() != ""){
		paramNrCep = parseInt($("#nrCep").val());
	}
	var jsonConteudo = {idImovel: $("#idImovel").val(),
						dsImovel: $("#dsImovel").val(),
						stImovel: parseInt($("#stImovel").val()),
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
</script>