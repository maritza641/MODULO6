package cl.aiep.java.tesoreria.controller;

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

import cl.aiep.java.tesoreria.modelo.Factura;
import cl.aiep.java.tesoreria.modelo.Proveedor;
import cl.aiep.java.tesoreria.repositorio.FacturaRepository;
import cl.aiep.java.tesoreria.repositorio.ProveedorRepository;

@Controller
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@GetMapping("/nueva") //http://localhost:8081/factura/nuevo
	public String nueva(Factura factura, Model modelo) {
		List<Proveedor> proveedores = proveedorRepository.findAll();
		modelo.addAttribute("proveedores", proveedores);
		return "factura/form";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable(name = "id") Factura factura, Model modelo) {
		List<Proveedor> proveedores = proveedorRepository.findAll();
		modelo.addAttribute("factura", proveedores);
		modelo.addAttribute("factura", factura);
		return "factura/form";
	}
	
	@PostMapping("/procesar")
	public String procesar(@Valid Factura factura, BindingResult informeValidacion) {
		if(informeValidacion.hasErrors()) return "factura/form";
		
		facturaRepository.saveAndFlush(factura);
		return "redirect:/factura/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Long id) {
		facturaRepository.deleteById(id);
		return "redirect:/factura/listado";
	}
	
	@GetMapping("/listado")
	public String listado(Model modelo) {
		List<Factura> facturas = facturaRepository.findAll();
		modelo.addAttribute("facturas", facturas);
		return "factura/listado";
	}
}
