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
@Table(name="conductor")
public class Conductor {

	@Id
	@Column(name="conduct_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_conduct")
	@SequenceGenerator(name="seq_conduct",sequenceName = "seq_conduct",allocationSize = 1)
	private Integer id;
	
	@Column(name="conduct_nombre")
	private String nombre;
	
	@Column(name="conduct_apellido")
	private String apellido;
	
	@OneToOne(mappedBy = "conductor",cascade=CascadeType.ALL)
	private Taxi taxi;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	
	
	
}
