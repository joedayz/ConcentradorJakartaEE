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

import pe.farmaciasperuanas.concentrador.dto.request.ProspectoRequest;
import pe.farmaciasperuanas.concentrador.model.Prospecto;
import pe.farmaciasperuanas.concentrador.repository.ProspectoRepository;
import pe.farmaciasperuanas.concentrador.service.ProspectoService;
import pe.farmaciasperuanas.concentrador.util.Constantes;
import pe.farmaciasperuanas.concentrador.util.Util;

public class ProspectoServiceImpl implements ProspectoService{

	private static final Logger logger = LoggerFactory.getLogger(ProspectoServiceImpl.class);
	
	@Inject
	private ProspectoRepository prospectoRepository;

	@Override
	public List<Prospecto> listar(ProspectoRequest t, Integer pagina) {
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE,
				Sort.Direction.DESC,"idProspecto");
		 Page<Prospecto> page = prospectoRepository.findAll(new Specification<Prospecto>() {
			@Override
			public Predicate toPredicate(Root<Prospecto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if(Util.isNotNull(t.getNumeroDocumento())) {
					predicates.add(cb.and(cb.like(root.get("numeroDocumento"),
							"%".concat(t.getNumeroDocumento().concat("%")))));
				}
				if(Util.isNotNull(t.getNumeroCelular())) {
					predicates.add(cb.and(cb.like(root.get("numeroCelular"),
							"%".concat(t.getNumeroCelular().concat("%")))));
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		 }, pageable);
		 return page.getContent();
	}

	@Override
	public Prospecto findOne(Long id) {
		logger.info("init findOne entidad financiera...");
		if(Util.isNotNull(id)) {
			return prospectoRepository.findBy(id);
		}
		return null;
	}

	@Override
	public void saveOrUpdate(Prospecto obj) {
		logger.info("init saveOrUpdate entidad financiera...");
		obj.setFechaRegistro(Util.getCurrentDateTimeString());
		obj.setActivo(true);
		prospectoRepository.save(obj);
		
	}

	@Override
	public void disable(Long id) {
		logger.info("init disable entidad financiera...");
		if(Util.isNotNull(id)) {
			Prospecto ef = prospectoRepository.findBy(id);
			ef.setActivo(false);
			prospectoRepository.save(ef);
		}
		
	}
	
}
