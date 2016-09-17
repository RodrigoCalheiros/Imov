package br.com.imov.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.imov.interfac.InterfaceControle;
import br.com.imov.modelo.Pais;
import br.com.imov.modelo.dao.PaisDao;

public class PaisControle implements InterfaceControle{
	
	private PaisDao paisDao;
	
	public PaisControle() {
		paisDao = new PaisDao();
	}
	
	public List<Pais> localizarPaises(){
		return paisDao.localizarPaises();
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
