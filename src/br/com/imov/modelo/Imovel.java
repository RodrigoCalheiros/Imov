package br.com.imov.modelo;

import java.util.Map;

public class Imovel {
	
	private int idImovel;
	private String dsImovel;
	private boolean stImovel;
	private Endereco endereco;
	

	public Imovel() {
		this.idImovel = 0;
		this.dsImovel = "";
		this.stImovel = false;
		this.endereco = new Endereco();
	}
	
	public Imovel(Map<String, Object> row){
		setImovel(row);
	}
	
	public void setImovel(Map<String, Object> row){
		this.idImovel =	(Integer) (row.get("idImovel") != null ? row.get("idImovel") : 0);
		this.dsImovel = (String) (row.get("dsImovel") != null ? row.get("dsImovel") : "");
		this.stImovel = (boolean) (row.get("stImovel") != null ? row.get("stImovel") : false);
		this.endereco = new Endereco(row);
	}
	
	public int getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(int idImovel) {
		this.idImovel = idImovel;
	}

	public String getDsImovel() {
		return dsImovel;
	}

	public void setDsImovel(String dsImovel) {
		this.dsImovel = dsImovel;
	}

	public boolean getStImovel() {
		return stImovel;
	}

	public void setStImovel(boolean stImovel) {
		this.stImovel = stImovel;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
