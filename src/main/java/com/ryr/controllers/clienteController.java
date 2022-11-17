package com.ryr.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.services.I_Cliente_Service;
import com.ryr.models.services.I_Cuenta_Corriente_Service;
import com.ryr.models.services.I_Lista_Precio_Service;
import com.ryr.models.services.I_Tipo_Cliente_Service;
import com.ryr.models.services.I_Tipo_Documento_Service;
import com.ryr.models.services.I_Tipo_Iva_Service;

@Controller
@SessionAttributes("cliente")
public class clienteController {
	
	@Autowired
	private I_Cliente_Service clienteService;
	
	@Autowired
	private I_Lista_Precio_Service listaPrecioService;
	
	@Autowired
	private I_Cuenta_Corriente_Service cuentaCorrienteService;
	
	@Autowired
	private I_Tipo_Documento_Service tipoDocumentoService;
	
	@Autowired
	private I_Tipo_Cliente_Service tipoClienteService;
	
	@Autowired
	private I_Tipo_Iva_Service tipoIvaService;
	
	@GetMapping("/clientes")
	public String clientes(Model model) {
		
		model.addAttribute("clientes", clienteService.listarTodo());
		
		model.addAttribute("lista_precios", listaPrecioService.listarTodo());
		
		model.addAttribute("tipos_documentos", tipoDocumentoService.listarTodo());
		
		model.addAttribute("tipos_iva", tipoIvaService.listar());
		
		model.addAttribute("tipos_clientes", tipoClienteService.listarTodo());
		
		model.addAttribute("cliente", new Cliente());
		
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
	
	@PostMapping("/clientes")
	public String formulario(@Valid Cliente cliente) {
		
		int size_clientes = clienteService.listarTodo().size();
		List<Cliente> clientes = clienteService.listarTodo();
		
		int cod_cliente = (clientes.get(size_clientes - 1).getCli_codigo()) + 1;
		
		cliente.setCli_codigo(cod_cliente);
		
		clienteService.guardar(cliente);
		
		return "redirect:/clientes";
	}

}
