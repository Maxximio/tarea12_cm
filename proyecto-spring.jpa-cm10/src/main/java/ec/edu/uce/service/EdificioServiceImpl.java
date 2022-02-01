package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Edificio;
import ec.edu.uce.repository.jpa.IEdificioRepo;

@Service
public class EdificioServiceImpl implements IEdificioService{

	@Autowired
	private IEdificioRepo ediRepo;

	@Override
	public void insertarEdificioService(Edificio edi) {
		this.ediRepo.insertarEdificio(edi);
	}
	
}
