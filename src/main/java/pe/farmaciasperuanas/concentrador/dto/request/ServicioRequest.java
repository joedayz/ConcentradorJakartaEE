package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ServicioRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombreServicio;
	private String descripcion;
	private String codigo;
	private Double tea;
	private Double comisiones;
	private Double seguro;
	private Integer montoMinimo;
	private Integer plazoMinimo;
	
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Double getTea() {
		return tea;
	}
	public void setTea(Double tea) {
		this.tea = tea;
	}
	public Double getComisiones() {
		return comisiones;
	}
	public void setComisiones(Double comisiones) {
		this.comisiones = comisiones;
	}
	public Double getSeguro() {
		return seguro;
	}
	public void setSeguro(Double seguro) {
		this.seguro = seguro;
	}
	public Integer getMontoMinimo() {
		return montoMinimo;
	}
	public void setMontoMinimo(Integer montoMinimo) {
		this.montoMinimo = montoMinimo;
	}
	public Integer getPlazoMinimo() {
		return plazoMinimo;
	}
	public void setPlazoMinimo(Integer plazoMinimo) {
		this.plazoMinimo = plazoMinimo;
	}
}
