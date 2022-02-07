package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Alumno;

@Repository
@Transactional
public class AlumnoRepoImpl implements IAlumnoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarAlumno(Alumno alu) {
		this.entityManager.persist(alu);
	}
	
}
