package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="institucion")
public class Institucion {

	@Id
	@Column(name="insti_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_insti")
	@SequenceGenerator(name="seq_insti",sequenceName = "seq_insti",allocationSize = 1)
	private Integer id;
	
	@Column(name="insti_nombre")
	private String nombre;
	
	@OneToOne
	@JoinColumn(name="insti_id_alumno")
	private Alumno alumno;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
}
