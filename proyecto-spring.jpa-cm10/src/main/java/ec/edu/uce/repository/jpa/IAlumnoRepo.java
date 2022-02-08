package ec.edu.uce.repository.jpa;

import java.util.List;

import ec.edu.uce.modelo.jpa.Alumno;

public interface IAlumnoRepo {

	void insertarAlumno(Alumno alu);
	
	List <Alumno> buscarPorCursoJOIN(String curso);
	
	List <Alumno> buscarPorCursoJOINLeft(String curso);
	
	List <Alumno> buscarPorCursoJOINRigth(String curso);
	
	List <Alumno> buscarPorCursoWhere(String curso);
	
}
