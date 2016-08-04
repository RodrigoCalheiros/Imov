package br.com.imov.modelo.interfac;

import com.mysql.jdbc.PreparedStatement;

public interface InterfaceSql {

	public PreparedStatement getSqlInserir();
	public PreparedStatement getSqlAtualizar();
	public PreparedStatement getSqlExcluir();
	public PreparedStatement getSqlLocalizar();
	public PreparedStatement getSqlLocalizarById();
}
