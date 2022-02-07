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
@Table(name="taxi")
public class Taxi {

	@Id
	@Column(name="tax_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tax")
	@SequenceGenerator(name="seq_tax",sequenceName = "seq_tax",allocationSize = 1)
	private Integer id;
	
	@Column(name="tax_modelo")
	private String modelo;
	
	@Column(name="tax_placa")
	private String placa;
	
	@OneToOne
	@JoinColumn(name="tax_id_conductor")
	private Conductor conductor;

	//set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	
	
	
}
