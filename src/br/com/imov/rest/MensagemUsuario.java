package br.com.imov.rest;

import java.util.HashMap;
import java.util.Map;

public class MensagemUsuario {
	
	private static Map<String, String> listMensagem;
	static
	{
		listMensagem = new HashMap<String, String>();
		setMensagemSucessoGenerica();
		setMensagemErroGenerica();
	}
	
	public static String getMensagem(String idMensagem){
		return listMensagem.get(idMensagem);
	}
	
	private static void setMensagemSucessoGenerica(){
		listMensagem.put("1.1.1", "Sucesso ao efetuar o cadastro.");
		listMensagem.put("1.1.2", "Sucesso ao excluir o cadastro.");
		listMensagem.put("1.1.3", "Sucesso ao atualizar o cadastro.");
	}
	
	private static void setMensagemErroGenerica(){
		listMensagem.put("1.2.1", "Erro ao efetuar o cadastro.");
		listMensagem.put("1.2.2", "Erro ao excluir o cadastro.");
		listMensagem.put("1.2.3", "Erro ao atualizar o cadastro.");
	}
	


}
