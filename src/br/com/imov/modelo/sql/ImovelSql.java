package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.modelo.Imovel;
import br.com.imov.modelo.interfac.InterfaceSql;

public class ImovelSql implements InterfaceSql{
	
	private Connection conn;
	private Imovel imovel;
	
	public ImovelSql(Connection conn, Imovel imovel){
		this.conn = conn;
		this.imovel = imovel;
	}

	public PreparedStatement getSqlInserir(){
		PreparedStatement stmt = null;
		try {
			stmt = (PreparedStatement) conn.prepareStatement("insert into tb_imovel (idEndereco, dsImovel, stImovel) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
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
			stmt = (PreparedStatement) conn.prepareStatement("update tb_imovel set dsImovel = ?, stImovel = ? where idImovel = ?");
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
			stmt = (PreparedStatement) conn.prepareStatement("delete from tb_imovel where idImovel = ?;");
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
			stmt = (PreparedStatement) conn.prepareStatement("select imovel.*,"
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
			stmt = (PreparedStatement) conn.prepareStatement("select imovel.*,"
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
}
