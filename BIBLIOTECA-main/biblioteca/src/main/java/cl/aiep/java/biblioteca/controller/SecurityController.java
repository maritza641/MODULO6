package cl.aiep.java.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {

	@GetMapping("/ingreso")
	public String ingreso() {
		return "ingreso";
	}
}
