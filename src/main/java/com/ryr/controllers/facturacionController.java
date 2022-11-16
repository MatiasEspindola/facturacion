package com.ryr.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Comprobante;
import com.ryr.models.entities.Cuenta_Corriente;
import com.ryr.models.entities.Entidad_Financiera;
import com.ryr.models.entities.Factura;
import com.ryr.models.entities.Gateway_Pago;
import com.ryr.models.entities.Lista_Precio;
import com.ryr.models.entities.Lista_Precio_Cliente;
import com.ryr.models.entities.Medio_Pago;
import com.ryr.models.entities.Pago;
import com.ryr.models.entities.Plan_Pago;
import com.ryr.models.entities.Producto_Lista;
import com.ryr.models.entities.Tarjeta;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;
import com.ryr.models.services.I_Cliente_Service;
import com.ryr.models.services.I_Comprobante_Service;
import com.ryr.models.services.I_Cuenta_Corriente_Service;
import com.ryr.models.services.I_Entidad_Financiera_Service;
import com.ryr.models.services.I_Gateway_Pago_Service;
import com.ryr.models.services.I_Medio_Pago_Service;
import com.ryr.models.services.I_Plan_Pago_Service;
import com.ryr.models.services.I_Producto_Lista_Service;
import com.ryr.models.services.I_Tarjeta_Service;
import com.ryr.models.services.I_Tipo_Pago_Lista_Precio_Service;

@Controller
public class facturacionController {

	@Autowired 
	private I_Cliente_Service clienteService;

	@Autowired
	private I_Producto_Lista_Service productoListaService;

	@Autowired
	private I_Tipo_Pago_Lista_Precio_Service tipoPagoListaService;
	
	@Autowired
	private I_Medio_Pago_Service medioPagoService;
	
	@Autowired
	private I_Plan_Pago_Service planPagoService;
	
	@Autowired
	private I_Entidad_Financiera_Service entidadFinancieraService;
	
	@Autowired
	private I_Gateway_Pago_Service gatewayPagoService;
	
	@Autowired
	private I_Tarjeta_Service tarjetaService;
	
	@Autowired
	private I_Comprobante_Service comprobanteService;
	
	@Autowired
	private I_Cuenta_Corriente_Service cuentaCorrienteService;

	private static final Logger log = LoggerFactory.getLogger(facturacionController.class);

	private Factura factura;

	private Cliente cliente;

	private Lista_Precio lista_precio; 

	private Tipo_Pago_Lista_Precio tipo_pago_lista_precio;
	
	private boolean busqueda_activada = false;
	
	@GetMapping(value = "/entidades", produces = { "application/json" })
	public @ResponseBody List<Entidad_Financiera> entidades() {
		return entidadFinancieraService.listar();
	}

	@GetMapping(value = "/gateways", produces = { "application/json" })
	public @ResponseBody List<Gateway_Pago> gateways(@RequestParam String id_medio_pago) {
		return medioPagoService.buscarPorId(Long.valueOf(id_medio_pago)).getGateways();
	}
	
	

	@GetMapping(value = "/buscar_cliente/{term}", produces = { "application/json" })
	public @ResponseBody List<Cliente> buscar_cliente(@PathVariable String term) {
		log.info("** REALIZANDO BÚSQUEDA DE CLIENTE EN EL AUTOCOMPLETE");
		return clienteService.buscarPorTerm(term);
	}
	
	@GetMapping(value = "/buscar_plan_pago/{term}", produces = { "application/json" })
	public @ResponseBody List<Plan_Pago> buscar_plan_pago(@PathVariable String term) {
		log.info("** REALIZANDO BÚSQUEDA DEL PLAN DE PAGO EN EL AUTOCOMPLETE");
		return planPagoService.buscarPorTerm(term);
	}

	@PostMapping(value = "/formBuscarCliente")
	public String form_buscar_cliente(@RequestParam(name = "ingresar_cliente") String ingresar_cliente,
			RedirectAttributes redirAttrs) {
     
		if (ingresar_cliente.isEmpty()) {
			log.info("** Cliente no encontrado");
			cliente = null;
			redirAttrs.addFlashAttribute("no_encontrado", "Cliente no encontrado");
		} else {
			cliente = clienteService.buscarPorCodCliente(Integer.valueOf(ingresar_cliente));
			log.info("** Cliente encontrado: " + cliente.getRazon_social());

		
		
			busqueda_activada = true;
                         
			redirAttrs.addFlashAttribute("encontrado", "Resultados desplegados con éxito");
		}

		return "redirect:/facturacion";
	}
	
	@GetMapping(value = "/formBuscarCliente")
	public String seleccionar_cliente(@RequestParam(name = "ingresar_cliente") String ingresar_cliente,
			RedirectAttributes redirAttrs) {
		
		if (ingresar_cliente.isEmpty()) {
			log.info("** Cliente no encontrado");
			cliente = null;
			redirAttrs.addFlashAttribute("no_encontrado", "Cliente no encontrado");
		} else {
			cliente = clienteService.buscarPorCodCliente(Integer.valueOf(ingresar_cliente));
			log.info("** Cliente encontrado: " + cliente.getRazon_social());

		
                         
			redirAttrs.addFlashAttribute("encontrado", "Resultados desplegados con éxito");
		}
		
		return "redirect:/facturacion";
	} 

	@GetMapping(value = "/cargar_producto/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto_Lista> cargar_producto(@PathVariable String term) {
		log.info("** REALIZANDO BÚSQUEDA DE PRODUCTO EN EL AUTOCOMPLETE");
		return productoListaService.buscarPorTerm(term, cliente.getFkidlistaprecio());
	}
	
	@GetMapping(value = "/cancelar")
	public String cancelar() {
	
		cliente = null;
				
		return "redirect:/facturacion";
	}


	@GetMapping({"/facturacion","/"})
	public String facturacion(Model model, HttpServletRequest request) {
		
		

		model.addAttribute("cliente", cliente);
		
		model.addAttribute("clientes", clienteService.listarTodo());
	
		

		if (cliente != null) {  
			 
			model.addAttribute("lista_precio", cliente.getFkidlistaprecio());
                        

			if (cliente.getFkidlistaprecio() != null) {
                            
                            List<Tipo_Pago_Lista_Precio>  tipos_pagos_lista_precio = tipoPagoListaService.buscarPorListaPrecio(cliente.getFkidlistaprecio());
                                                   
                            model.addAttribute("tipo_pago_lista_precio", tipo_pago_lista_precio);

                            model.addAttribute("tipos_pagos_lista_precio", tipos_pagos_lista_precio);

                            model.addAttribute("medios_pagos", medioPagoService.listar());
                            
                            model.addAttribute("entidades", entidadFinancieraService.listar());
                            
                            model.addAttribute("planes_pagos", planPagoService.listar());
                            
                            model.addAttribute("gateways", gatewayPagoService.listar());
                            
                            model.addAttribute("tarjetas_debito", tarjetaService.buscarTarjetasDebito()); 
			}

		}

		return "facturacion";
	}
	
	

}
