/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;
import ar.com.cablevision.AutomovilRestApi.service.AutomovilService;

/**
 * Clase que controla los request al servicio rest
 * en sus diferentes operaciones
 * 
 * @author Hugo Peralta
 *
 */
@RestController
@RequestMapping("/api")
public class AutomovilController {

	@Autowired
	AutomovilService automovilService;
	
	/**
	 * Recupera todos los automoviles de la BD Mongo
	 *  
	 * @return lista de automoviles
	 */
    @RequestMapping(value = "/automovil/", method = RequestMethod.GET)
    public ResponseEntity<List<Automovil>> listAllAutomoviles() {
        List<Automovil> autos = automovilService.findAll();
        if (autos.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Automovil>>(autos, HttpStatus.OK);
    }
 
    /**
     * Recupera un automovil por su id
     *  
     * @param id
     * @return automovil
     */
    @RequestMapping(value = "/automovil/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAutomovil(@PathVariable("id") String id) {
        
    	Automovil auto = automovilService.findById(id);
        if (auto == null) {
           return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Automovil>(auto, HttpStatus.OK);
    }
 
    
    /**
     * Crear un automovil e indica la location y id donde se creo
     * 
     * @param auto
     * @param ucBuilder
     * @return String json
     */
    @RequestMapping(value = "/automovil/", method = RequestMethod.POST)
    public ResponseEntity<?> createAutomovil(@RequestBody Automovil auto, UriComponentsBuilder ucBuilder) {
         
//        if (automovilService.isAutomovilExist(auto)) {
//            return new ResponseEntity(HttpStatus.CONFLICT);
//        }
        automovilService.saveAutomovil(auto);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/automovil/{id}").buildAndExpand(auto.getId()).toUri());
        
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    
    /**
     * Actualiza la informacion de un automovil dado su id
     * 
     * @param id
     * @param auto
     * @return String json
     */
    @RequestMapping(value = "/automovil/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateAutomovil(@PathVariable("id") String id, @RequestBody Automovil auto) {
       
    	Automovil autoActual = automovilService.findById(id);
 
        if (autoActual == null) {
           return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
 
        auto.setId(autoActual.getId());       
        automovilService.deleteAutomovil(autoActual);
        
//        autoActual.setNombre(auto.getNombre());
//        autoActual.setCostoFinal(auto.getCostoFinal());
//        autoActual.setOpcionales(auto.getOpcionales());
//        autoActual.setPrecioBase(auto.getPrecioBase());
 
//        automovilService.updateAutomovil(autoActual);
        
        automovilService.updateAutomovil(auto);
        return new ResponseEntity<Automovil>(autoActual, HttpStatus.OK);
    }
 
    
    /**
     * Elimina un automovil dado su id
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/automovil/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAutomovil(@PathVariable("id") String id) {
        
        Automovil auto = automovilService.findById(id);
        if (auto == null) {
           return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        automovilService.deleteAutomovil(auto);
        return new ResponseEntity<Automovil>(HttpStatus.NO_CONTENT);
    }
 
    
    /**
     * Elimina todos los automoviles existentes
     * 
     * @return
     */
    @RequestMapping(value = "/automovil/", method = RequestMethod.DELETE)
    public ResponseEntity<Automovil> deleteAll() {
       
    	automovilService.deleteAll();;
        return new ResponseEntity<Automovil>(HttpStatus.NO_CONTENT);
    }
	
}
