package br.com.imov.modelo.sql;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import br.com.imov.interfac.InterfaceSql;
import br.com.imov.modelo.Usuario;
import br.com.imov.modelo.dao.ConexaoBd;

public class UsuarioSql implements InterfaceSql{
	
	PreparedStatement stmt;
	private Usuario usuario;
	
	public UsuarioSql(Usuario usuario){
		this.usuario = usuario;
	}
	
	public PreparedStatement getSqlEfetuarLogin() {
		try {
			stmt = (PreparedStatement) ConexaoBd.getConexao().prepareStatement("select usuario.*, pessoa.*, endereco.*"
																			  + " from tb_usuario as usuario"
																			  + " inner join tb_pessoa as pessoa on (usuario.idPessoa = pessoa.idPessoa)"
																			  + " left join tb_endereco as endereco on (pessoa.idEndereco = endereco.idEndereco)"
																			  + " where usuario.dsEmailAcesso like ?"
																			  + " and usuario.dsSenhaAcesso like ?");
			stmt.setString(1, usuario.getDsEmailAcesso());
			stmt.setString(2, usuario.getDsSenhaAcesso());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
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
	public PreparedStatement getSqlLocalizar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement getSqlLocalizarById() {
		// TODO Auto-generated method stub
		return null;
	}

}
