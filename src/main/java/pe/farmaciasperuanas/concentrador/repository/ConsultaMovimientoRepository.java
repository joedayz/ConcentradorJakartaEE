package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.model.views.ConsultaMovimiento;

@Repository(forEntity = ConsultaMovimiento.class)
public interface ConsultaMovimientoRepository extends FullEntityViewRepository<ConsultaMovimiento,
ConsultaMovimiento, Long>, Specification<ConsultaMovimiento> {

}
