package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
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

import pe.farmaciasperuanas.concentrador.dto.request.EntidadFinancieraRequest;
import pe.farmaciasperuanas.concentrador.model.EntidadFinanciera;
import pe.farmaciasperuanas.concentrador.service.EntidadFinancieraService;
import pe.farmaciasperuanas.concentrador.util.Constantes;

@RequestScoped
@Path("/entidad-financiera")
@Produces("application/json")
@Consumes("application/json")
public class EntidadFinancieraController {

	@Inject
	EntidadFinancieraService entidadFinancieraService;
	
	@POST
	@Path("/pagina/{page}")
	@RolesAllowed({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
	public List<EntidadFinanciera> finAll(EntidadFinancieraRequest request, @PathParam("page") Integer page){
		return entidadFinancieraService.findAll(request, page);
	}
	
	@GET
	@Path("/{id}")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public EntidadFinanciera findOne(@PathParam("id") Long id) {
		return entidadFinancieraService.findOne(id);
	}
	
	@POST
	@Path("/save")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public Response save(EntidadFinanciera entidad) {
		entidadFinancieraService.saveOrUpdate(entidad);
		return Response.created(UriBuilder.fromResource(EntidadFinancieraController.class).path(String.valueOf(entidad.getIdEntidadFinanciera())).build())
				.build();
	}
	
	@DELETE
	@Path("/disable/{id}")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public void disable(@PathParam("id") Long id) {
		entidadFinancieraService.disable(id);
	}
}
