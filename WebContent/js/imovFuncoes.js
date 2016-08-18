$(document).ready(function(){
	setMask();
});

function executarAjax(metodo, url, json){
	var retorno;
	$.ajax({
		contentType: "application/json; charset=utf-8",
	    type: metodo,
	    url: "rest/" + url,
	    async: false,
	    dataType: "json",
	    data: JSON.stringify(json),
	    success: function(jsonRetorno){
	    	retorno = jsonRetorno;
	    	if (metodo.toUpperCase() != "GET"){
	    		$("#tpMensagem").val(retorno.tpMensagem);
	    		$("#dsMensagem").val(retorno.dsMensagem);
	    	}
	    },
	    error: function(data){
	        // aqui você manipula os dados para agir de acordo com a resposta do ajax
	    },
	    complete: function(data){
	    	// aqui você manipula os dados para agir de acordo com a resposta do ajax
	    }
	});
	return retorno;
}

function setRecurso(metodo, url, jsonModelo){
	$("#dsAjaxMetodo").val(metodo);
	$("#dsAjaxUrl").val(url);
	$("#dsAjaxModelo").val(jsonModelo);
}

function dispararMensagem(tpMensagem, dsMensagem){
	toastr[tpMensagem](dsMensagem)	
	toastr.options = {
				"closeButton": true,
				"debug": false,
				"progressBar": true,
				"preventDuplicates": false,
				"positionClass": "toast-top-right",
				"onclick": null,
				"showDuration": "400",
				"hideDuration": "1000",
				"timeOut": "7000",
				"extendedTimeOut": "1000",
				"showEasing": "swing",
				"hideEasing": "linear",
				"showMethod": "fadeIn",
				"hideMethod": "fadeOut"
	}	
}

function listarParametrosUrl(url){
	var parametrosDaUrl = url.toString().split("?")[1];
	if (parametrosDaUrl != null){
		var listaDeParametros = parametrosDaUrl.split("&");
		var hash = {};
		for(var i = 0; i < listaDeParametros.length; i++){
	    	var parametro = listaDeParametros[i].split("=");
	    	var chave = parametro[0];
	    	var valor = parametro[1];
	    	hash[chave] = valor;
		}
	}
	return hash;
}

function setMask(){
	//$(".cep").format("99.999-999");
}
