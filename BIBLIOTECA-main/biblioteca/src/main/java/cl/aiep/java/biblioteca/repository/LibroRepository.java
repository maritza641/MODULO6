package cl.aiep.java.biblioteca.repository;

import java.util.List;

import cl.aiep.java.biblioteca.model.Libro;


public interface LibroRepository {
	
	public List<Libro> findAll();
	
	public Libro findById(Long id);
	
	public void create(Libro libro);
	
	public void edit(Libro libro);
	
	public void delete(Long id);
}
