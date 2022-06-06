package cl.aiep.java.archivos.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.HttpHeadersReturnValueHandler;

import cl.aiep.java.archivos.modelo.Archivo;
import cl.aiep.java.archivos.repositorio.ArchivoRepositorio;

@Controller
public class AppControlador {
	
	@Autowired
	ArchivoRepositorio repository;
	
	@GetMapping("/")
	public String formulario() {
		return "formulario";
	}

	@PostMapping("/")
	public String procesarFormulario(@RequestParam("archivo") MultipartFile archivo) {
		try {
			String nombreArchivo 	= archivo.getOriginalFilename();
			String tipoArchivo 		= archivo.getContentType();
			byte[] contenidoArchivo = archivo.getBytes();
			Archivo archivoBD	 	= Archivo.builder()
											 .datos(contenidoArchivo)
											 .filename(nombreArchivo)
											 .tipo(tipoArchivo)
											 .build()
			;
			repository.saveAndFlush(archivoBD);
			return "redirect:/cualquier-pagina";
		} catch (Exception e) {
			return "formulario";
		}
	}
	
	// http://localhost:8080/archivo/a/1
	// http://localhost:8080/archivo/i/1
	@GetMapping("/archivo/{disposicion}/{id}")
	public ResponseEntity<byte[]> mostrarDescargarArchivo(
		@PathVariable("disposicion")	String disposicion,
		@PathVariable("id")				Archivo archivo
	) {
		String disposition = null;
		if ("a".equalsIgnoreCase(disposicion))
		{
			disposition = "attachment";
		} else {
			disposition = "inline";
		}
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, disposition)
				.contentType( MediaType.valueOf(archivo.getTipo()))
				.body(archivo.getDatos())
		;
	}
	
}
