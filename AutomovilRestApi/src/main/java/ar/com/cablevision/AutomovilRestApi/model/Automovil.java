/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.model;

import java.util.List;

import org.springframework.data.annotation.Id;

/**
 * Clase de dominio que representa un automovil
 * 
 * @author Hugo Peralta
 *
 */
public class Automovil {
	
	@Id
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String nombre;
	private long precioBase;
	private List<Opcional> opcionales;
	private long costoFinal;
	
		
	//-----------------------------------------------------------
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the precioBase
	 */
	public long getPrecioBase() {
		return precioBase;
	}
	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(long precioBase) {
		this.precioBase = precioBase;
	}
	/**
	 * @return the opcionales
	 */
	public List<Opcional> getOpcionales() {
		return opcionales;
	}
	/**
	 * @param opcionales the opcionales to set
	 */
	public void setOpcionales(List<Opcional> opcionales) {
		this.opcionales = opcionales;
	}
	public long getCostoFinal() {
		return costoFinal;
	}
	public void setCostoFinal(long costoFinal) {
		this.costoFinal = costoFinal;
	}
	
	
	

}
