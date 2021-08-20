package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import pe.farmaciasperuanas.concentrador.model.Opcion;
import pe.farmaciasperuanas.concentrador.repository.OpcionRepository;

@RequestScoped
@Path("/opcion")
@Produces("application/json")
@Consumes("application/json")
public class OpcionController {

	@Inject
	OpcionRepository opcionRepository;
	
	@GET
	public List<Opcion> listar(){
		return opcionRepository.listaOpcion();
	}
	
	@POST
	public Response guardar(Opcion obj) {
		opcionRepository.save(obj);
		return Response.created(UriBuilder.fromResource(OpcionController.class).path(String.valueOf(obj.getIdOpcion())).build())
				.build();
	}
	
	@GET
	@Path("/{id}")
	public Response obtener(@PathParam("id") Long id) {
		 return Response.status(Response.Status.OK).entity(
				 opcionRepository.findBy(id)).build();
	}
	
	@DELETE
	public void eliminar(Opcion obj) {
		 opcionRepository.remove(obj);
		 Response.status(Response.Status.OK);
	}
	
}
