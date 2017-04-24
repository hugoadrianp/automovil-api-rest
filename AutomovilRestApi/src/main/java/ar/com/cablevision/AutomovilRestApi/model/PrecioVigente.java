package ar.com.cablevision.AutomovilRestApi.model;

import org.springframework.data.annotation.Id;

/**
 * Representacion para la BD mongo de la tabla de precios
 * 
 * @author Hugo Peralta
 *
 */
public class PrecioVigente {
	
	@Id
	private String id;
	
	private String item;
	private long precio;

	public PrecioVigente() {
		// TODO Auto-generated constructor stub
	}

	
	public long getPrecio() {
		return precio;
	}

	public void setPrecio(long precio) {
		this.precio = precio;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}
	
	
}
