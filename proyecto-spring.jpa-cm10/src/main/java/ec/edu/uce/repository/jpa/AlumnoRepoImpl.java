package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Alumno;

@Repository
@Transactional
public class AlumnoRepoImpl implements IAlumnoRepo{

	private static final Logger LOG= LogManager.getLogger(AlumnoRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarAlumno(Alumno alu) {
		this.entityManager.persist(alu);
	}

	@Override
	public List<Alumno> buscarPorCursoJOIN(String curso) {
		TypedQuery<Alumno> myQuery=this.entityManager
				.createQuery("SELECT a FROM Alumno a JOIN a.institucion i Where a.curso=:curso",Alumno.class);
		myQuery.setParameter("curso", curso);
		
		List<Alumno> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Alumno a: miLista) {
			LOG.info("curso: "+a.getCurso());
			LOG.info(a.toString());
		}
		
		return miLista;
	}

	@Override
	public List<Alumno> buscarPorCursoJOINLeft(String curso) {
		TypedQuery<Alumno> myQuery=this.entityManager
				.createQuery("SELECT a FROM Alumno a LEFT JOIN a.institucion i Where a.curso=:curso",Alumno.class);
		myQuery.setParameter("curso", curso);
		
		List<Alumno> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Alumno a: miLista) {
			LOG.info("curso: "+a.getCurso());
			LOG.info(a.toString());
		}
		
		return miLista;
	}

	@Override
	public List<Alumno> buscarPorCursoJOINRigth(String curso) {
		TypedQuery<Alumno> myQuery=this.entityManager
				.createQuery("SELECT a FROM Alumno a RIGHT JOIN a.institucion i Where a.curso=:curso",Alumno.class);
		myQuery.setParameter("curso", curso);
		
		List<Alumno> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Alumno a: miLista) {
			LOG.info("curso: "+a.getCurso());
			LOG.info(a.toString());
		}
		
		return miLista;
	}

	@Override
	public List<Alumno> buscarPorCursoWhere(String curso) {
		TypedQuery<Alumno> myQuery=this.entityManager
				.createQuery("SELECT a FROM Alumno a, Institucion i WHERE a = i.alumno AND a.curso=:curso",Alumno.class);
		myQuery.setParameter("curso", curso);
		
		List<Alumno> miLista=myQuery.getResultList();
		
		LOG.info("Longitud"+miLista.size());
		for(Alumno a: miLista) {
			LOG.info("detalles: "+a.getCurso());
			LOG.info(a.toString());
		}
		
		return miLista;
	}
	
}
