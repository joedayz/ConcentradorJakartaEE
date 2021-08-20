package pe.farmaciasperuanas.concentrador.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import com.blazebit.persistence.deltaspike.data.FullEntityViewRepository;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.model.ProductoFinanciero;

@Repository(forEntity = ProductoFinanciero.class)
public interface ProductoFinancieroRepository  extends EntityRepository<ProductoFinanciero, Long>,
	FullEntityViewRepository<ProductoFinanciero, ProductoFinanciero, Long>, Specification<ProductoFinanciero>{

}
