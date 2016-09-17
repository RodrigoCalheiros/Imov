<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:body>
    	<div class="row">
        	<div class="col-md-12">
			    <div class="ibox float-e-margins">
			        <div class="ibox-title">
			            <h5>Imóvel</h5>
			        </div>
			        <div class="ibox-content">
			        	<div class="row">
			        		<div class="col-sm-9 m-b-xs">
			        	    	<button type="button" class="btn btn-sm btn-primary" onclick="eventoRedirecionarCadastrarImovel()"><i class="fa fa-plus-square"></i> Novo Imóvel</button>
			        	    	<button type="button" class="btn btn-sm btn-white" onclick="eventoExcluirImoveis()"><i class="fa fa-trash-o"></i> Excluir</button>
			         		</div>
			        		<div class="col-sm-3">
			        			<div class="input-group">
			        				<input type="text" class="input-sm form-control">
			        				<span class="input-group-btn">
			        					<button type="button" class="btn btn-sm btn-white"><i class="fa fa-search"></i> Buscar</button>
			        				</span>
			        			</div>
			        		</div>
			        	</div>
			            <div class="table-responsive">
					        <table id="tb_imovel" name="tb_imovel" class="table table-striped table-bordered table-hover dataTables-example" >
					        <thead>
					        <tr>
					        	<th><input type='checkbox' name="checkbox_todos_imoveis" id="checkbox_todos_imoveis" onclick="selecionaTodosImoveis()"></th>
					        	<th>Descrição do imóvel</th>
					            <th>Rua</th>
					            <th>Número</th>
					            <th>Complemento</th>
					            <th>Bairro</th>
					            <th>CEP</th>
					            <th>Latitude</th>
					            <th>Longitude</th>
					            <th>Status</th>
					        </tr>
					        </thead>
					        <tbody>
					        </tbody>
					        </table>
			            </div>
			
			        </div>
			    </div>
	    	</div>
	    </div>
    </jsp:body>
</t:genericpage>
<script src="js/imovel.js" language="JavaScript"></script>
<script src="js/endereco.js" language="JavaScript"></script>
<script>
$(document).ready(function () {
	eventoLocalizarImoveis();
});

//Novo Imóvel
function eventoRedirecionarCadastrarImovel(){
	window.location.href = "imovel_cadastrar.jsp";
}

// Atualizar imóvel
function eventoRedirecionarAtualizarImovel(idImovel){
	window.location.href = "imovel_cadastrar.jsp?idImovel=" + idImovel;
}

//Seleciona todos os imóveis
function eventoSelecionaTodosImoveis(){
	var checkboxImovel = $('input:checkbox[name=checkbox_imovel]');
    if(checkboxImovel.length > 0){
    	checkboxImovel.each(function(){
    		 if ($("#checkbox_todos_imoveis").prop( "checked")){
    			 $(this).prop("checked", true);
    		 }
    		 else{
    			 $(this).prop("checked", false);
    		 }
        });
    } 
}

//Seleciona imóvel
function eventoLocalizarImoveis(){
	var jsonImoveis = localizarImoveis();
	montarGridImovel(jsonImoveis);
}

//Excluir Imóveis
function eventoExcluirImoveis(){
	var checkboxChecked = $('input:checkbox[name=checkbox_imovel]:checked');
    if(checkboxChecked.length > 0){
    	var idImovel;
    	var idEndereco;
       	checkboxChecked.each(function(){
           	idImovel = $(this).val().split("|")[0];
           	idEndereco = $(this).val().split("|")[1];
           	eventoExcluirImovel(idImovel, idEndereco);
        });
    } 
}

//Excluir imóvel
function eventoExcluirImovel(idImovel, idEndereco){
	var idEndereco = idEndereco;
	var dsRua = "";
	var dsNumero = "";
	var dsComplemento = "";
	var nmBairro = "";
	var nrCep = "";
	var nrLatitude = "";
	var nrLongitude = "";
	var jsonEndereco = getJsonEndereco(idEndereco, dsRua, dsNumero, dsComplemento, nmBairro, nrCep, nrLatitude, nrLongitude);
	
	var idImovel =idImovel;
	var dsImovel = "";
	var stImovel = "";
	var jsonImovel = getJsonImovel(idImovel, dsImovel, stImovel, jsonEndereco);

	var jsonRetorno = excluirImovel(jsonImovel);
	dispararMensagem($("#tpMensagem").val(), $("#dsMensagem").val());
	eventoLocalizarImoveis();
}

//Monta grid de imóveis
function montarGridImovel(jsonImoveis){
	var gridImovel = "";
	var imovel;
	var endereco;
	for (var i = 0; i < jsonImoveis.length; i++) {
	    imovel = jsonImoveis[i];
  		endereco = imovel.endereco;
  		
	    gridImovel += "<tr class='gradeC'>";
	    gridImovel += "<td><input type='checkbox' id='checkbox_imovel' name='checkbox_imovel' value=' " + imovel.idImovel + "|" + endereco.idEndereco + "'></td>";
	    gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + imovel.dsImovel + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.dsRua + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.dsNumero + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.dsComplemento + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.nmBairro + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.nrCep + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.nrLatitude + "</td>";
  		gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + endereco.nrLongitude + "</td>";
	    gridImovel += "<td onclick='eventoRedirecionarAtualizarImovel(" + imovel.idImovel + ")'>" + conteudoStatus(imovel.stImovel) + "</td>";
  		gridImovel += "</tr>";
	}
	
	$('#tb_imovel > tbody').html(gridImovel);
}

</script>