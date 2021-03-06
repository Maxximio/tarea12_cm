package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.IGuardiaRepo;

@Service
public class GuardiaServiceImpl implements IGuardiaService{

	@Autowired
	private IGuardiaRepo guardRepo;
	
	@Override
	public void InsertarGuardiaService(Guardia guardia) {
		
		this.guardRepo.InsertarGuardia(guardia);
	}

	@Override
	public Guardia buscarGuardiaService(Integer id) {
		// TODO Auto-generated method stub
		return this.guardRepo.buscarGuardia(id);
	}

	@Override
	public void ActualizarGuardiaService(Guardia guardia) {
		
		this.guardRepo.ActualizarGuardia(guardia);
	}

	@Override
	public void borrarGuardiaService(Integer id) {
		// TODO Auto-generated method stub
		this.guardRepo.borrarGuardia(id);
	}

	@Override
	public Guardia buscarGuardiaApellidoService(String apellido) {
		return this.guardRepo.buscarGuardiaApellido(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoListaService(String apellido) {
		// TODO Auto-generated method stub
		return this.guardRepo.buscarGuardiaApellidoLista(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoIype(String apellido) {
		// TODO Auto-generated method stub
		return this.guardRepo.buscarGuardiaApellidoIype(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoNamedService(String apellido) {
		// TODO Auto-generated method stub
		return this.guardRepo.buscarGuardiaApellidoNamed(apellido);
	}

	
}
