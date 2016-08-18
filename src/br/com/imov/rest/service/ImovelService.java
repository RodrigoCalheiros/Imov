package br.com.imov.rest.service;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.imov.controle.ImovelControle;
import br.com.imov.modelo.Imovel;
import br.com.imov.rest.MensagemUsuario;
import br.com.imov.rest.Response;

@Path("/imovel")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ImovelService {
	
	private ImovelControle imovelController;
	
	public ImovelService(){
		imovelController = new ImovelControle();
	}

	@GET
	public List<Imovel> get() {
		return imovelController.localizarImoveis();
	}
	
	@GET
	@Path("{idImovel}")
	public Imovel get(@PathParam("idImovel") int idImovel) {
		return imovelController.localizarImovelById(idImovel);
	}
	
	@POST
	public Response post(Imovel imovel) throws SQLException {
		imovelController = new ImovelControle(imovel);
		int idImovel = imovelController.inserir();
		if (idImovel != 0){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.1"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.1"));
		}
	}

	@DELETE
	public Response delete(Imovel imovel) throws SQLException {
		imovelController = new ImovelControle(imovel);
		boolean retorno = imovelController.excluir();
		if (retorno == true){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.2"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.2"));
		}
	}

	@PUT
	public Response put(Imovel imovel) throws SQLException {
		imovelController = new ImovelControle(imovel);
		boolean retorno = imovelController.atualizar();
		if (retorno == true){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.3"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.3"));
		}
	}
	
}