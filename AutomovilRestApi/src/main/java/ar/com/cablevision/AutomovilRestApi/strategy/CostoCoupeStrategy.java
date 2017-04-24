/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;
import ar.com.cablevision.AutomovilRestApi.model.Opcional;
import ar.com.cablevision.AutomovilRestApi.model.PrecioVigente;
import ar.com.cablevision.AutomovilRestApi.mongodb.repository.PrecioVigenteRepository;

/**
 * Implementacion de la strategy
 * Se paso el repositorio de precios vigentes para obtener los que sean necesarios
 * 
 * @author Hugo Peralta
 *
 */
public class CostoCoupeStrategy implements CostoFinalStrategy {

	@Autowired
	private PrecioVigenteRepository pvrepo;
	
	public PrecioVigenteRepository getPvrepo() {
		return pvrepo;
	}

	public void setPvrepo(PrecioVigenteRepository pvrepo) {
		this.pvrepo = pvrepo;
	}

	private Automovil auto;
	
	public CostoCoupeStrategy(Automovil auto, PrecioVigenteRepository repo) {
		// TODO Auto-generated constructor stub
		this.setAuto(auto);
		this.setPvrepo(repo);
	}
	
	public long calcularCosto() {
		// TODO Auto-generated method stub
		
		long precioOpcionales= 0;
		Automovil autoCoupe= this.getAuto();
		
		//buscar precio base y precios de los opcionales en MongoDB
		PrecioVigente pv= pvrepo.findByItem("coupe");
				
		//y los seteo en el objeto autoSedan
		autoCoupe.setPrecioBase(pv.getPrecio());
		
		for(Opcional op: autoCoupe.getOpcionales()) {
			//buscar en mongo precio opcionales
			pv= pvrepo.findByItem(op.getTipo().name());
			precioOpcionales= precioOpcionales + pv.getPrecio();
		}
		
		return (autoCoupe.getPrecioBase() + precioOpcionales);
	}

	public Automovil getAuto() {
		return auto;
	}

	public void setAuto(Automovil auto) {
		this.auto = auto;
	}

}
