package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import br.com.imov.interfac.InterfaceSql;
import br.com.imov.modelo.Pais;
import br.com.imov.modelo.dao.ConexaoBd;

public class PaisSql implements InterfaceSql{
	
	PreparedStatement stmt;
	private Pais pais;
	
	public PaisSql(Pais pais){
		this.pais = pais;
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
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select pais.*"
																			    + " from tb_pais as pais");
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
	



	
}
