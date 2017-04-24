/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;
import ar.com.cablevision.AutomovilRestApi.model.Fabrica;
import ar.com.cablevision.AutomovilRestApi.mongodb.repository.AutomovilRepository;
import ar.com.cablevision.AutomovilRestApi.mongodb.repository.PrecioVigenteRepository;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoCoupeStrategy;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoFamiliarStrategy;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoSedanStrategy;

/**
 * Implementacion de la capa de servicios
 * 
 * @author Hugo Peralta
 *
 */
@Service("automovilService")
public class AutomovilServiceImpl implements AutomovilService {
	
	@Autowired
	private AutomovilRepository autoRepository;
	
	@Autowired
	private PrecioVigenteRepository pvrepo;
	
	public Automovil findById(String id) {
		// TODO Auto-generated method stub
		return autoRepository.findById(id);
	}

	public Automovil findByName(String name) {
		// TODO Auto-generated method stub
		return autoRepository.findOne(name);
	}

	public List<Automovil> findAll() {
		// TODO Auto-generated method stub
		return autoRepository.findAll();
	}

	/**
	 * Guarda un automovil en la db y previamente calcula el costo final incluyendolo en el automovil
	 * 
	 */
	public void saveAutomovil(Automovil auto) {
		// TODO Auto-generated method stub
		Fabrica fabrica= new Fabrica();
		fabrica.setAutomoviles(new ArrayList<Automovil>());
		fabrica.getAutomoviles().add(auto);
		
		if(auto.getNombre().equalsIgnoreCase("sedan")) {
			auto.setCostoFinal(fabrica.costoFinalAutomovil(new CostoSedanStrategy(auto, pvrepo)));
		}else if(auto.getNombre().equalsIgnoreCase("coupe")) {
			auto.setCostoFinal(fabrica.costoFinalAutomovil(new CostoCoupeStrategy(auto, pvrepo)));
		}else {//es familiar
			auto.setCostoFinal(fabrica.costoFinalAutomovil(new CostoFamiliarStrategy(auto, pvrepo)));
		}
				
		autoRepository.save(auto);
	}

	public void updateAutomovil(Automovil auto) {
		// TODO Auto-generated method stub
		
//		autoRepository.update(auto);
		autoRepository.save(auto);//lo salva previo a haber eliminado el viejo porque el crud repository de mongodb no tiene operacion "update"
	}

	public void deleteAutomovil(Automovil auto) {
		// TODO Auto-generated method stub
		autoRepository.delete(auto);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		autoRepository.deleteAll();
	}

	public boolean isAutomovilExist(Automovil auto) {
		// TODO Auto-generated method stub
//		autoRepository.exists(arg0);
		return false;
	}

	
	//------------------------------ GETTERS Y SETTERS ----------------------------
	public AutomovilRepository getAutoRepository() {
		return autoRepository;
	}

	public void setAutoRepository(AutomovilRepository autoRepository) {
		this.autoRepository = autoRepository;
	}

}
