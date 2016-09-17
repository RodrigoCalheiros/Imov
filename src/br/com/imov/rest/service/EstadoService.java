package br.com.imov.rest.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.imov.controle.EstadoControle;
import br.com.imov.modelo.Estado;
import br.com.imov.modelo.Imovel;

@Path("/estado")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class EstadoService {
	
	private EstadoControle estadoController;
	
	public EstadoService(){
		estadoController = new EstadoControle();
	}

	@GET
	public List<Estado> get() {
		return estadoController.localizarEstados();
	}
	
	@GET
	@Path("idPais/{idPais}")
	public List<Estado> get(@PathParam("idPais") int idPais) {
		return estadoController.localizarEstadosByIdPais(idPais);
	}
	
}