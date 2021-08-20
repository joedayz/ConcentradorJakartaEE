package pe.farmaciasperuanas.concentrador.dto.request;

import java.io.Serializable;

public class ProductoFinancieroRequest implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;
	private Integer idTipoProducto;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdTipoProducto() {
		return idTipoProducto;
	}
	public void setIdTipoProducto(Integer idTipoProducto) {
		this.idTipoProducto = idTipoProducto;
	}
	
}
