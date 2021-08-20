package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ConsultaServicioRequest  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombreServicio;
	private String nombreProducto;
	private String codigoServicio;
	private Integer idTipoMoneda;
	private String tipoMoneda;
	private Integer montoMinimoAceptable;
	private Integer monto;
	private Integer montoMaximoAceptable;
	private Integer plazoMinimoMes;
	private Integer plazoMaximoMes;
	private Integer idDepartamento;
	private String nombreDepartamento;
	private Integer idTipoInstitucion;
	private String tipoInstitucion;
	
	
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getCodigoServicio() {
		return codigoServicio;
	}
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	public Integer getIdTipoMoneda() {
		return idTipoMoneda;
	}
	public void setIdTipoMoneda(Integer idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}
	public String getTipoMoneda() {
		return tipoMoneda;
	}
	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}
	public Integer getMontoMinimoAceptable() {
		return montoMinimoAceptable;
	}
	public void setMontoMinimoAceptable(Integer montoMinimoAceptable) {
		this.montoMinimoAceptable = montoMinimoAceptable;
	}
	public Integer getMontoMaximoAceptable() {
		return montoMaximoAceptable;
	}
	public void setMontoMaximoAceptable(Integer montoMaximoAceptable) {
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
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public Integer getIdTipoInstitucion() {
		return idTipoInstitucion;
	}
	public void setIdTipoInstitucion(Integer idTipoInstitucion) {
		this.idTipoInstitucion = idTipoInstitucion;
	}
	public String getTipoInstitucion() {
		return tipoInstitucion;
	}
	public void setTipoInstitucion(String tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}
	public Integer getMonto() {
		return monto;
	}
	public void setMonto(Integer monto) {
		this.monto = monto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	
}
