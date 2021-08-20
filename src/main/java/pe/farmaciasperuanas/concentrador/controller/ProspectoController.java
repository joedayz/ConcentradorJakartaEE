package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import pe.farmaciasperuanas.concentrador.dto.request.ProspectoRequest;
import pe.farmaciasperuanas.concentrador.model.Prospecto;
import pe.farmaciasperuanas.concentrador.service.ProspectoService;

@RequestScoped
@Path("/prospecto")
@Produces("application/json")
@Consumes("application/json")
public class ProspectoController {

	@Inject
	ProspectoService prospectoService;
	
	@POST
	@Path("/listar/pagina/{page}")
	public List<Prospecto> fidAll(ProspectoRequest request, @PathParam("page") Integer page){
		return prospectoService.listar(request, page);
	}
	
	@POST
	public Response guardar(Prospecto obj) {
		prospectoService.saveOrUpdate(obj);
		return Response.created(UriBuilder.fromResource(ProspectoController.class).path(String.valueOf(obj.getIdProspecto())).build())
				.build();
	}
	
}
