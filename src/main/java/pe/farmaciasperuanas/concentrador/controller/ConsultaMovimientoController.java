package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaMovimientoRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaMovimiento;
import pe.farmaciasperuanas.concentrador.service.ConsultaMovimientoService;
import pe.farmaciasperuanas.concentrador.util.Constantes;

@RequestScoped
@Path("/consulta-movimiento")
@Produces("application/json")
@Consumes("application/json")
public class ConsultaMovimientoController {

	@Inject
	ConsultaMovimientoService consultaMovimientoService;
	
	@POST
	@Path("/pagina/{page}")
	@RolesAllowed({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
	public List<ConsultaMovimiento> consulta(ConsultaMovimientoRequest request, @PathParam("page") Integer page){
		return consultaMovimientoService.consulta(request, page);
	}
}
