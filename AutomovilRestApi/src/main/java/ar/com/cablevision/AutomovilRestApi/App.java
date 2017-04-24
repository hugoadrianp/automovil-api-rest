package ar.com.cablevision.AutomovilRestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal que levanta todo el contexto de la aplicacion
 * 
 * @author Hugo Peralta
 *
 */
@SpringBootApplication
public class App 
{	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
