/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.service;

import java.util.List;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;

/**
 * Capa de servicios para menejar  los repositorios de mongodb
 * 
 * @author Hugo Peralta
 *
 */
public interface AutomovilService {
	
	Automovil findById(String id);
    Automovil findByName(String name);
    List<Automovil> findAll();
    
    void saveAutomovil(Automovil auto);
    void updateAutomovil(Automovil auto);
    void deleteAutomovil(Automovil auto);
      
    void deleteAll();
    boolean isAutomovilExist(Automovil auto);

}
