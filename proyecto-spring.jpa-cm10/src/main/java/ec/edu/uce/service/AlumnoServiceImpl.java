package ec.edu.uce.service;

import java.util.List;

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

	@Override
	public List<Alumno> buscarPorCursoJOINService(String curso) {
		return this.aluRepo.buscarPorCursoJOIN(curso);
	}

	@Override
	public List<Alumno> buscarPorCursoJOINLeftService(String curso) {
		return this.aluRepo.buscarPorCursoJOINLeft(curso);
	}

	@Override
	public List<Alumno> buscarPorCursoJOINRigthService(String curso) {
		return this.aluRepo.buscarPorCursoJOINRigth(curso);
	}

	@Override
	public List<Alumno> buscarPorCursoWhereService(String curso) {
		return this.aluRepo.buscarPorCursoWhere(curso);
	}	
	
}
