package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.model.Prospecto;

@Repository(forEntity = Prospecto.class)
public interface ProspectoRepository extends EntityRepository<Prospecto, Long>, FullEntityViewRepository<Prospecto,
Prospecto, Long>, Specification<Prospecto>{

}
