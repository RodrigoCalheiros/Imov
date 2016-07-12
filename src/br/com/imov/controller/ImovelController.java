package br.com.imov.controller;

import java.util.List;

import br.com.imov.dao.EnderecoDao;
import br.com.imov.dao.ImovelDao;
import br.com.imov.modelo.Imovel;

public class ImovelController {
	
	private ImovelDao imovelDao;
	private EnderecoDao enderecoDao;
	
	public ImovelController() {
		 imovelDao = new ImovelDao();
		 enderecoDao = new EnderecoDao();
	}
	
	public int inserir(Imovel imovel){
		imovelDao = new ImovelDao(imovel);
	    enderecoDao = new EnderecoDao(imovel.getEndereco());
		
		//Fazer transação
		int idEndereco = enderecoDao.inserir();
		imovel.getEndereco().setIdEndereco(idEndereco);
		
		int idImovel = imovelDao.inserir();
		imovel.setIdImovel(idImovel);
		
		return imovel.getIdImovel();
	}
	
	public boolean atualizar(Imovel imovel){
		imovelDao = new ImovelDao(imovel);
		enderecoDao = new EnderecoDao(imovel.getEndereco());
		
		//Criar regra de transação e retorno
		boolean retorno = enderecoDao.atualizar();
		retorno = imovelDao.atualizar();
		
		return retorno;
	}
	
	public boolean excluir(Imovel imovel){
		imovelDao = new ImovelDao(imovel);
		enderecoDao = new EnderecoDao(imovel.getEndereco());
		
		//Criar regra de transação e retorno
		boolean retorno = imovelDao.excluir();
		retorno = enderecoDao.excluir();
		
		return retorno;
	}
	
	public List<Imovel> localizarImoveis(){
		return imovelDao.localizarImoveis();
	}
	
	public Imovel localizarImovelById(Imovel imovel){
		imovelDao = new ImovelDao(imovel);
		return imovelDao.localizarImovelById();
	}

}
