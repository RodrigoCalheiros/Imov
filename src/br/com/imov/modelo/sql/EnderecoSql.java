package br.com.imov.modelo.sql;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.interfac.InterfaceSql;
import br.com.imov.modelo.Endereco;
import br.com.imov.modelo.dao.ConexaoBd;

public class EnderecoSql implements InterfaceSql{
	
	PreparedStatement stmt;
	private Endereco endereco;
	
	public EnderecoSql(Endereco endereco){
		this.endereco = endereco;
	}

	public PreparedStatement getSqlInserir(){
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("insert into tb_endereco"
																			+ " (dsRua, dsNumero, dsComplemento, nmBairro, nrCep, nrLatitude, nrLongitude)"
																			+ " values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getDsRua());
			stmt.setString(2, endereco.getDsNumero());
			stmt.setString(3, endereco.getDsComplemento());
			stmt.setString(4, endereco.getNmBairro());
			stmt.setInt(5, endereco.getNrCep());
			stmt.setBigDecimal(6, endereco.getNrLatitude());
			stmt.setBigDecimal(7, endereco.getNrLongitude());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlAtualizar() {
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("update tb_endereco"
																			+ " set dsRua = ?, dsNumero = ?, dsComplemento = ?, nmBairro = ?, nrCep = ?, nrLatitude = ?, nrLongitude = ?"
																			+ " where idEndereco = ?");
			stmt.setString(1, endereco.getDsRua());
			stmt.setString(2, endereco.getDsNumero());
			stmt.setString(3, endereco.getDsComplemento());
			stmt.setString(4, endereco.getNmBairro());
			stmt.setInt(5, endereco.getNrCep());
			stmt.setBigDecimal(6, endereco.getNrLatitude());
			stmt.setBigDecimal(7, endereco.getNrLongitude());
			stmt.setInt(8, endereco.getIdEndereco());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlExcluir(){
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
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select * from tb_endereco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizarById(){
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

}
