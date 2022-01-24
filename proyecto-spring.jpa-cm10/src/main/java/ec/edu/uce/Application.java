package ec.edu.uce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;
import ec.edu.uce.service.IAbogadoService;
import ec.edu.uce.service.IArquitectoSerivce;
import ec.edu.uce.service.IChoferService;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IMeseroService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	@Autowired
	private IGestorCitaService gestorServ;
	
	@Autowired
	private IGuardiaService guardService;
	
	@Autowired
	private IDoctorService docService;
	
	@Autowired
	private IAbogadoService aboService;
	
	@Autowired
	private IArquitectoSerivce arqService;
	
	@Autowired
	private IChoferService choService;
	
	@Autowired
	private IMeseroService mesService;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		
		Guardia guard =new Guardia();
		guard.setNombre("Carlos");
		guard.setApellido("Alvarado");
		guard.setEdificio("Licuadora");
		
		Guardia guard2 =new Guardia();
		guard2.setId(3);
		guard2.setNombre("Ricardo");
		guard2.setApellido("Montalvo");
		guard2.setEdificio("Plaza Toros");
		
		//this.guardService.InsertarGuardiaService(guard);
		//System.out.println(this.guardService.buscarGuardiaApellidoService("Montalvo"));
		//this.guardService.buscarGuardiaService(3);
		//System.out.println(this.guardService.buscarGuardiaService(3));
		//this.guardService.borrarGuardiaService(3);
		//this.guardService.ActualizarGuardiaService(guard2);
		
		//busca con created query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoService("Alvarado");
		//System.out.println(gApellido);
		
		//busca la lista
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoListaService("Alvarado");
		//System.out.println(gApellido);
		
		//busca con el typed query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoIype("Alvarado");
		//System.out.println(gApellido);
		
		//busca con named query
		//Guardia gApellido =this.guardService.buscarGuardiaApellidoNamedService("Alvarado");
		//LOG.info("El guardia ha sido: "+gApellido);
		
		//busca con el typed query
		Guardia gApellido =this.guardService.buscarGuardiaApellidoIype("Alvarado");
		System.out.println(gApellido);
				
		//busca con named query
		Guardia g1Apellido =this.guardService.buscarGuardiaApellidoNamedService("Alvarado");
		LOG.info("El guardia ha sido: "+g1Apellido);
		
		//busca con el typed query
		LOG.info(docService.buscarDoctorEspecialidadTypeService("pediatra"));
		//busca con named query
		LOG.info(docService.buscarDoctorEspecialidadNamedService("pediatra"));
		
		//busca con el typed query
		LOG.info(arqService.buscarArquitectoApellidoTypeService("Aguiler"));
		//busca con named query
		LOG.info(arqService.buscarArquitectoApellidoNamedService("Aguiler"));
		
		//busca con el typed query
		LOG.info(aboService.buscarAbogadoFirmaTypeService("abogados de Cayambe"));
		//busca con named query
		LOG.info(aboService.buscarAbogadoFirmaNamedService("abogados de Cayambe"));
		
		//busca con el typed query
		LOG.info(choService.buscarChoferNombreTypeService("Mateo"));
		//busca con named query
		LOG.info(choService.buscarChoferNombreNamedService("Mateo"));
		
		//busca con el typed query
		LOG.info(mesService.buscarMeseroRestauranteTypeService("McDonalds"));
		//busca con named query
		LOG.info(mesService.buscarMeseroRestauranteNamedService("McDonalds"));
		
		
	}

}
