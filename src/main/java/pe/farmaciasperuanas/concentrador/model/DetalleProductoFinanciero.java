package pe.farmaciasperuanas.concentrador.model;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_producto_financiero")
public class DetalleProductoFinanciero implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_producto_financiero")
	private Long idDelleProductoFinanciero;

	@Column(name="id_tipo_moneda")
	private Integer idTipoMoneda;
	
	@Column(name="ingreso_permitido")
	private Integer ingresoPermitido;
	
	@Column(name="monto_minimo_prestamo")
	private Double montoMinimoPrestamo;
	
	@Column(name="monto_maximo_prestamo")
	private Double montoMaximoPrestamo;
	
	@Column(name="monto_minimo_deposito")
	private Double montoMinimoDeposito;
	
	@Column(name="monto_maximo_deposito")
	private Double montoMaximoDeposito;
	
	// Equivalente a @JsonIgnore (Spring Boot)
	@JsonbTransient
	@ManyToOne
	@JoinColumn(name = "id_producto_financiero", nullable = false)
	private ProductoFinanciero productoFinanciero;

	public Long getIdDelleProductoFinanciero() {
		return idDelleProductoFinanciero;
	}

	public void setIdDelleProductoFinanciero(Long idDelleProductoFinanciero) {
		this.idDelleProductoFinanciero = idDelleProductoFinanciero;
	}

	public Integer getIdTipoMoneda() {
		return idTipoMoneda;
	}

	public void setIdTipoMoneda(Integer idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}

	public Integer getIngresoPermitido() {
		return ingresoPermitido;
	}

	public void setIngresoPermitido(Integer ingresoPermitido) {
		this.ingresoPermitido = ingresoPermitido;
	}

	public Double getMontoMinimoPrestamo() {
		return montoMinimoPrestamo;
	}

	public void setMontoMinimoPrestamo(Double montoMinimoPrestamo) {
		this.montoMinimoPrestamo = montoMinimoPrestamo;
	}

	public Double getMontoMaximoPrestamo() {
		return montoMaximoPrestamo;
	}

	public void setMontoMaximoPrestamo(Double montoMaximoPrestamo) {
		this.montoMaximoPrestamo = montoMaximoPrestamo;
	}

	public Double getMontoMinimoDeposito() {
		return montoMinimoDeposito;
	}

	public void setMontoMinimoDeposito(Double montoMinimoDeposito) {
		this.montoMinimoDeposito = montoMinimoDeposito;
	}

	public Double getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}

	public void setMontoMaximoDeposito(Double montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
	}

	public ProductoFinanciero getProductoFinanciero() {
		return productoFinanciero;
	}

	public void setProductoFinanciero(ProductoFinanciero productoFinanciero) {
		this.productoFinanciero = productoFinanciero;
	}
	
}
