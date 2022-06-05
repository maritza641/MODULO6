package cl.aiep.java.cft.modelo;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Alumno {

	@Min(0)
	private int id;
	@Size(min = 3, max = 40)
	private String nombre;
	private LocalDate fechaNacimiento;
	@NotNull
	private Carrera carrera;	
	
	public Alumno() {
		super();
	}
	public Alumno(@Min(0) int id, @Size(min = 3, max = 40) String nombre, LocalDate fechaNacimiento,
			@NotNull Carrera carrera) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.carrera = carrera;
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
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	
	
}