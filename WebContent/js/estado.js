//Localizar estados
function localizarEstados(){
	var jsonCidade = executarAjax("GET", "rest/estado", "");
	return jsonCidade;
}

//Localizar estados pais
function localizarEstadosByIdPais(idPais){
	var jsonCidade = executarAjax("GET", "rest/estado/idPais/" + idPais, "");
	return jsonCidade;
}