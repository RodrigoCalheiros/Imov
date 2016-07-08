package br.com.imov.controller;

import java.util.List;

import br.com.imov.dao.ImovelDao;
import br.com.imov.modelo.Imovel;

public class ImovelController {
	
	public ImovelController() {
		
	}
	
	public List<Imovel> localizarImoveis(){
		ImovelDao imovelDao = new ImovelDao();
		return imovelDao.localizarImovel();
	}

}
