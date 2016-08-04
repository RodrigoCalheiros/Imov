package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.modelo.Endereco;
import br.com.imov.modelo.interfac.InterfaceSql;

public class EnderecoSql implements InterfaceSql{
	
	private Connection conn;
	private Endereco endereco;
	
	public EnderecoSql(Connection conn, Endereco endereco){
		this.conn = conn;
		this.endereco = endereco;
	}

	public PreparedStatement getSqlInserir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) conn.prepareStatement("insert into tb_endereco"
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
			stmt = (PreparedStatement) conn.prepareStatement("update tb_endereco"
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
			stmt = (PreparedStatement) conn.prepareStatement("delete from tb_endereco where idEndereco = ?");
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
			stmt = (PreparedStatement) conn.prepareStatement("select * from tb_endereco");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stmt;
	}
	
	public PreparedStatement getSqlLocalizarById(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) conn.prepareStatement("select endereco.*"
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
