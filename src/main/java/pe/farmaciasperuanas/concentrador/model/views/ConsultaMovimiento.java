package pe.farmaciasperuanas.concentrador.model.views;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_consulta_movimiento")
public class ConsultaMovimiento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_detalle")
	private Long idDetalle;
	
	@Column(name = "id_producto_financiero")
	private Integer idProductoFinanciero;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="id_entidad_financiera")
	private Integer idEntidadFinanciera;
	 
	@Column(name="fecha_registro")
	private String fechaRegistro;
	
	@Column(name="nombre_comercial")
	private String nombreComercial;
	
	@Column(name="porcentaje_tea")
	private Double porcentajeTea;
	 
	@Column(name="moneda")
	private String moneda;
	
	@Column(name="monto_maximo_deposito")
	private Double montoMaximoDeposito;
	
	@Column(name="monto_maximo_prestamo")
	private Double montoMaximoPrestamo;
	
	@Column(name="plazo_maximo_mes")
	private Integer plazoMaximoMes;
	
	@Column(name="activo")
	private Boolean activo;

	public Integer getIdProductoFinanciero() {
		return idProductoFinanciero;
	}

	public void setIdProductoFinanciero(Integer idProductoFinanciero) {
		this.idProductoFinanciero = idProductoFinanciero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public Double getPorcentajeTea() {
		return porcentajeTea;
	}

	public void setPorcentajeTea(Double porcentajeTea) {
		this.porcentajeTea = porcentajeTea;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Double getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}

	public void setMontoMaximoDeposito(Double montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
	}

	public Double getMontoMaximoPrestamo() {
		return montoMaximoPrestamo;
	}

	public void setMontoMaximoPrestamo(Double montoMaximoPrestamo) {
		this.montoMaximoPrestamo = montoMaximoPrestamo;
	}

	public Integer getPlazoMaximoMes() {
		return plazoMaximoMes;
	}

	public void setPlazoMaximoMes(Integer plazoMaximoMes) {
		this.plazoMaximoMes = plazoMaximoMes;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Integer getIdEntidadFinanciera() {
		return idEntidadFinanciera;
	}

	public void setIdEntidadFinanciera(Integer idEntidadFinanciera) {
		this.idEntidadFinanciera = idEntidadFinanciera;
	}

	public Long getIdDetalle() {
		return idDetalle;
	}

	public void setIdDetalle(Long idDetalle) {
		this.idDetalle = idDetalle;
	}
	
	
}
