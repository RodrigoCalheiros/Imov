package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.interfac.InterfaceSql;
import br.com.imov.modelo.Estado;
import br.com.imov.modelo.dao.ConexaoBd;

public class EstadoSql implements InterfaceSql{
	
	PreparedStatement stmt;
	private Estado estado;
	
	public EstadoSql(Estado estado){
		this.estado = estado;
	}

	@Override
	public PreparedStatement getSqlInserir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSqlAtualizar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSqlExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSqlLocalizar(){
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select estado.*,"
					 															+ " pais.*"
																			    + " from tb_estado as estado"
																				+ " left join tb_pais as pais on (estado.idPais = pais.idPais)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	@Override
	public PreparedStatement getSqlLocalizarById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PreparedStatement getSqlLocalizarEstadosByIdPais(int idPais){
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select estado.*,"
					 															+ " pais.*"
																			    + " from tb_estado as estado"
																				+ " left join tb_pais as pais on (estado.idPais = pais.idPais)"
																			    + " where pais.idPais = " + idPais);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}


	
}
