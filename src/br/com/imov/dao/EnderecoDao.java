package br.com.imov.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.modelo.Endereco;

public class EnderecoDao {
	
	private Endereco endereco;
		
	public EnderecoDao(){
		this.endereco = new Endereco();
	}
	
	public EnderecoDao(Endereco endereco){
		this.endereco = endereco;
	}
	
	public PreparedStatement getSqlInserir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("insert into tb_endereco"
																			+ " (dsRua, dsNumero, dsComplemento, nmBairro, nrCep, ptCoordenadas)"
																			+ " values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getDsRua());
			stmt.setString(2, endereco.getDsNumero());
			stmt.setString(3, endereco.getDsComplemento());
			stmt.setString(4, endereco.getNmBairro());
			stmt.setInt(5, endereco.getNrCep());
			stmt.setString(6, endereco.getPtCoordenadas());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlAtualizar() {
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("update tb_endereco"
																			+ " set dsRua = ?, dsNumero = ?, dsComplemento = ?, nmBairro = ?, nrCep = ?, ptCoordenadas = ?"
																			+ " where idEndereco = ?");
			stmt.setString(1, endereco.getDsRua());
			stmt.setString(2, endereco.getDsNumero());
			stmt.setString(3, endereco.getDsComplemento());
			stmt.setString(4, endereco.getNmBairro());
			stmt.setInt(5, endereco.getNrCep());
			stmt.setString(6, endereco.getPtCoordenadas());
			stmt.setInt(7, endereco.getIdEndereco());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlExcluir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("delete from tb_endereco where idEndereco = ?");
			stmt.setInt(1, endereco.getIdEndereco());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizar(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select * from tb_endereco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizarById(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select endereco.*"
																			    + " from tb_endereco as endereco"
																			    + " where endereco.idEndereco = ?");
			stmt.setInt(1, endereco.getIdEndereco());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public int inserir(){
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
	
	public boolean excluir(){
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
	
	public List<Endereco> localizarEndereco(){
		Endereco endereco = null;
		List<Endereco> listEndereco = new ArrayList<Endereco>();
		Map<String, Object> row = null;
		List<Map<String, Object>> resultList  = localizar();
		for (int i = 0; (i+1) <= resultList.size(); i++) {
			row = resultList.get(i);
			endereco = new Endereco();
			endereco.setEndereco((Integer) row.get("idEndereco"), 
								 (String) row.get("dsRua"),
								 (String) row.get("dsNumero"),
								 (String) row.get("dsComplemento"),
								 (String) row.get("nmBairro"),
								 (Integer) row.get("nrCep"),
								 (String) row.get("ptCoordenadas"));
			listEndereco.add(endereco);
		}
		return listEndereco;
	}
	
	public Endereco localizarEnderecoById(){
		Map<String, Object> row =localizarById();
		endereco.setEndereco((Integer) row.get("idEndereco"), 
							 (String) row.get("dsRua"),
							 (String) row.get("dsNumero"),
							 (String) row.get("dsComplemento"),
							 (String) row.get("nmBairro"),
							 (Integer) row.get("nrCep"),
							 (String) row.get("ptCoordenadas"));
		return endereco;
	}
}
