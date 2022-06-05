package cl.aiep.java.tesoreria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proveedor {

	@Id //le dice que es la PK
	@GeneratedValue(strategy = GenerationType.AUTO) //autoincrementable
	private Long id;
	@Column(nullable = false, length = 11, unique=true)
	private String rut;
	@Column(nullable = false)
	private String razonSocial;
	
	public Proveedor() {
		super();
	}

	public Proveedor(Long id, String rut, String razonSocial) {
		super();
		this.id = id;
		this.rut = rut;
		this.razonSocial = razonSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

}
