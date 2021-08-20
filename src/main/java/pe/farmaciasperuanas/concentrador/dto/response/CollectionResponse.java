package pe.farmaciasperuanas.concentrador.dto.response;

import java.io.Serializable;
import java.util.List;

public class CollectionResponse<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<T> elementos;
	private Integer totalElementos;
	private Integer totalPaginas;
	private Integer paginaActual;	
	
	public List<T> getElementos() {
		return elementos;
	}
	public void setElementos(List<T> elementos) {
		this.elementos = elementos;
	}
	public Integer getTotalElementos() {
		return totalElementos;
	}
	public void setTotalElementos(Integer totalElementos) {
		this.totalElementos = totalElementos;
	}
	public Integer getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(Integer totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	public Integer getPaginaActual() {
		return paginaActual;
	}
	public void setPaginaActual(Integer paginaActual) {
		this.paginaActual = paginaActual;
	}
	
}
