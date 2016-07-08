package br.com.imov.modelo;

public class Endereco {

	private int idEndereco;
	private String dsRua;
	private String dsNumero;
	private String dsComplemento;
	private String nmBairro;
	private int nrCep;
	private String ptCoordenadas;

	public Endereco() {
		this.idEndereco = 0;
		this.dsRua = "";
		this.dsNumero = "";
		this.dsComplemento = "";
		this.nmBairro = "";
		this.nrCep = 0;
		this.ptCoordenadas = "";
	}
	
	public void setEndereco(int idEndereco, String dsRua, String dsNumero, String dsComplemento, String nmBairro, int nrCep, String ptCoordenadas){
		this.idEndereco = idEndereco;
		this.dsRua = dsRua;
		this.dsNumero = dsNumero;
		this.dsComplemento = dsComplemento;
		this.nmBairro = nmBairro;
		this.nrCep = nrCep;
		this.ptCoordenadas = ptCoordenadas;
	}
	
	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getDsRua() {
		return dsRua;
	}

	public void setDsRua(String dsRua) {
		this.dsRua = dsRua;
	}

	public String getDsNumero() {
		return dsNumero;
	}

	public void setDsNumero(String dsNumero) {
		this.dsNumero = dsNumero;
	}

	public String getDsComplemento() {
		return dsComplemento;
	}

	public void setDsComplemento(String dsComplemento) {
		this.dsComplemento = dsComplemento;
	}

	public String getNmBairro() {
		return nmBairro;
	}

	public void setNmBairro(String nmBairro) {
		this.nmBairro = nmBairro;
	}

	public int getNrCep() {
		return nrCep;
	}

	public void setNrCep(int nrCep) {
		this.nrCep = nrCep;
	}
	
	public String getPtCoordenadas() {
		return ptCoordenadas;
	}

	public void setPtCoordenadas(String ptCoordenadas) {
		this.ptCoordenadas = ptCoordenadas;
	}
}
