package br.com.imov.interfac;

import java.util.List;
import java.util.Map;

public interface InterfaceDao {
	
	public int inserir();
	public boolean atualizar();
	public boolean excluir();
	public List<Map<String, Object>> localizar();
	public Map<String, Object> localizarById();
	

}
