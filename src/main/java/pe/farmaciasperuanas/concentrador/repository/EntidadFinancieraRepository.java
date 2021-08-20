package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.model.EntidadFinanciera;

@Repository(forEntity = EntidadFinanciera.class)
public interface EntidadFinancieraRepository extends EntityRepository<EntidadFinanciera, Long>,FullEntityViewRepository<EntidadFinanciera,
	EntidadFinanciera, Long>, Specification<EntidadFinanciera>{

}
