package br.com.imov.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.imov.modelo.Endereco;
import br.com.imov.modelo.Imovel;
import br.com.imov.modelo.interfac.InterfaceDao;
import br.com.imov.modelo.sql.ImovelSql;

public class ImovelDao extends ConexaoBd implements InterfaceDao{
	
	private Imovel imovel;
	private ImovelSql imovelSql;

	public ImovelDao() {
		this.imovel = new Imovel();
		this.imovelSql = new ImovelSql(this.imovel);
	}
	
	public ImovelDao(Imovel imovel) {
		this.imovel = imovel;
		this.imovelSql = new ImovelSql(this.imovel);		
	}
	
	//Métodos Genéricos
	public int inserir() {
		int retorno = 0;
		retorno = inserir(imovelSql.getSqlInserir());
		return retorno;
	}

	public boolean atualizar() {
		boolean retorno = false;
		retorno = atualizar(imovelSql.getSqlAtualizar());
		return retorno;
	}

	public boolean excluir() {
		boolean retorno = false;
		retorno = excluir(imovelSql.getSqlExcluir());
		return retorno;
	}

	public List<Map<String, Object>> localizar() {
		return localizar(imovelSql.getSqlLocalizar());
		
	}

	public Map<String, Object> localizarById() {
		List<Map<String, Object>> resultList  = localizar(imovelSql.getSqlLocalizarById());
		return resultList.get(0);
	}
	
	//Métodos Específicos
	public List<Imovel> localizarImoveis(){
		List<Imovel> listImovel = new ArrayList<Imovel>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listImovel.add(setImovel(row));
		}
		return listImovel;
	}
	
	public Imovel localizarImovelById(){
		Map<String, Object> row = localizarById();
		return setImovel(row);
	}
	
	public Imovel setImovel(Map<String, Object> row){
		Imovel imovel = new Imovel();
		Endereco endereco = new Endereco();
		endereco.setEndereco((Integer) row.get("idEndereco"), 
										(String) row.get("dsRua"),
										(String) row.get("dsNumero"),
										(String) row.get("dsComplemento"),
										(String) row.get("nmBairro"),
										(Integer) row.get("nrCep"),
										(String) row.get("ptCoordenadas"));
		imovel.setImovel((Integer) row.get("idImovel"), 
								  (String) row.get("dsImovel"), 
								  (Integer) row.get("stImovel"), 
								  endereco);
		return imovel;
	}
	
	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}
}
