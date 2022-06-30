package cl.aiep.java.biblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.biblioteca.model.Autor;
import cl.aiep.java.biblioteca.model.Libro;
import cl.aiep.java.biblioteca.repository.AutorRepository;
import cl.aiep.java.biblioteca.repository.LibroRepository;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	LibroRepository libroRepository;
	
	@Autowired
	AutorRepository autorRepository;
	
	@GetMapping("/nuevolibro")
	public String nuevolibro(Libro libro, Model modelo) {
		List<Autor> autores = autorRepository.findAll();
		modelo.addAttribute("autores",autores);
		return "admin/nuevolibro";
	}
	
	@PostMapping("/procesar")
	public String procesar(@Valid Libro libro, BindingResult validacion, Model modelo) {
		if(validacion.hasErrors()) { 
			List<Autor> autores = autorRepository.findAll();
			modelo.addAttribute("autores",autores);
			return "admin/nuevolibro";
		}
		libro.setAutor(autorRepository.findById(libro.getAutor_id()));
		libroRepository.create(libro);
		return "redirect:/libros/listado";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Libro> libros = libroRepository.findAll();
		modelo.addAttribute("libro",libros);
		return "/listalibros";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable (name="id") Long id) {
		libroRepository.delete(id);
		return "redirect:/libros/listado";
	}
	
}
