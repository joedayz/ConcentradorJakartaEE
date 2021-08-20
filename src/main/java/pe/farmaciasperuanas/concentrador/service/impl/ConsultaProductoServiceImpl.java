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

import pe.farmaciasperuanas.concentrador.dto.request.ConsultaProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.model.views.ConsultaEntidadProducto;
import pe.farmaciasperuanas.concentrador.repository.ConsultaEntidadProductoRepository;
import pe.farmaciasperuanas.concentrador.service.ConsultaProductoService;
import pe.farmaciasperuanas.concentrador.util.Constantes;
import pe.farmaciasperuanas.concentrador.util.Util;

public class ConsultaProductoServiceImpl implements ConsultaProductoService {

	private static final Logger logger = LoggerFactory.getLogger(ConsultaProductoServiceImpl.class);

	@Inject
	private ConsultaEntidadProductoRepository consultaProductoRepository;

	@Override
	public List<ConsultaEntidadProducto> consulta(ConsultaProductoFinancieroRequest t, Integer pagina) {
		logger.info("init consulta ..");
		
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.ASC,"idConsultaEntidadProducto");
		 Page<ConsultaEntidadProducto> page = consultaProductoRepository.findAll(new Specification<ConsultaEntidadProducto>() {

			@Override
			public Predicate toPredicate(Root<ConsultaEntidadProducto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(Util.isNotNull(t.getCodigoProductoFinanciero())) {
					predicates.add(cb.and(cb.equal(root.get("idTipoProducto"),t.getCodigoProductoFinanciero())));
				}
				if(Util.isNotNull(t.getIdTipoMoneda())) {
					predicates.add(cb.and(cb.equal(root.get("idMoneda"),t.getIdTipoMoneda())));
				}
				if(Util.isNotNull(t.getMontoMaximoAceptable())) {
					predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get("montoMaximoPrestamo"),t.getMontoMaximoAceptable())));
				}
				if(Util.isNotNull(t.getPlazoMaximoMes())) {
					predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get("plazoMaximoMes"),t.getPlazoMaximoMes())));
				}
				if(Util.isNotNull(t.getIngresoPermitido())) {
					predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get("ingresoPermitido"),t.getIngresoPermitido())));
				}
				if(Util.isNotNull(t.getIdDepartamento())) {
					predicates.add(cb.and(cb.equal(root.get("idDepartamento"),t.getIdDepartamento())));
				}
				if(Util.isNotNull(t.getIdTipoInstitucion())) {
					predicates.add(cb.and(cb.equal(root.get("idTipoInstitucion"),t.getIdTipoInstitucion())));
				}
				if(Util.isNotNull(t.getMontoMaximoDeposito())) {
					predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get("montoMaximoDeposito"),t.getMontoMaximoDeposito())));
				}
				if(Util.isNotNull(t.getPlazoMaximoDia())) {
					predicates.add(cb.and(cb.greaterThanOrEqualTo(root.get("plazoMaximoDia"),t.getPlazoMaximoDia())));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		 }, pageable);
		 return page.getContent();
	}

	@Override
	public ConsultaEntidadProducto obtenerPorId(Long id) {
		return consultaProductoRepository.findBy(id);
	}
}
