package br.com.imov.interfac;

import java.sql.SQLException;

public interface InterfaceControle {
	public int inserir() throws SQLException;
	public boolean atualizar() throws SQLException;
	public boolean excluir() throws SQLException;
	
}
