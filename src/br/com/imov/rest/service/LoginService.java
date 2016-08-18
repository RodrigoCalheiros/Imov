package br.com.imov.rest.service;

import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.imov.controle.UsuarioControle;
import br.com.imov.modelo.Usuario;

import br.com.imov.rest.MensagemUsuario;
import br.com.imov.rest.Response;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class LoginService {
	
	private UsuarioControle usuarioControle;
	
	@POST
	public Response post(Usuario usuario) throws SQLException {
		usuarioControle = new UsuarioControle(usuario);
		boolean retorno = false;
		usuario = usuarioControle.efetuarLogin();
		if (usuario.getIdUsuario() != 0){
			retorno = true;
		}
		if (retorno == true){
			return Response.Sucesso(MensagemUsuario.getMensagem("2.1.1"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("2.2.1"));
		}
	}
	
}