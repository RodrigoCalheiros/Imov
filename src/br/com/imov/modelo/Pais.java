package br.com.imov.modelo;

import java.util.Map;

public class Pais {
	
	private int idPais;
	private String nmPais;
	private String dsSigla;
	
	public Pais() {
		this.idPais = 0;
		this.nmPais = "";
		this.dsSigla = "";
	}
	
	public Pais(Map<String, Object> row){
		setPais(row);
	}
	
	public void setPais(Map<String, Object> row){
		this.idPais =	(Integer) (row.get("idPais") != null ? row.get("idPais") : 0);
		this.nmPais = (String) (row.get("nmPais") != null ? row.get("nmPais") : "");
		this.dsSigla = (String) (row.get("dsSigla") != null ? row.get("dsSigla") : "");
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNmPais() {
		return nmPais;
	}

	public void setNmPais(String nmPais) {
		this.nmPais = nmPais;
	}

	public String getDsSigla() {
		return dsSigla;
	}

	public void setDsSigla(String dsSigla) {
		this.dsSigla = dsSigla;
	}

}
