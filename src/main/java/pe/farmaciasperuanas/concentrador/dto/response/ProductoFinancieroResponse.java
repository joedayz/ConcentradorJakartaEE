package pe.farmaciasperuanas.concentrador.dto.response;

import java.io.Serializable;

public class ProductoFinancieroResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idProductoFinanciero;
	private String nombre;
	private String observacion;
	private Integer plazoMinimoDia;
	private Integer plazoMaximoDia;
	private Double porcentajeTea;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public Integer getPlazoMinimoDia() {
		return plazoMinimoDia;
	}
	public void setPlazoMinimoDia(Integer plazoMinimoDia) {
		this.plazoMinimoDia = plazoMinimoDia;
	}
	public Integer getPlazoMaximoDia() {
		return plazoMaximoDia;
	}
	public void setPlazoMaximoDia(Integer plazoMaximoDia) {
		this.plazoMaximoDia = plazoMaximoDia;
	}
	public Double getPorcentajeTea() {
		return porcentajeTea;
	}
	public void setPorcentajeTea(Double porcentajeTea) {
		this.porcentajeTea = porcentajeTea;
	}
	public Long getIdProductoFinanciero() {
		return idProductoFinanciero;
	}
	public void setIdProductoFinanciero(Long idProductoFinanciero) {
		this.idProductoFinanciero = idProductoFinanciero;
	}
	
}
