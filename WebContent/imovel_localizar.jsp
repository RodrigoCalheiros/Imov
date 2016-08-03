<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
	    <div class="ibox float-e-margins">
	        <div class="ibox-title">
	            <h5>Imóveis Cadastrados</h5>
	             <div class="ibox-tools">
	                 <a href="javascript:obterImoveis()">
	                     <i class="fa fa-refresh"></i>
	                 </a>
	             </div>
	        </div>
	        <div class="ibox-content">
	            <div class="table-responsive">
			        <table id="tb_imovel" name="tb_imovel" class="table table-striped table-bordered table-hover dataTables-example" >
			        <thead>
			        <tr>
			        	<th>Descrição do imóvel</th>
			            <th>Rua</th>
			            <th>Número</th>
			            <th>Complemento</th>
			            <th>Bairro</th>
			            <th>CEP</th>
			            <th>Coordenadas</th>
			            <th>Status</th>
			            <th>Editar</th>
			            <th>Excluir</th>
			        </tr>
			        </thead>
			        <tbody>
			        </tbody>
			        </table>
	            </div>
	
	        </div>
	    </div>
    </jsp:body>
</t:genericpage>
<script>
$(document).ready(function () {
	localizarImoveis();
});

//Localizar Imóveis
function localizarImoveis(){
	var jsonRetorno = executarAjax("GET", "imovel", "");
	montarGridImovel(jsonRetorno);
}

function montarGridImovel(jsonImovel){
	var gridImovel = "";
	var imovel;
	var endereco;
	for (var i = 0; i < jsonImovel.length; i++) {
	    imovel = jsonImovel[i];
  		endereco = imovel.endereco;
	    gridImovel += " <tr class='gradeC'>";
	    gridImovel += "<td>" + imovel.dsImovel + "</td>";
  		gridImovel += "<td>" + endereco.dsRua + "</td>";
  		gridImovel += "<td>" + endereco.dsNumero + "</td>";
  		gridImovel += "<td>" + endereco.dsComplemento + "</td>";
  		gridImovel += "<td>" + endereco.nmBairro + "</td>";
  		gridImovel += "<td>" + endereco.nrCep + "</td>";
  		gridImovel += "<td>" + endereco.ptCoordenadas + "</td>";
	    gridImovel += "<td>" + conteudoStatus(imovel.stImovel) + "</td>";
	    gridImovel += "<td class='center'> <a href=javascript:atualizarImovel(" + imovel.idImovel + ")><i class='fa fa-edit'></i></a></td>";
  		gridImovel += "<td class='center'> <a href=javascript:excluirImovel(" + imovel.idImovel + "," + endereco.idEndereco + ")><i class='fa fa-times'></i></a></td>";
  		gridImovel += "</tr>";
	}
	$('#tb_imovel > tbody').html(gridImovel);
}

//Localizar Imovel por Id (Sem funcionar)
function localizarImovelById(idImovel){
	//redirecionar passando o id
	setRecurso("Imovel", conteudoRecursoAcao(5), "imovel_cadastrar.jsp");
	var jsonRecurso = getJsonRecurso();
	var jsonConteudo = getJsonlocalizarImovelById(idImovel);
	var jsonRetorno = executarAjax(jsonRecurso, jsonConteudo);
}

function getJsonlocalizarImovelById(idImovel){
	var jsonConteudo = {idImovel: idImovel};
	return jsonConteudo;
}

//Excluir imóvel
function excluirImovel(idImovel, idEndereco){
	var jsonModelo = getJsonExcluirImovel(idImovel, idEndereco);
	var jsonRetorno = executarAjax("DELETE", "imovel", jsonModelo);
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	localizarImoveis();
}

function getJsonExcluirImovel(idImovel, idEndereco){
	var jsonConteudo = {idImovel: idImovel,
						endereco: {
							idEndereco : idEndereco
						}};
	return jsonConteudo;
}



</script>