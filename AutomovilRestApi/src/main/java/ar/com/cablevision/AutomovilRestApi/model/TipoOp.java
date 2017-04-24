/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.model;

/**
 * Representa a los tipos de opcionales del automovil
 * 
 * @author Hugo Peralta
 *
 */
public enum TipoOp {
	
	TC("Techo Corredizo"),
	AA("Aire Acondicionado"),
	ABS("Sistemas de frenos ABS"), 
	AB("Airbag"), 
	LL("Llantas de aleacion");
	
	private String descripcion;
	
	TipoOp(String descrip) {
		this.setDescripcion(descrip);
	}

	
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
