package ar.com.cablevision.springboot.AutomovilRestApi;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.cablevision.AutomovilRestApi.model.Automovil;
import ar.com.cablevision.AutomovilRestApi.model.Coupe;
import ar.com.cablevision.AutomovilRestApi.model.Fabrica;
import ar.com.cablevision.AutomovilRestApi.model.Familiar;
import ar.com.cablevision.AutomovilRestApi.model.Opcional;
import ar.com.cablevision.AutomovilRestApi.model.Sedan;
import ar.com.cablevision.AutomovilRestApi.model.TipoOp;
import ar.com.cablevision.AutomovilRestApi.mongodb.repository.PrecioVigenteRepository;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoCoupeStrategy;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoFamiliarStrategy;
import ar.com.cablevision.AutomovilRestApi.strategy.CostoSedanStrategy;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=TestCostoFinal.class)
@ComponentScan("ar.com.cablevision")
public class TestCostoFinal {

	@Autowired
	private PrecioVigenteRepository pvrepo;
	
	@Test
	public void testCostoFinal() {
		
		Fabrica fabrica= new Fabrica();
		fabrica.setAutomoviles(new ArrayList<Automovil>());
		
		Sedan autoSedan= new Sedan();
		autoSedan.setNombre("sedan");
		Opcional op= new Opcional();
		op.setTipo(TipoOp.AA);
		List<Opcional> opcionales= new ArrayList<Opcional>();
		opcionales.add(op);
		autoSedan.setOpcionales(opcionales);	
		
		Coupe autoCoupe= new Coupe();
		autoCoupe.setNombre("coupe");
		Opcional op2= new Opcional();
		op2.setTipo(TipoOp.ABS);
		List<Opcional> opcionales2= new ArrayList<Opcional>();
		opcionales2.add(op2);
		autoCoupe.setOpcionales(opcionales2);
		
		Familiar autoFamiliar= new Familiar();
		autoFamiliar.setNombre("familiar");
		Opcional op3= new Opcional();
		op3.setTipo(TipoOp.TC);
		List<Opcional> opcionales3= new ArrayList<Opcional>();
		opcionales3.add(op3);
		autoFamiliar.setOpcionales(opcionales3);
		
		fabrica.getAutomoviles().add(autoSedan);
		fabrica.getAutomoviles().add(autoCoupe);
		fabrica.getAutomoviles().add(autoFamiliar);
		
		long costoSedan= fabrica.costoFinalAutomovil(new CostoSedanStrategy(autoSedan, pvrepo));
		long costoCoupe= fabrica.costoFinalAutomovil(new CostoCoupeStrategy(autoCoupe, pvrepo));
		long costoFamiliar= fabrica.costoFinalAutomovil(new CostoFamiliarStrategy(autoFamiliar, pvrepo));
		
		System.out.println("Costo final Sedan: " + costoSedan);
		System.out.println("Costo final Coupe: " + costoCoupe);
		System.out.println("Costo final Familiar: " + costoFamiliar);
		
	}

}
