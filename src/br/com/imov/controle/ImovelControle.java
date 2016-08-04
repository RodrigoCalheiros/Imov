package br.com.imov.controle;

import java.sql.SQLException;
import java.util.List;

import com.sun.corba.se.impl.ior.GenericTaggedComponent;

import br.com.imov.modelo.Imovel;
import br.com.imov.modelo.dao.ConexaoBd;
import br.com.imov.modelo.dao.EnderecoDao;
import br.com.imov.modelo.dao.ImovelDao;

public class ImovelControle {
	
	private ImovelDao imovelDao;
	private EnderecoDao enderecoDao;
	
	public ImovelControle() {
		 imovelDao = new ImovelDao();
		 enderecoDao = new EnderecoDao();
	}
	
	public ImovelControle(Imovel imovel) {
		 imovelDao = new ImovelDao(imovel);
		 enderecoDao = new EnderecoDao(imovel.getEndereco());
	}
	
	public int inserir() throws SQLException{
		//Criar regra de transação e retorno
	
		
		//Inserir Endereço
		int idEndereco = enderecoDao.inserir();
		imovelDao.getImovel().getEndereco().setIdEndereco(idEndereco);
		
		if (idEndereco != 0){
			//Inserir Imóvel
			int idImovel = imovelDao.inserir();
			imovelDao.getImovel().setIdImovel(idImovel);
			
			if (idImovel != 0){
				ConexaoBd.getConexao().commit();
			}
			else{
				ConexaoBd.getConexao().rollback();
			}
		}
		else{
			ConexaoBd.getConexao().rollback();
		}
		
		
		
		
		return imovelDao.getImovel().getIdImovel();
	}
	
	public boolean atualizar(){
		//Criar regra de transação e retorno
		
		//Atualizar Imóvel
		boolean retorno = imovelDao.atualizar();
		
		//Atualizar Endereço
		retorno = enderecoDao.atualizar();
		
		return retorno;
	}
	
	public boolean excluir(){
		//Criar regra de transação e retorno

		//Excluir Imóvel
		boolean retorno = imovelDao.excluir();
		
		//Excluir Endereço
		retorno = enderecoDao.excluir();
		
		return retorno;
	}
	
	public List<Imovel> localizarImoveis(){
		return imovelDao.localizarImoveis();
	}
	
	public Imovel localizarImovelById(){
		return imovelDao.localizarImovelById();
	}

}
