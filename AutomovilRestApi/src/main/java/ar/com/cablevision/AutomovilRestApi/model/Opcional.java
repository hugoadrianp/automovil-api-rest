/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.model;

import org.springframework.data.annotation.Id;

/**
 * Representa a los opcionales del automovil
 * 
 * 
 * @author Hugo Peralta
 *
 */
public class Opcional {
	
	@Id
	private long id;
	
	private long precio;
	private TipoOp tipo;
	
	
	/**
	 * @return the precio
	 */
	public long getPrecio() {
		return precio;
	}
	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(long precio) {
		this.precio = precio;
	}
	/**
	 * @return the tipo
	 */
	public TipoOp getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoOp tipo) {
		this.tipo = tipo;
	}
	
	

}
