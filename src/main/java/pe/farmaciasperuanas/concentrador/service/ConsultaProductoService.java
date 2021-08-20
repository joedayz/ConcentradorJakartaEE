package pe.farmaciasperuanas.concentrador.service;

import java.util.List;

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaEntidadProducto;

public interface ConsultaProductoService {

	List<ConsultaEntidadProducto> consulta(ConsultaProductoFinancieroRequest request, Integer pagina);
	ConsultaEntidadProducto obtenerPorId(Long id);
	
}
