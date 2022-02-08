package ec.edu.uce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.jpa.Alumno;
import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.modelo.jpa.Conductor;
import ec.edu.uce.modelo.jpa.Departamento;
import ec.edu.uce.modelo.jpa.Edificio;
import ec.edu.uce.modelo.jpa.Empleado;
import ec.edu.uce.modelo.jpa.Institucion;
import ec.edu.uce.modelo.jpa.Taxi;
import ec.edu.uce.service.IAlumnoService;
import ec.edu.uce.service.ICiudadanoService;
import ec.edu.uce.service.IConductorService;
import ec.edu.uce.service.IEdificioService;


@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(Application.class);
	
	@Autowired
	private IEdificioService ediService;
	
	@Autowired
	private ICiudadanoService ciuService;
	
	@Autowired 
	private IConductorService conService;
	
	@Autowired
	private IAlumnoService aluService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		
		Alumno alu=new Alumno();
		alu.setNombre("Ricardo");
		alu.setApellido("Montalvo");
		alu.setCurso("noveno");
		alu.setParalelo("A");
		
		Institucion insti =new Institucion();
		insti.setNombre("Colegio Salesiano");
		
		alu.setInstitucion(insti);
		insti.setAlumno(alu);
		
		//aluService.insertarAlumnoService(alu);
		//aluService.buscarPorCursoWhereService(alu);
		
		List <Alumno> listaF1 =this.aluService.buscarPorCursoJOINService("noveno");
		LOG.info("Longitud"+listaF1.size());
		for(Alumno alum: listaF1) {
			LOG.info("Los Alumnos han sido: "+alum.toString());
		}
		
		List <Alumno> listaF2 =this.aluService.buscarPorCursoJOINLeftService("noveno");
		LOG.info("Longitud"+listaF2.size());
		for(Alumno alum: listaF2) {
			LOG.info("Los Alumnos han sido: "+alum.toString());
		}
		
		List <Alumno> listaF3 =this.aluService.buscarPorCursoJOINRigthService("noveno");
		LOG.info("Longitud"+listaF3.size());
		for(Alumno alum: listaF3) {
			LOG.info("Los Alumnos han sido: "+alum.toString());
		}
		
		List <Alumno> listaF4 =this.aluService.buscarPorCursoWhereService("noveno");
		LOG.info("Longitud"+listaF4.size());
		for(Alumno alum: listaF4) {
			LOG.info("Los Alumnos han sido: "+alum.toString());
		}
		
		/*Conductor con=new Conductor();
		con.setNombre("Ricardo");
		con.setApellido("Galindo");
		
		Taxi tax=new Taxi();
		tax.setPlaca("ALS634");
		tax.setModelo("KIA Sorento");
		
		con.setTaxi(tax);
		tax.setConductor(con);
		conService.insertarConductorService(con);
		
		
		Alumno alu=new Alumno();
		alu.setNombre("Angela");
		alu.setApellido("Caseres");
		alu.setCurso("noveno");
		alu.setParalelo("C");
		
		Institucion insti =new Institucion();
		insti.setNombre("Colegio Salesiano");
		
		alu.setInstitucion(insti);
		insti.setAlumno(alu);
		aluService.insertarAlumnoService(alu);*/
		
		
		/*Ciudadano ciu=new Ciudadano();
		ciu.setNombre("Carlos");
		ciu.setApellido("Montalvo");
		
		Empleado empl =new Empleado();
		empl.setIess("asfqwe2342");
		empl.setSalario(new BigDecimal(500.30));

		empl.setCiudadania(ciu);
		ciu.setEmpleado(empl);
		
		ciuService.insertarCiudadanoService(ciu);*/
		
		/*Edificio miEdificio=new Edificio();
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
		
		this.ediService.insertarEdificioService(miEdificio);*/
	}

}
