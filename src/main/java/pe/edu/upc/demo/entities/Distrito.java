package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDistrito;

	@Column(name = "nombredistrito", nullable = false, length = 20)
	private String nombredistrito;

	
	public Distrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distrito(int idDistrito, String nombredistrito) {
		super();
		this.idDistrito = idDistrito;
		this.nombredistrito = nombredistrito;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombredistrito() {
		return nombredistrito;
	}

	public void setNombredistrito(String nombredistrito) {
		this.nombredistrito = nombredistrito;
	}

}
