package pe.farmaciasperuanas.concentrador.service;

import java.util.List;

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaMovimientoRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaMovimiento;

public interface ConsultaMovimientoService {

	List<ConsultaMovimiento> consulta(ConsultaMovimientoRequest request, Integer pagina);

}
