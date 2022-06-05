package cl.aiep.java.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.aiep.java.cms.model.Usuario;
import cl.aiep.java.cms.service.UsuarioService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/instalar")
	public String instalar() {
		Long cantidadUsuarios = usuarioService.cantidadUsuarios();
		if(cantidadUsuarios == 0) {
			//solo ejecutar en caso que la tabla de usuarios este vacia
			Usuario usuario = new Usuario(null, "stgo@123.cl", "1234", "ADMIN");
			usuarioService.crearUsuario(usuario);
		}
		return "redirect:/";
	}
	@GetMapping("/index")
	public String index() {
		return "admin/index";
	}
	
	@GetMapping("/reporte")
	public String reporte() {
		return "admin/reporte";
	}
}
