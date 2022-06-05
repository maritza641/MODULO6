package cl.aiep.java.cft.modelo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Carrera {

	@Min(0)
	private int id;
	@Size(min = 3, max = 20, message = "debe estar entre 3 y 20 caracteres")
	private String nombre;
	private Alumno alumno;
	
	
	public Carrera() {
		super();
	}
	public Carrera(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}