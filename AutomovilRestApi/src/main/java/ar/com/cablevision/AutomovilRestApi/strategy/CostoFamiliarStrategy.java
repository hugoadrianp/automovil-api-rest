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
public class CostoFamiliarStrategy implements CostoFinalStrategy {

	@Autowired
	private PrecioVigenteRepository pvrepo;
	
	public PrecioVigenteRepository getPvrepo() {
		return pvrepo;
	}

	public void setPvrepo(PrecioVigenteRepository pvrepo) {
		this.pvrepo = pvrepo;
	}

	private Automovil auto;
	
	public CostoFamiliarStrategy(Automovil auto, PrecioVigenteRepository repo) {
		// TODO Auto-generated constructor stub
		this.setAuto(auto);
		this.setPvrepo(repo);
	}
	
	public long calcularCosto() {
		// TODO Auto-generated method stub
		
		long precioOpcionales= 0;
		Automovil autoFamiliar= this.getAuto();
		
		//buscar precio base y precios de los opcionales en MongoDB
		PrecioVigente pv= pvrepo.findByItem("familiar");
				
		//y los seteo en el objeto autoSedan
		autoFamiliar.setPrecioBase(pv.getPrecio());
		
		for(Opcional op: autoFamiliar.getOpcionales()) {
			//buscar en mongo precio opcionales
			pv= pvrepo.findByItem(op.getTipo().name());
			precioOpcionales= precioOpcionales + pv.getPrecio();
		}
		
		return (autoFamiliar.getPrecioBase() + precioOpcionales);
	}

	public Automovil getAuto() {
		return auto;
	}

	public void setAuto(Automovil auto) {
		this.auto = auto;
	}

}
