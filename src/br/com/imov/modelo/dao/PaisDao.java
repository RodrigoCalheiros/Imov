package br.com.imov.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.imov.interfac.InterfaceDao;
import br.com.imov.modelo.Pais;
import br.com.imov.modelo.sql.PaisSql;

public class PaisDao extends ConexaoBd implements InterfaceDao{
	
	private Pais pais;
	private PaisSql paisSql;

	public PaisDao() {
		
		this.pais = new Pais();
		this.paisSql = new PaisSql(this.pais);
	}
	
	//Métodos Específicos
	public List<Pais> localizarPaises(){
		List<Pais> listPais = new ArrayList<Pais>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listPais.add(setPais(row));
		}
		return listPais;
	}
	
	public Pais setPais(Map<String, Object> row){
		return new Pais(row);
	}
	
	public Pais getEstado() {
		return pais;
	}

	//Métodos Genéricos
	@Override
	public int inserir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean atualizar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Map<String, Object>> localizar() {
		return localizar(paisSql.getSqlLocalizar());
		
	}

	@Override
	public Map<String, Object> localizarById() {
		// TODO Auto-generated method stub
		return null;
	}
}
