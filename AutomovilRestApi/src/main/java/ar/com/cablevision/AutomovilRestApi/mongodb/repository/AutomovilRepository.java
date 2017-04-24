/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;

/**
 * Definicion del repositorio de mongodb para manejar automoviles
 * 
 * @author Hugo Peralta
 *
 */
@RepositoryRestResource(collectionResourceRel = "automovil", path = "automovil")
public interface AutomovilRepository extends MongoRepository<Automovil, String> {
	
	Automovil save(Automovil auto);
	void delete(Automovil auto);
	
	List<Automovil> findAll();
	Automovil findById(@Param("id") String id);
	
}

	
	
