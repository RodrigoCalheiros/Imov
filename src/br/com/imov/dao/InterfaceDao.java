package br.com.imov.dao;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public interface InterfaceDao {
	
	public PreparedStatement getSqlInserir();
	public PreparedStatement getSqlAtualizar();
	public PreparedStatement getSqlExcluir();
	public PreparedStatement getSqlLocalizar();
	public PreparedStatement getSqlLocalizarById();
	public int inserir();
	public boolean atualizar();
	public boolean excluir();
	public List<Map<String, Object>> localizar();
	public Map<String, Object> localizarById();
	

}
