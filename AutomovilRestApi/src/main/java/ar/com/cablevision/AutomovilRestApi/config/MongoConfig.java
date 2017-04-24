/**
 * 
 */
package ar.com.cablevision.AutomovilRestApi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Clase para la configuracion de los repositorios de Mongodb
 * 
 * @author Hugo Peralta
 *
 */
@Configuration
@EnableMongoRepositories(basePackages="ar.com.cablevision.AutomovilRestApi.mongodb.repository")
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "precioVigente";
    }
  
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "ar.com.cablevision.AutomovilRestApi.mongodb.repository";
    }
}
	