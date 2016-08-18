package br.com.imov.controle;

import java.sql.SQLException;

import br.com.imov.interfac.InterfaceControle;

import br.com.imov.modelo.Usuario;

import br.com.imov.modelo.dao.ConexaoBd;
import br.com.imov.modelo.dao.UsuarioDao;

public class UsuarioControle implements InterfaceControle{

	private UsuarioDao usuarioDao;
	
	public UsuarioControle() {
		usuarioDao = new UsuarioDao();
	}
	
	public UsuarioControle(Usuario usuario) { 
		usuarioDao = new UsuarioDao(usuario);
	}
	
	public Usuario efetuarLogin() {
		Usuario usuario = usuarioDao.efetuarLogin();
		return usuario;
	}
	
	
	@Override
	public int inserir(){
		return 0;
	}

	@Override
	public boolean atualizar() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
