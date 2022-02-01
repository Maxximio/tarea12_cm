package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Edificio;

@Repository
@Transactional
public class EdificioRepoImpl implements IEdificioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarEdificio(Edificio edi) {
		this.entityManager.persist(edi);
	}

}
