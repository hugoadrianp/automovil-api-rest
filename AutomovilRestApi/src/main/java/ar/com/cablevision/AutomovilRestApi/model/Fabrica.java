/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.model;

import java.util.List;

import ar.com.cablevision.AutomovilRestApi.strategy.CostoFinalStrategy;

/**
 * Representacion del contexto que incluye los strategy para su invocacion
 * 
 * @author Hugo Peralta
 *
 */
public class Fabrica {

	private List<Automovil> automoviles;
	
	public Fabrica() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Calcula el costo final del automovil segun el modelo y sus variantes
	 * 
	 * @param costoFinal
	 * @return long
	 */
	public long costoFinalAutomovil(CostoFinalStrategy costoFinal) {
		return (costoFinal.calcularCosto());
	}
	
	//----------------------------------------------
	/**
	 * @return the automoviles
	 */
	public List<Automovil> getAutomoviles() {
		return automoviles;
	}

	/**
	 * @param automoviles the automoviles to set
	 */
	public void setAutomoviles(List<Automovil> automoviles) {
		this.automoviles = automoviles;
	}
	
}
