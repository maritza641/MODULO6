package cl.aiep.java.heroku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("/")
	public String inicio() {
		return "inicio";
	}
	
	@GetMapping("/saludo")
	public String saludo() {
		return "saludo";
	}

}
