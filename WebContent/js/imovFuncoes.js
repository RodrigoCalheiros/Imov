$(document).ready(function(){
	setMask();
});

function executarAjax(){
	var retorno;
	$.ajax({
	    type: $("#dsAjaxMetodo").val(),
	    url: "rest/" + $("#dsAjaxUrl").val(),
	    contentType: "application/json; charset=utf-8",
	    async: false,
	    dataType: "json",
	    data: JSON.stringify($("#dsAjaxModelo").val()),
	    success: function(jsonRetorno){
	    	retorno = jsonRetorno;
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

function dispararMensagem(jsonResponse){
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
	toastr[jsonResponse.tpMensagem](jsonResponse.dsMensagem)
}

function setMask(){
	//$(".cep").format("99.999-999");
}
