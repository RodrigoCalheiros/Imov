package br.com.imov.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.modelo.Endereco;
import br.com.imov.modelo.Imovel;

public class ImovelDao {
	
	private Imovel imovel;
	
	public ImovelDao() {
		this.imovel = new Imovel();
	}
	
	public ImovelDao(Imovel imovel) {
		this.imovel = imovel;
	}

	//Métodos Genéricos
	
	public PreparedStatement getSqlInserir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("insert into tb_imovel (idEndereco, dsImovel, stImovel) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, imovel.getEndereco().getIdEndereco());
			stmt.setString(2, imovel.getDsImovel());
			stmt.setInt(3, imovel.getStImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlAtualizar() {
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("update tb_imovel set dsImovel = ?, stImovel = ? where idImovel = ?");
			stmt.setString(1, imovel.getDsImovel());
			stmt.setInt(2, imovel.getStImovel());
			stmt.setInt(3, imovel.getIdImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlExcluir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("delete from tb_imovel where idImovel = ?;");
			stmt.setInt(1, imovel.getIdImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizar(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select imovel.*,"
																				+ " endereco.*"
																			    + " from tb_imovel as imovel "
																				+ " left join tb_endereco as endereco on (imovel.idEndereco = endereco.idEndereco)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizarById() {
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select imovel.*,"
																				+ " endereco.*"
																			    + " from tb_imovel as imovel "
																				+ " left join tb_endereco as endereco on (imovel.idEndereco = endereco.idEndereco)"
																			    + " where imovel.idImovel = ?");
			stmt.setInt(1, imovel.getIdImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	public int inserir() {
		int retorno = 0;
		ConexaoBd conexao = new ConexaoBd();
		retorno = conexao.inserir(getSqlInserir());
		return retorno;
	}

	public boolean atualizar() {
		boolean retorno = false;
		ConexaoBd conexao = new ConexaoBd();
		retorno = conexao.atualizar(getSqlAtualizar());
		return retorno;
	}

	public boolean excluir() {
		boolean retorno = false;
		ConexaoBd conexao = new ConexaoBd();
		retorno = conexao.excluir(getSqlExcluir());
		return retorno;
	}

	public List<Map<String, Object>> localizar() {
		ConexaoBd conexao = new ConexaoBd();
		return conexao.localizar(getSqlLocalizar());
		
	}

	public Map<String, Object> localizarById() {
		ConexaoBd conexao = new ConexaoBd();
		List<Map<String, Object>> resultList  = conexao.localizar(getSqlLocalizarById());
		return resultList.get(0);
	}
	
	//Métodos Específicos
	
	public List<Imovel> localizarImoveis(){
		List<Imovel> listImovel = new ArrayList<Imovel>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			listImovel.add(setImovel(row));
		}
		return listImovel;
	}
	
	public Imovel localizarImovelById(){
		Map<String, Object> row = localizarById();
		return setImovel(row);
	}
	
	public Imovel setImovel(Map<String, Object> row){
		Imovel imovel = new Imovel();
		Endereco endereco = new Endereco();
		endereco.setEndereco((Integer) row.get("idEndereco"), 
										(String) row.get("dsRua"),
										(String) row.get("dsNumero"),
										(String) row.get("dsComplemento"),
										(String) row.get("nmBairro"),
										(Integer) row.get("nrCep"),
										(String) row.get("ptCoordenadas"));
		imovel.setImovel((Integer) row.get("idImovel"), 
								  (String) row.get("dsImovel"), 
								  (Integer) row.get("stImovel"), 
								  endereco);
		return imovel;
	}
}
