package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ConsultaMovimientoRequest implements Serializable{

private static final long serialVersionUID = 1L;
	
	private Integer idEntidad;
	private Integer idProducto;
	private String fechaDesde;
	private String fechaHasta;
	
	public Integer getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
}
