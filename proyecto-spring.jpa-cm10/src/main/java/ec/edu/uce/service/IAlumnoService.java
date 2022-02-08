package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.jpa.Alumno;

public interface IAlumnoService {

	void insertarAlumnoService(Alumno alu);
	
	List <Alumno> buscarPorCursoJOINService(String curso);
	
	List <Alumno> buscarPorCursoJOINLeftService(String curso);
	
	List <Alumno> buscarPorCursoJOINRigthService(String curso);
	
	List <Alumno> buscarPorCursoWhereService(String curso);
}
