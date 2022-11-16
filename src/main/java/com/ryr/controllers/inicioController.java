package com.ryr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class inicioController {

	@GetMapping({"/","/inicio"})
	public String incio() {
		
		return "inicio";
	}
	
}
