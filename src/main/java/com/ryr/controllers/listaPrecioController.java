package com.ryr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.services.I_Lista_Precio_Service;

@Controller
@SessionAttributes("lista_precio")
public class listaPrecioController {
	
	@Autowired
	private I_Lista_Precio_Service listaPrecioService;

	@GetMapping("/listas_precios")
	public String listas_precios(Model model) {
		
		model.addAttribute("listas_precios", listaPrecioService.listarTodo());
		model.addAttribute("lista_precio", new Lista_Precio());
		
		return "listas_precios";
	}
	
	@PostMapping("/listas_precios")
	public String formulario(@Valid Lista_Precio lista_precio) {
		
		listaPrecioService.guardar(lista_precio);
		
		return "redirect:/listas_precios";
	}
	
}
