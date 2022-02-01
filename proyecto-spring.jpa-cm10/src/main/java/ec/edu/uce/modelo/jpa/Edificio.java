package ec.edu.uce.modelo.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="edificio")
public class Edificio {

	@Id
	@Column(name="edi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_edificio")
	@SequenceGenerator(name="seq_edificio",sequenceName = "seq_edificio",allocationSize = 1)
	private Integer id;
	
	@Column(name="edi_direccion")
	private String direccion;
	
	@Column(name="edi_pisos")
	private Integer pisos;
	
	@OneToMany(mappedBy = "edificio",cascade=CascadeType.ALL)
	private List<Departamento> departamento;

	//get y set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPisos() {
		return pisos;
	}

	public void setPisos(Integer pisos) {
		this.pisos = pisos;
	}

	public List<Departamento> getDepa() {
		return departamento;
	}

	public void setDepa(List<Departamento> depa) {
		this.departamento = depa;
	}
	
	
	
}
