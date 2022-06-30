package cl.aiep.java.biblioteca.repository;

import java.util.List;

import cl.aiep.java.biblioteca.model.Autor;

public interface AutorRepository {

	public List<Autor> findAll();
	
	public Autor findById(Long id);
	
	public void create(Autor autor);
	
	public void edit(Autor autor);
	
	public void delete(Long id);
	
}
