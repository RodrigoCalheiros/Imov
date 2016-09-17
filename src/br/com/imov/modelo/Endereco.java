package br.com.imov.modelo;

import java.math.BigDecimal;
import java.util.Map;

public class Endereco {

	private int idEndereco;
	private String dsRua;
	private String dsNumero;
	private String dsComplemento;
	private String nmBairro;
	private int nrCep;
	private BigDecimal nrLatitude;
	private BigDecimal nrLongitude;
	
	public Endereco() {
		this.idEndereco = 0;
		this.dsRua = "";
		this.dsNumero = "";
		this.dsComplemento = "";
		this.nmBairro = "";
		this.nrCep = 0;
		this.nrLatitude = BigDecimal.ZERO;
		this.nrLongitude = BigDecimal.ZERO;
	}
	
	public Endereco(Map<String, Object> row){
		setEndereco(row);
	}
	
	public void setEndereco(Map<String, Object> row){
		this.idEndereco = (Integer) (row.get("idEndereco") != null ? row.get("idEndereco") : 0);
		this.dsRua = (String) (row.get("dsRua") != null ? row.get("dsRua") : "");
		this.dsNumero = (String) (row.get("dsNumero") != null ? row.get("dsNumero") : "");
		this.dsComplemento = (String) (row.get("dsComplemento") != null ? row.get("dsComplemento") : "");
		this.nmBairro = (String) (row.get("nmBairro") != null ? row.get("nmBairro") : "");
		this.nrCep = (Integer) (row.get("nrCep") != null ? row.get("nrCep") : 0);
		this.nrLatitude = (BigDecimal) (row.get("nrLatitude") != null ? row.get("nrLatitude") : 0);
		this.nrLongitude = (BigDecimal) (row.get("nrLongitude") != null ? row.get("nrLongitude") : 0);
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

	public BigDecimal getNrLatitude() {
		return nrLatitude;
	}

	public void setNrLatitude(BigDecimal nrLatitude) {
		this.nrLatitude = nrLatitude;
	}

	public BigDecimal getNrLongitude() {
		return nrLongitude;
	}

	public void setNrLongitude(BigDecimal nrLongitude) {
		this.nrLongitude = nrLongitude;
	}
	
}
