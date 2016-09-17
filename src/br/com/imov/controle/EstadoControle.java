package br.com.imov.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.imov.interfac.InterfaceControle;
import br.com.imov.modelo.Estado;
import br.com.imov.modelo.dao.EstadoDao;

public class EstadoControle implements InterfaceControle{
	
	private EstadoDao estadoDao;
	
	public EstadoControle() {
		estadoDao = new EstadoDao();
	}
	
	public List<Estado> localizarEstados(){
		return estadoDao.localizarEstados();
	}
	
	public List<Estado> localizarEstadosByIdPais(int idPais){
		return estadoDao.localizarEstadosByIdPais(idPais);
	}
	
	@Override
	public int inserir() throws SQLException {
		// TODO Auto-generated method stub
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
