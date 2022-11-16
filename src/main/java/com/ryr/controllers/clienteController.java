package com.ryr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.services.I_Cliente_Service;
import com.ryr.models.services.I_Cuenta_Corriente_Service;
import com.ryr.models.services.I_Lista_Precio_Service;

@Controller
public class clienteController {
	
	@Autowired
	private I_Cliente_Service clienteService;
	
	@Autowired
	private I_Lista_Precio_Service listaPrecioService;
	
	@Autowired
	private I_Cuenta_Corriente_Service cuentaCorrienteService;
	
	@GetMapping("/clientes")
	public String clientes(Model model) {
		
		model.addAttribute("clientes", clienteService.listarTodo());
		
		model.addAttribute("lista_precios", listaPrecioService.listarTodo());
		
		return "clientes";
	}
	
	@GetMapping("/detalles/{cli_codigo}")
	public String detalles(Model model, @PathVariable int cli_codigo) {
		
		model.addAttribute("cliente", clienteService.buscarPorCodCliente(cli_codigo));
		
		
		
		return "detalles";
	}
	
	@PostMapping("/asignar_lista_precio")
	public String asignar_lista_precio(@RequestParam(name="lista_precio") Lista_Precio lista_precio,
			@RequestParam(name="cli_codigo") String cli_codigo) {
		
		Cliente cliente = clienteService.buscarPorCodCliente(Integer.valueOf(cli_codigo));
		cliente.setFkidlistaprecio(lista_precio);
		clienteService.guardar(cliente);
		
		return "redirect:/clientes";
	}

}
