package com.ryr.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryr.models.entities.Tarjeta;
import com.ryr.models.services.I_Entidad_Financiera_Service;
import com.ryr.models.services.I_Marca_Tarjeta_Service;
import com.ryr.models.services.I_Tarjeta_Service;
import com.ryr.models.services.I_Tipo_Tarjeta_Service;

@Controller
@SessionAttributes("tarjeta")
public class tarjetaController {
	
	@Autowired
	private I_Tarjeta_Service tarjetaService;
	
	@Autowired
	private I_Entidad_Financiera_Service entidadFinancieraService;
	
	@Autowired
	private I_Marca_Tarjeta_Service marcaService;
	
	@Autowired
	private I_Tipo_Tarjeta_Service tipoTarjetaService;
	
	
	
	@GetMapping("/tarjetas")
	public String tarjetas(Model model) {
		
		model.addAttribute("tarjetas", tarjetaService.listar());
		
		model.addAttribute("entidades", entidadFinancieraService.listar());
		
		model.addAttribute("marcas", marcaService.listar());
		
		model.addAttribute("tipos_tarjetas", tipoTarjetaService.listar());
		
		model.addAttribute("tarjeta", new Tarjeta());
		
		return "tarjetas";
	}
	
	@PostMapping("/tarjetas")
	public String formulario(@Valid Tarjeta tarjeta) {
		
		tarjeta.setActivo(true);
		tarjeta.setAlta(new Date());
		
		tarjetaService.guardar(tarjeta);
		
		return "redirect:/tarjetas";
	}

}
