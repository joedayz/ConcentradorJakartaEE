package pe.farmaciasperuanas.concentrador.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.blazebit.persistence.deltaspike.data.Page;
import com.blazebit.persistence.deltaspike.data.PageRequest;
import com.blazebit.persistence.deltaspike.data.Pageable;
import com.blazebit.persistence.deltaspike.data.Sort;
import com.blazebit.persistence.deltaspike.data.Specification;

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaMovimientoRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaMovimiento;
import pe.farmaciasperuanas.concentrador.repository.ConsultaMovimientoRepository;
import pe.farmaciasperuanas.concentrador.service.ConsultaMovimientoService;
import pe.farmaciasperuanas.concentrador.util.Constantes;
import pe.farmaciasperuanas.concentrador.util.Util;

public class ConsultaMovimientoServiceImpl implements ConsultaMovimientoService{

	private static final Logger logger = LoggerFactory.getLogger(ConsultaMovimientoServiceImpl.class);

	@Inject
	private ConsultaMovimientoRepository consultaMovimientoRepository;

	@Override
	public List<ConsultaMovimiento> consulta(ConsultaMovimientoRequest t, Integer pagina) {
		logger.info("init consulta movimiento ..");
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.ASC,"idDetalle");
		 Page<ConsultaMovimiento> page = consultaMovimientoRepository.findAll(new Specification<ConsultaMovimiento>() {

			@Override
			public Predicate toPredicate(Root<ConsultaMovimiento> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(Util.isNotNull(t.getIdEntidad())) {
					predicates.add(cb.and(cb.equal(root.get("idEntidadFinanciera"),t.getIdEntidad())));
				}
				if(Util.isNotNull(t.getIdProducto())) {
					predicates.add(cb.and(cb.equal(root.get("idProductoFinanciero"),t.getIdProducto())));
				}
				if(Util.isNotNull(t.getFechaDesde()) && !Util.isNotNull(t.getFechaHasta())) {
					predicates.add(cb.and(cb.like(root.get("fechaRegistro"), "%".concat(t.getFechaDesde().concat("%")))));
				}
				if(Util.isNotNull(t.getFechaDesde()) && Util.isNotNull(t.getFechaHasta())) {
					predicates.add(cb.and(cb.between(root.get("fechaRegistro"), 
							t.getFechaDesde(), t.getFechaHasta())));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		 }, pageable);
		 return page.getContent();
	}
	
}
