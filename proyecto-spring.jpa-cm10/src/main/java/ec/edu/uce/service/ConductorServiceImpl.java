package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Conductor;
import ec.edu.uce.repository.jpa.IConductorRepo;

@Service
public class ConductorServiceImpl implements IConductorService{

	@Autowired
	private IConductorRepo conductorRepo;

	@Override
	public void insertarConductorService(Conductor conduc) {
		this.conductorRepo.insertarConductor(conduc);
	}
	
}
