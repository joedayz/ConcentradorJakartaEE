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

import pe.farmaciasperuanas.concentrador.dto.request.EntidadFinancieraRequest;
import pe.farmaciasperuanas.concentrador.model.EntidadFinanciera;
import pe.farmaciasperuanas.concentrador.repository.EntidadFinancieraRepository;
import pe.farmaciasperuanas.concentrador.service.EntidadFinancieraService;
import pe.farmaciasperuanas.concentrador.util.Constantes;
import pe.farmaciasperuanas.concentrador.util.Util;

public class EntidadFinancieraServiceImpl implements EntidadFinancieraService {

	private static final Logger logger = LoggerFactory.getLogger(EntidadFinancieraServiceImpl.class);

	@Inject
	private EntidadFinancieraRepository entidadFinancieraRepository;

	@Override
	public List<EntidadFinanciera> findAll(EntidadFinancieraRequest t, Integer pagina) {
		logger.info("init list entidad financiera...");
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.DESC,"idEntidadFinanciera");
		 Page<EntidadFinanciera> page = entidadFinancieraRepository.findAll(new Specification<EntidadFinanciera>() {
			@Override
			public Predicate toPredicate(Root<EntidadFinanciera> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				predicates.add(cb.equal(root.get("activo"), true));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		 }, pageable);
		 return page.getContent();
	}

	@Override
	public EntidadFinanciera findOne(Long id) {
		logger.info("init findOne entidad financiera...");
		if(Util.isNotNull(id)) {
			return entidadFinancieraRepository.findBy(id);
		}
		return null;
	}

	@Override
	public void saveOrUpdate(EntidadFinanciera obj) {
		logger.info("init saveOrUpdate entidad financiera...");
		if(Util.isNotNull(obj.getIdEntidadFinanciera())) {
			obj.setFechaModificacion(Util.getCurrentDateTimeString());
		}
		obj.setFechaRegistro(Util.getCurrentDateTimeString());
		obj.setActivo(true);
		entidadFinancieraRepository.save(obj);
	}

	@Override
	public void disable(Long id) {
		logger.info("init disable entidad financiera...");
		if(Util.isNotNull(id)) {
			EntidadFinanciera ef = entidadFinancieraRepository.findBy(id);
			ef.setActivo(false);
			entidadFinancieraRepository.save(ef);
		}
	}
}
