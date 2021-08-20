package pe.farmaciasperuanas.concentrador.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaEntidadProducto;
import pe.farmaciasperuanas.concentrador.service.ConsultaProductoService;

@RequestScoped
@Path("/consulta")
@Produces("application/json")
@Consumes("application/json")
public class ConsultaEntidadProductoController {

	@Inject
	ConsultaProductoService consultaProductoService;
	
	@POST
	@Path("/producto-financiero/pagina/{page}")
	public List<ConsultaEntidadProducto> consulta(ConsultaProductoFinancieroRequest request, @PathParam("page") Integer page){
		return consultaProductoService.consulta(request, page);
	}
	
	@GET
	@Path("/{id}")
	public ConsultaEntidadProducto obtenerPorId(@PathParam("id") Long id) {
		return consultaProductoService.obtenerPorId(id);
	}
}
