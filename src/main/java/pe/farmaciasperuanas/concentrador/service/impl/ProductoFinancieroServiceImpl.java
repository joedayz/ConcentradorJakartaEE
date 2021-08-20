package pe.farmaciasperuanas.concentrador.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

import pe.farmaciasperuanas.concentrador.dto.request.ProductoFinancieroRequest;
import pe.farmaciasperuanas.concentrador.dto.response.CollectionResponse;
import pe.farmaciasperuanas.concentrador.dto.response.ProductoFinancieroResponse;
import pe.farmaciasperuanas.concentrador.model.ProductoFinanciero;
import pe.farmaciasperuanas.concentrador.repository.ProductoFinancieroRepository;
import pe.farmaciasperuanas.concentrador.service.ProductoFinancieroService;
import pe.farmaciasperuanas.concentrador.util.Constantes;
import pe.farmaciasperuanas.concentrador.util.Util;

public class ProductoFinancieroServiceImpl implements ProductoFinancieroService {

	private static final Logger logger = LoggerFactory.getLogger(ProductoFinancieroServiceImpl.class);

	@Inject
	private ProductoFinancieroRepository productoFinancieroRepository;

	@Override
	public List<ProductoFinanciero> findAll(ProductoFinancieroRequest request, Integer pagina) {
		logger.info("init list producto financiero..");
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.DESC,
				"idProductoFinanciero");
		Page<ProductoFinanciero> page = productoFinancieroRepository.findAll(new Specification<ProductoFinanciero>() {
			@Override
			public Predicate toPredicate(Root<ProductoFinanciero> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (Util.isNotNull(request.getIdTipoProducto())) {
					predicates.add(cb.and(cb.equal(root.get("idTipoProducto"), request.getIdTipoProducto())));
				}
				predicates.add(cb.equal(root.get(Constantes.ACTIVO), true));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		return page.getContent();
	}

	@Override
	public ProductoFinanciero findOne(Long id) {
		logger.info("init findOne producto financiero...");
		if (Util.isNotNull(id)) {
			return productoFinancieroRepository.findBy(id);
		}
		return null;
	}

	@Override
	public void saveProducto(ProductoFinanciero producto) {
		logger.info("init save producto financiero");
		if (Util.isNotNull(producto.getIdProductoFinanciero())) {
			producto.setFechaModificacion(Util.getCurrentDateTimeString());
		}
		producto.setFechaRegistro(Util.getCurrentDateTimeString());
		producto.setActivo(true);
		producto.getDetalleProducto().forEach(det -> det.setProductoFinanciero(producto));
		productoFinancieroRepository.save(producto);
	}

	@Override
	public void disable(Long id) {
		logger.info("init disable producto financiero...");
		if (Util.isNotNull(id)) {
			ProductoFinanciero pf = productoFinancieroRepository.findBy(id);
			pf.setActivo(false);
			productoFinancieroRepository.save(pf);
		}
	}

	@Override
	public CollectionResponse<ProductoFinancieroResponse> findAllDeposito(Integer pagina) {
		logger.info("init list deposito ...");
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.DESC,
				"idProductoFinanciero");
		CollectionResponse<ProductoFinancieroResponse> response = new CollectionResponse<>();
		List<ProductoFinancieroResponse> listaDto = Util.listObjectToListObject(ProductoFinancieroResponse.class, 
				this.filtroProductoFinancuero(Constantes.DEPOSITO_PLAZO, pageable).stream().collect(Collectors.toList()));
		response.setElementos(listaDto);
		return response;
	}

	private List<ProductoFinanciero> filtroProductoFinancuero(Integer tipoProductoFinanciero, Pageable pageable) {
		Page<ProductoFinanciero> page = productoFinancieroRepository.findAll(new Specification<ProductoFinanciero>() {
			@Override
			public Predicate toPredicate(Root<ProductoFinanciero> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (Util.isNotNull(tipoProductoFinanciero)) {
					predicates.add(cb.and(cb.equal(root.get("idTipoProducto"), tipoProductoFinanciero)));
				}
				predicates.add(cb.equal(root.get("activo"), true));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		return page.getContent();
	}

	@Override
	public List<ProductoFinanciero> findAllPrestamo(ProductoFinancieroRequest request, Integer pagina) {
		logger.info("init list producto financiero...");
		Pageable pageable = new PageRequest(pagina, Constantes.PAGINATION_SIZE, Sort.Direction.DESC,
				"idProductoFinanciero");
		Page<ProductoFinanciero> page = productoFinancieroRepository.findAll(new Specification<ProductoFinanciero>() {
			@Override
			public Predicate toPredicate(Root<ProductoFinanciero> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (Util.isNotNull(request.getIdTipoProducto())) {
					predicates.add(cb.and(cb.equal(root.get("idTipoProducto"), request.getIdTipoProducto())));
				}
				predicates.add(cb.equal(root.get("activo"), true));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}, pageable);
		return page.getContent();
	}
}
