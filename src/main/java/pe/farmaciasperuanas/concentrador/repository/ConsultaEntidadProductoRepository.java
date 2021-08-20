package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.model.views.ConsultaEntidadProducto;

@Repository(forEntity = ConsultaEntidadProducto.class)
public interface ConsultaEntidadProductoRepository extends FullEntityViewRepository<ConsultaEntidadProducto,
	ConsultaEntidadProducto, Long>, Specification<ConsultaEntidadProducto> {

}
