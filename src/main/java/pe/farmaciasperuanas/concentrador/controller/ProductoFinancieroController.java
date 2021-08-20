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

import pe.farmaciasperuanas.concentrador.dto.request.ProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.dto.response.CollectionResponse;
import pe.farmaciasperuanas.concentrador.dto.response.ProductoFinancieroResponse;
import pe.farmaciasperuanas.concentrador.model.ProductoFinanciero;
import pe.farmaciasperuanas.concentrador.service.ProductoFinancieroService;
import pe.farmaciasperuanas.concentrador.util.Constantes;

@RequestScoped
@Path("/producto-financiero")
@Produces("application/json")
@Consumes("application/json")
public class ProductoFinancieroController {

	@Inject
	ProductoFinancieroService productoFinancieroService;
	
	@POST
	@Path("/pagina/{page}")
	@RolesAllowed({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
	public List<ProductoFinanciero> finAll(ProductoFinancieroRequest request, @PathParam("page") Integer page){
		return productoFinancieroService.findAll(request, page);
	}
	
	@POST
	@Path("/prestamo/pagina/{page}")
	@RolesAllowed({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
	public List<ProductoFinanciero> finAllPrestamo(ProductoFinancieroRequest request, @PathParam("page") Integer page){
		return productoFinancieroService.findAllPrestamo(request, page);
	}
	
	@POST
	@Path("/deposito/pagina/{page}")
	@RolesAllowed({Constantes.ROL_ADMIN, Constantes.ROL_PUBLIC})
	public CollectionResponse<ProductoFinancieroResponse> findAllDeposito(@PathParam("page") Integer page){
		return productoFinancieroService.findAllDeposito(page);
	}
	
	@GET
	@Path("/{id}")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public ProductoFinanciero findOne(@PathParam("id") Long id) {
		return productoFinancieroService.findOne(id);
	}
	
	@POST
	@Path("/save")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public Response saveProducto(ProductoFinanciero producto) {
		productoFinancieroService.saveProducto(producto);
		return Response.created(UriBuilder.fromResource(ProductoFinancieroController.class).path(String.valueOf(producto.getIdProductoFinanciero())).build())
				.build();
	}
	
	@DELETE
	@Path("/disable/{id}")
	@RolesAllowed({Constantes.ROL_ADMIN})
	public void disable(@PathParam("id") Long id) {
		productoFinancieroService.disable(id);
	}
	
}
