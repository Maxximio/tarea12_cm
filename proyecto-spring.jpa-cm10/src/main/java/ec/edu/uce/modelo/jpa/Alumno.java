package ec.edu.uce.modelo.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno {

	@Id
	@Column(name="alu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alu")
	@SequenceGenerator(name="seq_alu",sequenceName = "seq_alu",allocationSize = 1)
	private Integer id;
	
	@Column(name="alu_nombre")
	private String nombre;
	
	@Column(name="alu_apellido")
	private String apellido;
	
	@Column(name="alu_curso")
	private String curso;
	
	@Column(name="alu_paralelo")
	private String paralelo;
	
	@OneToOne(mappedBy = "alumno",cascade=CascadeType.ALL)
	private Institucion institucion;

	//get y set
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getParalelo() {
		return paralelo;
	}

	public void setParalelo(String paralelo) {
		this.paralelo = paralelo;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	
	
	
}
