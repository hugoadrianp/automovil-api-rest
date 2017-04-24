/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ar.com.cablevision.AutomovilRestApi.model.PrecioVigente;

/**
 * Definicion del repositorio de mongodb para manejar los precios vigentes
 * 
 * @author Hugo Peralta
 *
 */
@RepositoryRestResource(collectionResourceRel = "precioVigente", path = "precioVigente")
public interface PrecioVigenteRepository extends MongoRepository<PrecioVigente, String> {

	PrecioVigente findByItem(@Param("name") String name);
	PrecioVigente findByPrecio(@Param("precio") String precio);
	PrecioVigente findById(@Param("id") String id);
	
}
	

