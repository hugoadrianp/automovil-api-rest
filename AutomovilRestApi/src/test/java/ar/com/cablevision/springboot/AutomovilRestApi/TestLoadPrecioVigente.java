package ar.com.cablevision.springboot.AutomovilRestApi;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.cablevision.AutomovilRestApi.model.PrecioVigente;
import ar.com.cablevision.AutomovilRestApi.mongodb.repository.PrecioVigenteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestLoadPrecioVigente.class)
@ComponentScan("ar.com.cablevision")
public class TestLoadPrecioVigente {
		
	@Autowired
	private PrecioVigenteRepository repo;
	
	public PrecioVigenteRepository getRepo() {
		return repo;
	}

	public void setRepo(PrecioVigenteRepository repo) {
		this.repo = repo;
	}

	@Test
	public void testLoadPrecioVigente() {
		
		List<PrecioVigente> listaPrecios= new ArrayList<PrecioVigente>();
		
		PrecioVigente precio= new PrecioVigente();
		precio.setItem("sedan");
		precio.setPrecio(230000);
		listaPrecios.add(precio);
		
		PrecioVigente precio2= new PrecioVigente();
		precio2.setItem("familiar");
		precio2.setPrecio(245000);
		listaPrecios.add(precio2);
		
		PrecioVigente precio3= new PrecioVigente();
		precio3.setItem("coupe");
		precio3.setPrecio(270000);
		listaPrecios.add(precio3);
		
		PrecioVigente precio4= new PrecioVigente();
		precio4.setItem("TC");
		precio4.setPrecio(12000);
		listaPrecios.add(precio4);
		
		PrecioVigente precio5= new PrecioVigente();
		precio5.setItem("AA");
		precio5.setPrecio(20000);
		listaPrecios.add(precio5);
		
		PrecioVigente precio6= new PrecioVigente();
		precio6.setItem("ABS");
		precio6.setPrecio(14000);
		listaPrecios.add(precio6);
		
		PrecioVigente precio7= new PrecioVigente();
		precio7.setItem("AB");
		precio7.setPrecio(7000);
		listaPrecios.add(precio7);
		
		PrecioVigente precio8= new PrecioVigente();
		precio8.setItem("LL");
		precio8.setPrecio(12000);
		listaPrecios.add(precio8);
		
		repo.save(listaPrecios);
		
		assertTrue("Precios vigentes cargados en DB", true);
		
	}

}
