package br.com.imov.modelo.dao;

import java.util.List;
import java.util.Map;

import br.com.imov.interfac.InterfaceDao;
import br.com.imov.modelo.Usuario;
import br.com.imov.modelo.sql.UsuarioSql;

public class UsuarioDao extends ConexaoBd implements InterfaceDao{

	private Usuario usuario;
	private UsuarioSql usuarioSql;

	public UsuarioDao() {
		this.usuario = new Usuario();
		this.usuarioSql = new UsuarioSql(this.usuario);
	}
	
	public UsuarioDao(Usuario usuario) {
		this.usuario = usuario;
		this.usuarioSql = new UsuarioSql(this.usuario);		
	}
	
	public Usuario efetuarLogin() {
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizarUsuarioLogin();
		if (resultList.size() == 1){
			row = resultList.get(0);
			this.usuario = setUsuario(row);
		}
		else if (resultList.size() < 1){
			this.usuario = new Usuario();
		}
		else{
			//Criar uma alerte de problema de duplicidade de identificação
		}
		return this.usuario;
	}
	
	public List<Map<String, Object>> localizarUsuarioLogin() {
		return localizar(usuarioSql.getSqlEfetuarLogin());
		
	}
	
	public Usuario setUsuario(Map<String, Object> row){
		return new Usuario(row);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> localizarById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

}
