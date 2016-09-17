package br.com.imov.rest.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.imov.controle.PaisControle;
import br.com.imov.modelo.Pais;

@Path("/pais")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PaisService {
	
	private PaisControle paisController;
	
	public PaisService(){
		paisController = new PaisControle();
	}

	@GET
	public List<Pais> get() {
		return paisController.localizarPaises();
	}
	
}