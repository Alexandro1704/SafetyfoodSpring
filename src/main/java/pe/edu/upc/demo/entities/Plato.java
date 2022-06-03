package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plato")
public class Plato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlato;

	@Column(name = "nombreplato", nullable = false, length = 20)
	private String nombreplato;

	
	public Plato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plato(int idPlato, String nombreplato) {
		super();
		this.idPlato = idPlato;
		this.nombreplato = nombreplato;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombreplato() {
		return nombreplato;
	}

	public void setNombreplato(String nombreplato) {
		this.nombreplato = nombreplato;
	}

}
