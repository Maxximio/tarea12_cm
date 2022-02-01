package ec.edu.uce.modelo.jpa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="departamento")
public class Departamento {

	@Id
	@Column(name="depa_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_depa")
	@SequenceGenerator(name="seq_depa",sequenceName = "seq_depa",allocationSize = 1)
	private Integer id;
	
	@Column(name="depa_habitantes")
	private Integer habitantes;
	
	@Column(name="depa_duenio")
	private String duenio;

	@ManyToOne
	@JoinColumn(name="edi_id")
	private Edificio edificio;//sera mapeado

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}

	public String getDuenio() {
		return duenio;
	}

	public void setDuenio(String duenio) {
		this.duenio = duenio;
	}

	public Edificio getEdi() {
		return edificio;
	}

	public void setEdi(Edificio edi) {
		this.edificio = edi;
	}
	
	
}
