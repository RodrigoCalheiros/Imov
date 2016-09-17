//Localizar paises
function localizarPaises(){
	var jsonCidade = executarAjax("GET", "rest/pais", "");
	return jsonCidade;
}