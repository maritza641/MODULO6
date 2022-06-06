package cl.santiago.java;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludoController {

	@GetMapping("/")
	public String saludo() {
		return "saludo";
	}
}
