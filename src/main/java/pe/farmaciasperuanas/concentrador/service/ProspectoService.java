package pe.farmaciasperuanas.concentrador.service;

import java.util.List;

import pe.farmaciasperuanas.concentrador.dto.request.ProspectoRequest;
import pe.farmaciasperuanas.concentrador.model.Prospecto;

public interface ProspectoService {

	List<Prospecto> listar(ProspectoRequest request, Integer pagina);
	Prospecto findOne(Long id);
	void saveOrUpdate(Prospecto obj);
	void disable(Long id);

}
