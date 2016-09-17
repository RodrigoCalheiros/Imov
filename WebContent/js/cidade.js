//Localizar cidades
function localizarCidades(){
	var jsonCidade = executarAjax("GET", "rest/cidade", "");
	return jsonCidade;
}

//Localizar cidades por estado
function localizarCidadesByIdEstado(idEstado){
	var jsonCidade = executarAjax("GET", "rest/cidade/idEstado/" + idEstado, "");
	return jsonCidade;
}