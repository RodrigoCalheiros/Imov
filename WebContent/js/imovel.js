//Inserir Imóvel
function inserirImovel(jsonImovel){
	var jsonRetorno = executarAjax("POST", "rest/imovel", jsonImovel);
	return jsonRetorno;
}

//Atualizar Imóvel
function atualizarImovel(jsonImovel){
	var jsonRetorno = executarAjax("PUT", "rest/imovel", jsonImovel);
	return jsonRetorno;
}

//Excluir imóvel
function excluirImovel(jsonImovel){
	var jsonRetorno = executarAjax("DELETE", "rest/imovel", jsonImovel);
	return jsonRetorno;
}

//Localizar Imóveis
function localizarImoveis(){
	var jsonImoveis = executarAjax("GET", "rest/imovel", "");
	return jsonImoveis;
}

//Localizar Imovel por id
function localizarImovelById(idImovel){
	var jsonImovel = executarAjax("GET", "rest/imovel/" + idImovel, "");
	return jsonImovel;
}

//Monta json Imovel
function getJsonImovel(idImovel, dsImovel, stImovel, endereco){
	var jsonImovel = {idImovel: idImovel,
					  dsImovel: dsImovel,
					  stImovel: stImovel,
            		  endereco: endereco
        	         };
	return jsonImovel;
}