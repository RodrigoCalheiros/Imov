package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.interfac.InterfaceSql;
import br.com.imov.modelo.Imovel;
import br.com.imov.modelo.dao.ConexaoBd;

public class ImovelSql implements InterfaceSql{
	
	PreparedStatement stmt;
	private Imovel imovel;
	
	public ImovelSql(Imovel imovel){
		this.imovel = imovel;
	}

	public PreparedStatement getSqlInserir(){
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("insert into tb_imovel (idEndereco, dsImovel, stImovel) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, imovel.getEndereco().getIdEndereco());
			stmt.setString(2, imovel.getDsImovel());
			stmt.setBoolean(3, imovel.getStImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlAtualizar() {
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("update tb_imovel set dsImovel = ?, stImovel = ? where idImovel = ?");
			stmt.setString(1, imovel.getDsImovel());
			stmt.setBoolean(2, imovel.getStImovel());
			stmt.setInt(3, imovel.getIdImovel());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	public PreparedStatement getSqlExcluir(){
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
}
