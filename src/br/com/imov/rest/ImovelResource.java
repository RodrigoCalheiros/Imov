package br.com.imov.rest;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.imov.controller.ImovelController;
import br.com.imov.modelo.Imovel;

@Path("/imovel")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class ImovelResource {
	
	private ImovelController imovelController;
	
	public ImovelResource(){
		imovelController = new ImovelController();
	}

	@GET
	public List<Imovel> get() {
		return imovelController.localizarImoveis();
	}
	
	/**
	@GET
	@Path("{id}")
	public Imovel get(@PathParam("id") long id) {
		return ;
	}

	@GET
	@Path("/tipo/{tipo}")
	public List<Carro> getByTipo(@PathParam("tipo") String tipo) {
		List<Carro> carros = carroService.findByTipo(tipo);
		return carros;
	}
	

	@GET
	@Path("/nome/{nome}")
	public List<Carro> getByNome(@PathParam("nome") String nome) {
		List<Carro> carros = carroService.findByName(nome);
		return carros;
	}
	**/
	
	@POST
	public Response post(Imovel imovel) {
		int idImovel = imovelController.inserir(imovel);
		System.out.println(idImovel);
		if (idImovel != 0){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.1"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.1"));
		}
	}

	@DELETE
	//@Path("{id}")
	public Response delete(Imovel imovel) {
		boolean retorno = imovelController.excluir(imovel);
		if (retorno == true){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.2"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.2"));
		}
	}

	@PUT
	public Response put(Imovel imovel) {
		boolean retorno = imovelController.atualizar(imovel);
		if (retorno == true){
			return Response.Sucesso(MensagemUsuario.getMensagem("1.1.3"));
		}
		else{
			return Response.Erro(MensagemUsuario.getMensagem("1.2.3"));
		}
	}
	
}