<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:loginpage>
</t:loginpage>
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