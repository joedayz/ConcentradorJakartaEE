package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ProspectoRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String numeroDocumento;
	private String numeroCelular;
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
}
