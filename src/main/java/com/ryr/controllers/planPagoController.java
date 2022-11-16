package com.ryr.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryr.models.entities.Plan_Pago;
import com.ryr.models.services.I_Medio_Pago_Service;
import com.ryr.models.services.I_Plan_Pago_Service;
import com.ryr.models.services.I_Tarjeta_Service;

@SessionAttributes
@Controller
public class planPagoController {

	@Autowired
	private I_Plan_Pago_Service planPagoService;
	
	@Autowired
	private I_Tarjeta_Service tarjetaService;
	
	@Autowired
	private I_Medio_Pago_Service medioPagoService;
	
	@GetMapping("/planes_pagos")
	public String planes_pagos(Model model) {
		
		model.addAttribute("planes_pagos", planPagoService.listar());
		
		model.addAttribute("tarjetas", tarjetaService.buscarTarjetasCredito());
		
		model.addAttribute("plan_pago", new Plan_Pago());
		
		return "planes_pagos";
	}
	
	@PostMapping("/planes_pagos")
	public String formulario(@Valid Plan_Pago plan_pago) {
		
		plan_pago.setActivo(true);
		plan_pago.setAlta(new Date());
		plan_pago.setMedio_pago(medioPagoService.buscarPorId(2));
		planPagoService.guardar(plan_pago); 
		
		return "redirect:/planes_pagos";
	}
	
}
