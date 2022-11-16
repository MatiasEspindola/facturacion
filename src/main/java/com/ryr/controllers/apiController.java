package com.ryr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryr.models.entities.Factura;
import com.ryr.models.entities.ItemFactura;
import com.ryr.models.services.I_Factura_Service;



@RestController
@RequestMapping("api/factura")
public class apiController {
	
	@Autowired
	private I_Factura_Service facturaService;

	@RequestMapping(value = "listartodo", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<Iterable<Factura>> listarFacturas() {
		try {
			return new ResponseEntity<Iterable<Factura>>(facturaService.listarTodo(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Factura>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "buscar/{id}", method = RequestMethod.GET, produces = {
			MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<Factura> buscarFacturaPorIdFactura(@PathVariable("id") Long id) {
		try {
			return new ResponseEntity<Factura>(facturaService.buscarPorId(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Factura>(HttpStatus.BAD_REQUEST);
		}
	}

}
