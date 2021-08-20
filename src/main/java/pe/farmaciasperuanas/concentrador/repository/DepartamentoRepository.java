package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;

import pe.farmaciasperuanas.concentrador.model.Departamento;

@Repository(forEntity = Departamento.class)
public interface DepartamentoRepository extends FullEntityViewRepository<Departamento, Departamento, Long>{

}
