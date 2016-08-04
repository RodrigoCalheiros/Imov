package br.com.imov.modelo;

import br.com.imov.modelo.dao.EnderecoDao;

public class Imovel {
	
	private int idImovel;
	private String dsImovel;
	private int stImovel;
	private Endereco endereco;
	

	public Imovel() {
		this.idImovel = 0;
		this.dsImovel = "";
		this.stImovel = 0;
		this.endereco = new Endereco();
	}
	
	public void setImovel(int idImovel, String dsImovel, int stImovel, Endereco endereco){
		this.idImovel = idImovel;
		this.dsImovel = dsImovel;
		this.stImovel = stImovel;
		this.endereco = endereco;
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

	public int getStImovel() {
		return stImovel;
	}

	public void setStImovel(int stImovel) {
		this.stImovel = stImovel;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
