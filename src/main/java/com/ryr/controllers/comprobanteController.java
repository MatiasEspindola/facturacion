package com.ryr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ryr.models.services.I_Comprobante_Factura_Service;
import com.ryr.models.services.I_Comprobante_Service;

@Controller
public class comprobanteController {
	
	@Autowired
	private I_Comprobante_Service comprobanteService;
	
	@Autowired
	private I_Comprobante_Factura_Service comprobanteFacturaService;
	
	@GetMapping("/comprobantes")
	public String comprobantes(Model model) {
		
		model.addAttribute("comprobantes_facturas", comprobanteFacturaService.listar());
		
		return "comprobantes";
	}

}
