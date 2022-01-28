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

import ec.edu.uce.modelo.jpa.Chofer;
import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class ChoferRepoImpl implements IChoferRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarChofer(Chofer cho) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cho);
	}

	@Override
	public Chofer buscarChofer(Integer matricula) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Chofer.class, matricula);
	}

	@Override
	public void ActualizarChofer(Chofer cho) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cho);
	}

	@Override
	public void borrarChofer(Integer matricula) {
		Chofer choBorrar =this.buscarChofer(matricula);
		this.entityManager.remove(choBorrar);
	}

	@Override
	public Chofer buscarChoferNombre(String nombre) {
		Query miQuery= this.entityManager.createQuery("select g from Chofer g where g.nombre=:valor");
		miQuery.setParameter("valor", nombre);
		
		Chofer miChofer=(Chofer) miQuery.getSingleResult();
		
		return miChofer;
	}

	@Override
	public Chofer buscarChoferNombreLista(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chofer buscarChoferNombreType(String nombre) {
		TypedQuery<Chofer> myTypedQuery =(TypedQuery<Chofer>) this.entityManager.createQuery("select g from Chofer g where g.nombre=:valor");
		myTypedQuery.setParameter("valor", nombre);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Chofer buscarChoferNombreNamed(String nombre) {
		Query miQuery=this.entityManager.createNamedQuery("Chofer.buscarPorNombre");
		miQuery.setParameter("valor", nombre);
		return (Chofer)miQuery.getSingleResult();
	}

	@Override
	public Chofer buscarChoferNombreNative(String nombre) {
		Query miQuery= this.entityManager.createNativeQuery("select * from chofer g where g.nombre=:valor",Chofer.class);
		miQuery.setParameter("valor", nombre);
		return (Chofer) miQuery.getSingleResult();
	}

	@Override
	public Chofer buscarChoferNombreCriteria(String nombre) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Chofer> myQuery=myCriteria.createQuery(Chofer.class);
		
		Root<Chofer>myTabla=myQuery.from(Chofer.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("nombre"),nombre);
		
		myQuery.select(myTabla).where(p1);
		
		TypedQuery<Chofer> typedQuery=this.entityManager.createQuery(myQuery);
		return typedQuery.getSingleResult();
	}
	
}
