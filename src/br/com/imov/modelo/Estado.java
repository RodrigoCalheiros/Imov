package br.com.imov.modelo;

import java.util.Map;

public class Estado {
	
	private int idEstado;
	private String dsEstado;
	private String dsUf;
	private Pais pais;
	

	public Estado() {
		this.idEstado = 0;
		this.dsEstado = "";
		this.dsUf = "";
		this.pais = new Pais();
	}
	
	public Estado(Map<String, Object> row){
		setEstado(row);
	}
	
	public void setEstado(Map<String, Object> row){
		this.idEstado =	(Integer) (row.get("idEstado") != null ? row.get("idEstado") : 0);
		this.dsEstado = (String) (row.get("dsEstado") != null ? row.get("dsEstado") : "");
		this.dsUf = (String) (row.get("dsUf") != null ? row.get("dsUf") : "");
		this.pais = new Pais(row);
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDsEstado() {
		return dsEstado;
	}

	public void setDsEstado(String dsEstado) {
		this.dsEstado = dsEstado;
	}

	public String getDsUf() {
		return dsUf;
	}

	public void setDsUf(String dsUf) {
		this.dsUf = dsUf;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}
