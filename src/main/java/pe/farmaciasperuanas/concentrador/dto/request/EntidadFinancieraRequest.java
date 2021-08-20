package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class EntidadFinancieraRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String razonSocial;
	private String numeroDocumento;
	
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
}
