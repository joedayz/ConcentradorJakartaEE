package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ConsultaProductoFinancieroRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Prestamo
	private Integer codigoProductoFinanciero;
	private Integer idTipoMoneda;
	private Double montoMinimoAceptable;
	private Double montoMaximoAceptable;
	private Integer plazoMinimoMes;
	private Integer plazoMaximoMes;
	private Integer ingresoPermitido;
	private Integer idDepartamento;
	private Integer idTipoInstitucion;
	
	// Deposito
	private Integer montoMinimoDeposito;
	private Integer montoMaximoDeposito;
	private Integer plazoMinimoDia;
	private Integer plazoMaximoDia;
	
	
	public Integer getIdTipoMoneda() {
		return idTipoMoneda;
	}
	public void setIdTipoMoneda(Integer idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}
	public Double getMontoMinimoAceptable() {
		return montoMinimoAceptable;
	}
	public void setMontoMinimoAceptable(Double montoMinimoAceptable) {
		this.montoMinimoAceptable = montoMinimoAceptable;
	}
	public Double getMontoMaximoAceptable() {
		return montoMaximoAceptable;
	}
	public void setMontoMaximoAceptable(Double montoMaximoAceptable) {
		this.montoMaximoAceptable = montoMaximoAceptable;
	}
	public Integer getPlazoMinimoMes() {
		return plazoMinimoMes;
	}
	public void setPlazoMinimoMes(Integer plazoMinimoMes) {
		this.plazoMinimoMes = plazoMinimoMes;
	}
	public Integer getPlazoMaximoMes() {
		return plazoMaximoMes;
	}
	public void setPlazoMaximoMes(Integer plazoMaximoMes) {
		this.plazoMaximoMes = plazoMaximoMes;
	}
	public Integer getIngresoPermitido() {
		return ingresoPermitido;
	}
	public void setIngresoPermitido(Integer ingresoPermitido) {
		this.ingresoPermitido = ingresoPermitido;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public Integer getIdTipoInstitucion() {
		return idTipoInstitucion;
	}
	public void setIdTipoInstitucion(Integer idTipoInstitucion) {
		this.idTipoInstitucion = idTipoInstitucion;
	}
	public Integer getMontoMinimoDeposito() {
		return montoMinimoDeposito;
	}
	public void setMontoMinimoDeposito(Integer montoMinimoDeposito) {
		this.montoMinimoDeposito = montoMinimoDeposito;
	}
	public Integer getMontoMaximoDeposito() {
		return montoMaximoDeposito;
	}
	public void setMontoMaximoDeposito(Integer montoMaximoDeposito) {
		this.montoMaximoDeposito = montoMaximoDeposito;
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
	public Integer getCodigoProductoFinanciero() {
		return codigoProductoFinanciero;
	}
	public void setCodigoProductoFinanciero(Integer codigoProductoFinanciero) {
		this.codigoProductoFinanciero = codigoProductoFinanciero;
	}
	
	
}
