package ec.edu.uce;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.Departamento;
import ec.edu.uce.modelo.jpa.Edificio;
import ec.edu.uce.service.IEdificioService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	//private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	@Autowired
	private IEdificioService ediService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Edificio miEdificio=new Edificio();
		miEdificio.setDireccion("Pedro de Alvarado 226");
		miEdificio.setPisos(8);
		
		//contruimos la lista 
		List<Departamento> departamentos=new ArrayList<>();
		
		Departamento d1=new Departamento();
		d1.setDuenio("Carlos Montalvo");
		d1.setHabitantes(4);
		d1.setEdi(miEdificio);
		
		departamentos.add(d1);
		
		Departamento d2=new Departamento();
		d2.setDuenio("Jimena Perez");
		d2.setHabitantes(2);
		d2.setEdi(miEdificio);
		
		departamentos.add(d2);
		
		miEdificio.setDepa(departamentos);
		
		this.ediService.insertarEdificioService(miEdificio);
	}

}
