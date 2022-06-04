package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tiporestaurante")
public class Tiporestaurante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTiporestaurante;

	@Column(name = "typerestaurante", nullable = false, length = 20)
	private String typerestaurante;
	


	
	public Tiporestaurante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tiporestaurante(int idTiporestaurante, String typerestaurante) {
		super();
		this.idTiporestaurante = idTiporestaurante;
		this.typerestaurante = typerestaurante;
	
	}

	public int getIdTiporestaurante() {
		return idTiporestaurante;
	}

	public void setIdTiporestaurante(int idTiporestaurante) {
		this.idTiporestaurante = idTiporestaurante;
	}

	public String getTyperestaurante() {
		return typerestaurante;
	}

	public void setTyperestaurante(String typerestaurante) {
		this.typerestaurante = typerestaurante;
	}
	
	

}
