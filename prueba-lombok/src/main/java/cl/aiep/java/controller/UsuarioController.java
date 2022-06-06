package cl.aiep.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cl.aiep.java.modelo.Usuario;

@Controller
public class UsuarioController {

	@GetMapping("/")
	public String index(Model modelo) {
		Usuario miUsuario = Usuario.builder()
			.username("administrador@123.cl")
			.contrasena("1234")
			.rol("ADMIN")
			.build()
		;
		
		new Usuario(null, "administrador@123.cl", "1234", "ADMIN");
		modelo.addAttribute("usuario", miUsuario);	
		return "index";
	}
}
