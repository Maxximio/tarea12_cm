package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Abogado;
import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class AbogadoRepoImpl implements IAbogadoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarAbogado(Abogado abo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(abo);
	}

	@Override
	public Abogado buscarAbogado(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Abogado.class, id);
	}

	@Override
	public void ActualizarAbogado(Abogado abo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(abo);
	}

	@Override
	public void borrarAbogado(Integer id) {
		Abogado BorrarAbo=this.buscarAbogado(id);
		this.entityManager.remove(BorrarAbo);
	}

	@Override
	public Abogado buscarAbogadoFirma(String firma) {
		Query miQuery= this.entityManager.createQuery("select g from Abogado g where g.firma=:valor");
		miQuery.setParameter("valor", firma);
		
		Abogado miAbo=(Abogado) miQuery.getSingleResult();
		
		return miAbo;
	}

	@Override
	public Abogado buscarAbogadoFirmaLista(String firma) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Abogado buscarAbogadoFirmaType(String firma) {
		TypedQuery<Abogado> myTypedQuery =(TypedQuery<Abogado>) this.entityManager.createQuery("select g from Abogado g where g.firma=:valor");
		myTypedQuery.setParameter("valor", firma);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Abogado buscarAbogadoFirmaNamed(String firma) {
		Query miQuery=this.entityManager.createNamedQuery("Abogado.buscarPorFirma");
		miQuery.setParameter("valor", firma);
		return (Abogado)miQuery.getSingleResult();
	}

	@Override
	public Abogado buscarAbogadoFirmaNative(String firma) {
		Query miQuery= this.entityManager.createNativeQuery("select * from abogado g where g.firma=:valor",Abogado.class);
		miQuery.setParameter("valor", firma);
		return (Abogado) miQuery.getSingleResult();
	}

	@Override
	public Abogado buscarAbogadoFirmaCriteria(String firma) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Abogado> myQuery=myCriteria.createQuery(Abogado.class);
		
		Root<Abogado>myTabla=myQuery.from(Abogado.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("firma"),firma);
		
		myQuery.select(myTabla).where(p1);
		
		TypedQuery<Abogado> typedQuery=this.entityManager.createQuery(myQuery);
		return typedQuery.getSingleResult();
	}
	
}
