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

import ec.edu.uce.modelo.jpa.Doctor;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.modelo.jpa.Mesero;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void InsertarDoctor(Doctor doctor) {
		this.entityManager.persist(doctor);
		
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void ActualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public void borrarDoctor(Integer id) {
		Doctor docBorrar=this.buscarDoctor(id);
		this.entityManager.remove(docBorrar);
	}

	@Override
	public Doctor buscarDoctorEspecialidad(String especial) {
		Query miQuery= this.entityManager.createQuery("select g from Doctor g where g.especialidad=:valor");
		miQuery.setParameter("valor", especial);
		
		Doctor miDoc=(Doctor) miQuery.getSingleResult();
		
		return miDoc;
	}

	@Override
	public Doctor buscarDoctorEspecialidadLista(String especial) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor buscarDoctorEspecialidadType(String especial) {
		TypedQuery<Doctor> myTypedQuery =(TypedQuery<Doctor>) this.entityManager.createQuery("select g from Doctor g where g.especialidad=:valor");
		myTypedQuery.setParameter("valor", especial);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Doctor buscarDoctorEspecialidadNamed(String especial) {
		Query miQuery=this.entityManager.createNamedQuery("Doctor.buscarPorEspecialidad");
		miQuery.setParameter("valor", especial);
		return (Doctor)miQuery.getSingleResult();
	}

	@Override
	public Doctor buscarDoctorEspecialidadNative(String especial) {
		Query miQuery= this.entityManager.createNativeQuery("select * from doctor g where g.especialidad=:valor",Doctor.class);
		miQuery.setParameter("valor", especial);
		return (Doctor) miQuery.getSingleResult();
	}

	@Override
	public Doctor buscarDoctorEspecialidadCriteria(String especial) {
		CriteriaBuilder myCriteria=this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Doctor> myQuery=myCriteria.createQuery(Doctor.class);
		
		Root<Doctor>myTabla=myQuery.from(Doctor.class);
		
		Predicate p1=myCriteria.equal(myTabla.get("especialidad"),especial);
		
		myQuery.select(myTabla).where(p1);
		
		TypedQuery<Doctor> typedQuery=this.entityManager.createQuery(myQuery);
		return typedQuery.getSingleResult();
	}

}
