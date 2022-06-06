package cl.aiep.java.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.aiep.java.catalogo.model.Producto;
import cl.aiep.java.catalogo.repository.ProductoRepository;

@RestController
@CrossOrigin(origins = "*")
public class AppController {
	
	@Autowired
	ProductoRepository productoRepository;
	
	@GetMapping("/instalar")
	public String instalar() {
		//opcionalmente verificar si ya se instalaron los datos
		long count = productoRepository.count();
		if( count==0 ) {
			// instanciamos productos
			Producto producto1 = Producto.builder()
									.nombre("Correa paseo")
									.precio(9990)
									.build()
			;
			Producto producto2 = new Producto(null, "Plato Grande Metalico", 4990);
			Producto producto3 = new Producto(null, "Pelota juguete", 3990);
			
			// persistimos en la BD
			productoRepository.saveAndFlush( producto1 );
			productoRepository.saveAndFlush( producto2 );
			productoRepository.saveAndFlush( producto3 );
			
			return "ok";
		} else {
			return "ya se habia realizado la instalacion";
		}
	}
	
	@GetMapping("/productos/destacados")
	public List<Producto> productosDestacados() {
		List<Producto> productos = productoRepository.findAll();
		return productos;
	}
}
