package br.com.imov.interfac;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public interface InterfaceConexaoBd {
	
	public int inserir(PreparedStatement stmt);
	public boolean atualizar(PreparedStatement stmt);
	public boolean excluir(PreparedStatement stmt);
	public List<Map<String, Object>> localizar(PreparedStatement stmt);
	public Map<String, Object> localizarById(PreparedStatement stmt);
	
}
