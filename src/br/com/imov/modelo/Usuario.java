package br.com.imov.modelo;

import java.util.Map;

public class Usuario {
		
	private int idUsuario;
	private Pessoa pessoa;
	private String dsEmailAcesso;
	private String dsSenhaAcesso;
	private boolean flAcesso;
	

	public Usuario() {
		this.idUsuario = 0;
		this.pessoa = new Pessoa();
		this.dsEmailAcesso = "";
		this.dsSenhaAcesso = "";
		this.flAcesso = false;
	}
	
	public Usuario(Map<String, Object> row){
		setUsuario(row);
	}
	
	public void setUsuario(Map<String, Object> row){
		this.idUsuario =	(Integer) (row.get("idUsuario") != null ? row.get("idUsuario") : 0);
		this.pessoa = new Pessoa(row);
		this.dsEmailAcesso = (String) (row.get("dsEmailAcesso") != null ? row.get("dsEmailAcesso") : "");
		this.dsSenhaAcesso = (String) (row.get("dsSenhaAcesso") != null ? row.get("dsSenhaAcesso") : "");
		this.flAcesso = (boolean) (row.get("flAcesso") != null ? row.get("flAcesso") : false);
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getDsEmailAcesso() {
		return dsEmailAcesso;
	}

	public void setDsEmailAcesso(String dsEmailAcesso) {
		this.dsEmailAcesso = dsEmailAcesso;
	}

	public String getDsSenhaAcesso() {
		return dsSenhaAcesso;
	}

	public void setDsSenhaAcesso(String dsSenhaAcesso) {
		this.dsSenhaAcesso = dsSenhaAcesso;
	}

	public boolean isFlAcesso() {
		return flAcesso;
	}

	public void setFlAcesso(boolean flAcesso) {
		this.flAcesso = flAcesso;
	}
	
	

}
