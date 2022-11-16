package com.ryr.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryr.models.entities.Entidad_Financiera;
import com.ryr.models.services.I_Entidad_Financiera_Service;
import com.ryr.models.services.I_Tipo_Entidad_Financiera_Service;

@Controller
@SessionAttributes("entidad_financiera")
public class entidadFinancieraController {

	@Autowired
	private I_Entidad_Financiera_Service entidadFinancieraService;
	
	@Autowired
	private I_Tipo_Entidad_Financiera_Service tipoEntidadFinancieraService;
	
	@GetMapping("/entidades_financieras")
	public String entidades(Model model) {
		
		model.addAttribute("entidades_financieras", entidadFinancieraService.listar());
		
		model.addAttribute("tipos_entidades", tipoEntidadFinancieraService.listar());
		
		model.addAttribute("entidad_financiera", new Entidad_Financiera());
		
		return "entidades_financieras";
	}
	
	@PostMapping("/entidades_financieras")
	public String formulario(@Valid Entidad_Financiera entidad_financiera) {
		
		entidad_financiera.setAlta(new Date());
		entidad_financiera.setActivo(true);
		
		entidadFinancieraService.guardar(entidad_financiera);
		
		return "redirect:/entidades_financieras";
	}
	
}
