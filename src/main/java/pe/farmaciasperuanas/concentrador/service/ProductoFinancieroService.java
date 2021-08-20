package pe.farmaciasperuanas.concentrador.service;

import java.util.List;

import pe.farmaciasperuanas.concentrador.dto.request.ProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.dto.response.CollectionResponse;
import pe.farmaciasperuanas.concentrador.dto.response.ProductoFinancieroResponse;
import pe.farmaciasperuanas.concentrador.model.ProductoFinanciero;

public interface ProductoFinancieroService {

	List<ProductoFinanciero> findAll(ProductoFinancieroRequest request, Integer pagina);
	List<ProductoFinanciero> findAllPrestamo(ProductoFinancieroRequest request, Integer pagina);
	CollectionResponse<ProductoFinancieroResponse> findAllDeposito(Integer pagina);
	ProductoFinanciero findOne(Long id);
	void saveProducto(ProductoFinanciero producto);
	void disable(Long id);

}
