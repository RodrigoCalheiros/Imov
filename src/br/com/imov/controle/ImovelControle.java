package br.com.imov.controle;

import java.sql.SQLException;
import java.util.List;

import br.com.imov.interfac.InterfaceControle;
import br.com.imov.modelo.Imovel;
import br.com.imov.modelo.dao.ConexaoBd;
import br.com.imov.modelo.dao.EnderecoDao;
import br.com.imov.modelo.dao.ImovelDao;

public class ImovelControle implements InterfaceControle{
	
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
	
	public int inserir(){
		//Inserir Endereço
		int idEndereco = enderecoDao.inserir();
		imovelDao.getImovel().getEndereco().setIdEndereco(idEndereco);
		try {
			if (idEndereco != 0){	
				//Inserir Imóvel
				int idImovel = imovelDao.inserir();
				imovelDao.getImovel().setIdImovel(idImovel);
				
				if(idImovel != 0){
					ConexaoBd.getConexao().commit();
				}
				else{
					ConexaoBd.getConexao().rollback();
				}
			}
			else{
				ConexaoBd.getConexao().rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBd.desconectar();
		}
		
		return imovelDao.getImovel().getIdImovel();
	}
	
	public boolean atualizar() throws SQLException{
		//Atualizar Imóvel
		boolean retorno = imovelDao.atualizar();
		
		if (retorno == true){
			//Atualizar Endereço
			retorno = enderecoDao.atualizar();
			
			if(retorno == true){
				ConexaoBd.getConexao().commit();
			}
			else{
				ConexaoBd.getConexao().rollback();
			}
		}
		else{
			ConexaoBd.getConexao().rollback();
		}
		
		ConexaoBd.desconectar();
		return retorno;
	}
	
	public boolean excluir() throws SQLException{
		//Excluir Imóvel
		boolean retorno = imovelDao.excluir();
		
		if (retorno == true){
			//Excluir Endereço
			retorno = enderecoDao.excluir();
			
			if(retorno == true){
				ConexaoBd.getConexao().commit();
			}
			else{
				ConexaoBd.getConexao().rollback();
			}
		}
		else{
			ConexaoBd.getConexao().rollback();
		}
		
		ConexaoBd.desconectar();
		return retorno;
	}
	
	public List<Imovel> localizarImoveis(){
		return imovelDao.localizarImoveis();
	}
	
	public Imovel localizarImovelById(int idImovel){
		imovelDao.getImovel().setIdImovel(idImovel);
		return imovelDao.localizarImovelById();
	}

}
