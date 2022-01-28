package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;

@Repository
@Transactional
public class MeseroRepoImpl implements IMeseroRepo{

	private static final Logger LOG= LogManager.getLogger(GuardiaRepoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarMesero(Mesero mes) {
		// TODO Auto-generated method stub
		this.entityManager.persist(mes);
	}

	@Override
	public Mesero buscarMesero(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Mesero.class, id);
	}

	@Override
	public void ActualizarMesero(Mesero mes) {
		// TODO Auto-generated method stub
		this.entityManager.merge(mes);
	}

	@Override
	public void borrarMesero(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(id);
	}

	@Override
	public Mesero buscarMeseroRestaurante(String restaurante) {
		Query miQuery= this.entityManager.createQuery("select g from Mesero g where g.restaurante=:valor");
		miQuery.setParameter("valor", restaurante);
		
		Mesero miMesero=(Mesero) miQuery.getSingleResult();
		
		return miMesero;
	}

	@Override
	public Mesero buscarMeseroRestauranteLista(String restaurante) {
		Query miQuery= this.entityManager.createQuery("select g from Mesero g where g.restaurante=:valor");
		miQuery.setParameter("valor", restaurante);
		
		 List<Mesero> lista= miQuery.getResultList();
		 
		 if(lista.isEmpty()) {
			 LOG.info("Tiene mas de un regidtro"+lista.size());
			 return lista.get(0);
		 }
		return null;
	}

	@Override
	public Mesero buscarMeseroRestauranteType(String restaurante) {
		TypedQuery<Mesero> myTypedQuery =(TypedQuery<Mesero>) this.entityManager.createQuery("select g from Mesero g where g.restaurante=:valor");
		myTypedQuery.setParameter("valor", restaurante);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Mesero buscarMeseroRestauranteNamed(String restaurante) {
		Query miQuery=this.entityManager.createNamedQuery("Mesero.buscarPorRestaurante");
		miQuery.setParameter("valor", restaurante);
		return (Mesero)miQuery.getSingleResult();
	}

	@Override
	public Mesero buscarMeseroRestauranteNative(String restaurante) {
		Query miQuery= this.entityManager.createNativeQuery("select * from mesero g where g.restaurante=:valor",Mesero.class);
		miQuery.setParameter("valor", restaurante);
		return (Mesero) miQuery.getSingleResult();
	}

	@Override
	public Mesero buscarMeseroRestauranteCriteria(String restaurante) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Mesero> myQuery=myCriteria.createQuery(Mesero.class);
		
		Root<Mesero>myTabla=myQuery.from(Mesero.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("restaurante"),restaurante);
		
		myQuery.select(myTabla).where(p1);
		
		TypedQuery<Mesero> typedQuery=this.entityManager.createQuery(myQuery);
		return typedQuery.getSingleResult();
	}

	
}
