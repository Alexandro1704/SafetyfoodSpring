package pe.edu.upc.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipocertificado")
public class Tipocertificado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipocertificado;

	@Column(name = "typecertificado", nullable = false, length = 20)
	private String typecertificado;
	
	@Column(name = "nombretipocertificado", nullable = false, length = 20)
	private String nombretipocertificado;

	
	public Tipocertificado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tipocertificado(int idTipocertificado, String typecertificado, String nombretipocertificado) {
		super();
		this.idTipocertificado = idTipocertificado;
		this.typecertificado = typecertificado;
		this.nombretipocertificado = nombretipocertificado;
	}

	public int getIdTipocertificado() {
		return idTipocertificado;
	}

	public void setIdTipocertificado(int idTipocertificado) {
		this.idTipocertificado = idTipocertificado;
	}

	public String getTypecertificado() {
		return typecertificado;
	}

	public void setTypecertificado(String typecertificado) {
		this.typecertificado = typecertificado;
	}
	
	public String getNombretipocertificado() {
		return nombretipocertificado;
	}

	public void setNombretipocertificado(String nombretipocertificado) {
		this.nombretipocertificado = nombretipocertificado;
	}

}
