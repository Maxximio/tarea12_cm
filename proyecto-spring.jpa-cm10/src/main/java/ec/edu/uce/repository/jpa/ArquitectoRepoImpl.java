package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Arquitecto;
import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class ArquitectoRepoImpl implements IArquitectoRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void InsertarArquitecto(Arquitecto arqui) {
		this.entityManager.persist(arqui);
	}

	@Override
	public Arquitecto buscarArquitecto(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Arquitecto.class, id);
	}

	@Override
	public void ActualizarArquitecto(Arquitecto arqui) {
		this.entityManager.merge(arqui);
	}

	@Override
	public void borrarArquitecto(Integer id) {
		Arquitecto arquiBorrar=this.buscarArquitecto(id);
		this.entityManager.remove(arquiBorrar);
	}

	@Override
	public Arquitecto buscarArquitectoApellido(String apellido) {
		Query miQuery= this.entityManager.createQuery("select g from Arquitecto g where g.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		
		Arquitecto miArquitecto=(Arquitecto) miQuery.getSingleResult();
		
		return miArquitecto;
	}

	@Override
	public Arquitecto buscarArquitectoApellidoLista(String apellido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arquitecto buscarArquitectoApellidoType(String apellido) {
		TypedQuery<Arquitecto> myTypedQuery =(TypedQuery<Arquitecto>) this.entityManager.createQuery("select g from Arquitecto g where g.apellido=:valor");
		myTypedQuery.setParameter("valor", apellido);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Arquitecto buscarArquitectoApellidoNamed(String apellido) {
		Query miQuery=this.entityManager.createNamedQuery("Arquitecto.buscarPorApellido");
		miQuery.setParameter("valor", apellido);
		return (Arquitecto)miQuery.getSingleResult();
	}

	@Override
	public Arquitecto buscarArquitectoApellidoNative(String apellido) {
		Query miQuery= this.entityManager.createNativeQuery("select * from arquitecto g where g.apellido=:valor",Arquitecto.class);
		miQuery.setParameter("valor", apellido);
		return (Arquitecto) miQuery.getSingleResult();
	}
}
