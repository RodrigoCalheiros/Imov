package br.com.imov.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.imov.interfac.InterfaceDao;
import br.com.imov.modelo.Endereco;
import br.com.imov.modelo.sql.EnderecoSql;

public class EnderecoDao extends ConexaoBd implements InterfaceDao{
	
	private Endereco endereco;
	private EnderecoSql enderecoSql;

	public EnderecoDao(){
		this.endereco = new Endereco();
		this.enderecoSql = new EnderecoSql(this.endereco);
	}
	
	public EnderecoDao(Endereco endereco){
		this.endereco = endereco;
		this.enderecoSql = new EnderecoSql(this.endereco);
	}
	
	//Métodos Genéricos
	public int inserir(){
		int retorno = 0;
		retorno = inserir(enderecoSql.getSqlInserir());
		return retorno;
	}
	
	public boolean atualizar(){
		boolean retorno = false;
		retorno = atualizar(enderecoSql.getSqlAtualizar());
		return retorno;
	}
	
	public boolean excluir(){
		boolean retorno = false;
		retorno = excluir(enderecoSql.getSqlExcluir());
		return retorno;
	}
	
	public List<Map<String, Object>> localizar(){
		return localizar(enderecoSql.getSqlLocalizar());
	}

	public Map<String, Object> localizarById(){
		List<Map<String, Object>> resultList  = localizar(enderecoSql.getSqlLocalizarById());
		return resultList.get(0);
	}
	
	//Métodos Específicos
	public List<Endereco> localizarEnderecos(){
		List<Endereco> listEndereco = new ArrayList<Endereco>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList  = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listEndereco.add(setEndereco(row));
		}
		return listEndereco;
	}
	
	public Endereco localizarEnderecoById(){
		Map<String, Object> row =localizarById();
		return setEndereco(row);
	}
	
	public Endereco setEndereco(Map<String, Object> row){
		Endereco endereco = new Endereco(row);
		return endereco;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
