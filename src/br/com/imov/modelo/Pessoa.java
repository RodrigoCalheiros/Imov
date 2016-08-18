package br.com.imov.modelo;

import java.util.Map;

public class Pessoa {
	
	private int idPessoa;
	private String nrCpfCnpj;
	private String nmPessoa;
	private String dsEmail;
	private String dsTelefone;
	private Endereco endereco;
	

	public Pessoa() {
		this.idPessoa = 0;
		this.nrCpfCnpj = "";
		this.nmPessoa = "";
		this.dsEmail = "";
		this.dsTelefone = "";
		this.endereco = new Endereco();
	}
	
	public Pessoa(Map<String, Object> row){
		setPessoa(row);
	}
	
	public void setPessoa(Map<String, Object> row){
		this.idPessoa =	(Integer) (row.get("idPessoa") != null ? row.get("idPessoa") : 0);
		this.nrCpfCnpj = (String) (row.get("nrCpfCnpj") != null ? row.get("nrCpfCnpj") : "");
		this.nmPessoa = (String) (row.get("nmPessoa") != null ? row.get("nmPessoa") : "");
		this.dsEmail = (String) (row.get("dsEmail") != null ? row.get("dsEmail") : "");
		this.dsTelefone = (String) (row.get("dsTelefone") != null ? row.get("dsTelefone") : "");
		this.endereco = new Endereco(row);
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNrCpfCnpj() {
		return nrCpfCnpj;
	}

	public void setNrCpfCnpj(String nrCpfCnpj) {
		this.nrCpfCnpj = nrCpfCnpj;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsTelefone() {
		return dsTelefone;
	}

	public void setDsTelefone(String dsTelefone) {
		this.dsTelefone = dsTelefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
