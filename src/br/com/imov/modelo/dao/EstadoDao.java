package br.com.imov.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.imov.interfac.InterfaceDao;
import br.com.imov.modelo.Estado;
import br.com.imov.modelo.sql.EstadoSql;

public class EstadoDao extends ConexaoBd implements InterfaceDao{
	
	private Estado estado;
	private EstadoSql estadoSql;

	public EstadoDao() {
		
		this.estado = new Estado();
		this.estadoSql = new EstadoSql(this.estado);
	}
	
	//Métodos Específicos
	public List<Estado> localizarEstados(){
		List<Estado> listEstado = new ArrayList<Estado>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listEstado.add(setEstado(row));
		}
		return listEstado;
	}
	
	public List<Estado> localizarEstadosByIdPais(int idPais){
		List<Estado> listEstado = new ArrayList<Estado>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizarByIdPais(idPais);
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listEstado.add(setEstado(row));
		}
		return listEstado;
	}
	
	public Estado setEstado(Map<String, Object> row){
		return new Estado(row);
	}
	
	public Estado getEstado() {
		return estado;
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
		return localizar(estadoSql.getSqlLocalizar());
		
	}

	@Override
	public Map<String, Object> localizarById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Map<String, Object>> localizarByIdPais(int idPais) {
		return localizar(estadoSql.getSqlLocalizarEstadosByIdPais(idPais));
	}
}
