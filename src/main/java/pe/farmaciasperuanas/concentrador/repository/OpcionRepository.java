package pe.farmaciasperuanas.concentrador.repository;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;

import pe.farmaciasperuanas.concentrador.model.Opcion;

@Repository(forEntity = Opcion.class)
public interface OpcionRepository extends EntityRepository<Opcion, Long>{

	@Query(value = "select o from Opcion o where o.estado = true order by o.orden asc ")
	List<Opcion> listaOpcion();
}
