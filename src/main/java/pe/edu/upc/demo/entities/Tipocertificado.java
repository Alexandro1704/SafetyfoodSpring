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
	@Column(name = "tipocertificado", length = 35, nullable = false)
	private String tipocertificado;
	@Column(name = "nombretipocertificado", length = 35, nullable = false)
	private String nombretipocertificado;
	public Tipocertificado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tipocertificado(int idTipocertificado, String tipocertificado, String nombretipocertificado) {
		super();
		this.idTipocertificado = idTipocertificado;
		this.tipocertificado = tipocertificado;
		this.nombretipocertificado = nombretipocertificado;
	}
	public int getIdTipocertificado() {
		return idTipocertificado;
	}
	public void setIdTipocertificado(int idTipocertificado) {
		this.idTipocertificado = idTipocertificado;
	}
	public String getTipocertificado() {
		return tipocertificado;
	}
	public void setTipocertificado(String tipocertificado) {
		this.tipocertificado = tipocertificado;
	}
	public String getNombretipocertificado() {
		return nombretipocertificado;
	}
	public void setNombretipocertificado(String nombretipocertificado) {
		this.nombretipocertificado = nombretipocertificado;
	}
	
}
