package br.com.imov.rest;

public class Response {
	
	private String tpMensagem;
	private String dsMensagem;

	public Response() {
		setTpMensagem("");
		setDsMensagem("");
	}
	
	public static Response Sucesso(String mensagem) {
		Response response = new Response();
		response.setTpMensagem("Sucess");
		response.setDsMensagem(mensagem);
		return response;
	}

	public static Response Erro(String mensagem) {
		Response response = new Response();
		response.setTpMensagem("Error");
		response.setDsMensagem(mensagem);
		return response;
	}
	
	public static Response Atencao(String mensagem) {
		Response response = new Response();
		response.setTpMensagem("Error");
		response.setDsMensagem(mensagem);
		return response;
	}
	
	public static Response Informacao(String mensagem) {
		Response response = new Response();
		response.setTpMensagem("Error");
		response.setDsMensagem(mensagem);
		return response;
	}
	
	public String getTpMensagem() {
		return tpMensagem;
	}

	public void setTpMensagem(String tpMensagem) {
		this.tpMensagem = tpMensagem;
	}

	public String getDsMensagem() {
		return dsMensagem;
	}

	public void setDsMensagem(String dsMensagem) {
		this.dsMensagem = dsMensagem;
	}
	
	public void setResponse(String tpMensagem, String dsMensagem){
		setTpMensagem(tpMensagem);
		setDsMensagem(dsMensagem);
	}

}