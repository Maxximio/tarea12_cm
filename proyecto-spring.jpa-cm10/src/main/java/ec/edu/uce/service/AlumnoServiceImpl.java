package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Alumno;
import ec.edu.uce.repository.jpa.IAlumnoRepo;

@Service
public class AlumnoServiceImpl implements IAlumnoService{

	@Autowired
	private IAlumnoRepo aluRepo;

	@Override
	public void insertarAlumnoService(Alumno alu) {
		this.aluRepo.insertarAlumno(alu);
	}	
	
}
