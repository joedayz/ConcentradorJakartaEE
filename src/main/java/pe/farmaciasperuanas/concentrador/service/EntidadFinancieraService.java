package pe.farmaciasperuanas.concentrador.service;

import java.util.List;

import pe.farmaciasperuanas.concentrador.dto.request.EntidadFinancieraRequest;
import pe.farmaciasperuanas.concentrador.model.EntidadFinanciera;

public interface EntidadFinancieraService {
	
	List<EntidadFinanciera> findAll(EntidadFinancieraRequest request, Integer pagina);
	EntidadFinanciera findOne(Long id);
	void saveOrUpdate(EntidadFinanciera obj);
	void disable(Long id);
}
