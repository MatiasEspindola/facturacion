package com.ryr.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Comprobante;
import com.ryr.models.entities.Comprobante_Factura;
import com.ryr.models.entities.Cuenta_Corriente;
import com.ryr.models.entities.Factura;
import com.ryr.models.entities.ItemFactura;
import com.ryr.models.entities.Lista_Precio_Cliente;
import com.ryr.models.entities.Medio_Pago;
import com.ryr.models.entities.Pago;
import com.ryr.models.entities.Producto;
import com.ryr.models.entities.Tipo_Factura;
import com.ryr.models.entities.Tipo_Pago_Lista_Precio;
import com.ryr.models.entities.Venta;
import com.ryr.models.entities.Venta_Pago;
import com.ryr.models.services.I_Cliente_Service;
import com.ryr.models.services.I_Comprobante_Factura_Service;
import com.ryr.models.services.I_Comprobante_Service;
import com.ryr.models.services.I_Cuenta_Corriente_Service;
import com.ryr.models.services.I_Factura_Service;
import com.ryr.models.services.I_ItemFactura_Service;
import com.ryr.models.services.I_Lista_Precio_Cliente_Service;
import com.ryr.models.services.I_Lista_Precio_Service;
import com.ryr.models.services.I_Medio_Pago_Service;
import com.ryr.models.services.I_Pago_Service;
import com.ryr.models.services.I_Producto_Lista_Service;
import com.ryr.models.services.I_Producto_Service;
import com.ryr.models.services.I_Tipo_Factura_Service;
import com.ryr.models.services.I_Tipo_Pago_Lista_Precio_Service;
import com.ryr.models.services.I_Venta_Pago_Service;
import com.ryr.models.services.I_Venta_Service;

@Controller
public class facturaController {
	
	@Autowired
	private I_Producto_Service productoService;
	
	@Autowired
	private I_Factura_Service facturaService;
	
	@Autowired
	private I_ItemFactura_Service itemFacturaService;
	
	@Autowired
	private I_Cliente_Service clienteService;

	@Autowired
	private I_Lista_Precio_Cliente_Service listaPrecioClienteService;
	
	@Autowired
	private I_Lista_Precio_Service listaPrecioService;
	
	@Autowired
	private I_Tipo_Pago_Lista_Precio_Service tipoPagoListaPrecioService;
	
	@Autowired
	private I_Pago_Service pagoService;
	
	@Autowired
	private I_Medio_Pago_Service medioPagoService;
	
	@Autowired
	private I_Comprobante_Service comprobanteService;
	
	@Autowired
	private I_Cuenta_Corriente_Service cuentaCorrienteService;
	
	@Autowired
	private I_Tipo_Factura_Service tipoFacturaService;
	
	@Autowired
	private I_Producto_Lista_Service productoListaService;
	
	@Autowired
	private I_Venta_Service ventaService;
	
	private List<Cliente> clientes;
	
	private List<Lista_Precio_Cliente> lista_precio_cliente;

	private List<Tipo_Pago_Lista_Precio> tipos_pagos_lista_precio;
	
	@Autowired
	private I_Venta_Pago_Service ventaPagoService;
	
	@Autowired
	private I_Comprobante_Factura_Service comprobanteFacturaService;
	
	private static final Logger log = LoggerFactory.getLogger(facturaController.class);
	
	private Integer[] itemId;
	private Integer[] cantidad;
	private Double[] precio;
	private Integer[] pagoId; 
	private Double[] importe;
	private Factura factura;
	private Double recargo;
	
	@PostMapping("/detalles_factura") 
	public String enviar_datos(@RequestParam(name = "item_id[]", required = false) Integer[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, 
			@RequestParam(name = "precio[]", required = false) Double[] precio, 
			
			@RequestParam(name = "pago_id[]", required = false) Integer[] pagoId,
			
			@RequestParam(name = "descripcion[]", required = false) String[] descripcion,
			@RequestParam(name = "medio_pago[]", required = false) String[] medio_pago,
			@RequestParam(name = "interes[]", required = false) String[] interes,
			@RequestParam(name = "cuotas[]", required = false) String[] cuotas,
			@RequestParam(name = "subtotal[]", required = false) Double[] subtotal,
			@RequestParam(name = "total[]", required = false) Double[] total,
		
			@RequestParam(name = "subtotal", required = false) Double subtotal_factura,
			@RequestParam(name = "total", required = false) String total_factura,
			@RequestParam(name = "cliente", required = false) Integer cli_codigo,
			RedirectAttributes redirAttrs) {
		
	
		
		if (itemId == null || cantidad == null) {
			redirAttrs.addFlashAttribute("error", "¡Error!, Debe cargar al menos un producto");
			return "redirect:/facturacion";
		}
		
		Cliente cliente = clienteService.buscarPorCodCliente(cli_codigo);
		
		if	(cliente == null) {
			redirAttrs.addFlashAttribute("error", "¡Error!, Debe cargar al menos un producto");
			return "redirect:/facturacion";
		}
		
		
		
		Factura factura = new Factura(); 
		
		Tipo_Factura tipo_factura = null;

		switch(cliente.getIva_codigo().getIva_codigo()) {
			case 1:
				tipo_factura = tipoFacturaService.buscarPorId(1);
				
				factura.setTipo_factura(tipo_factura);
				break;
			case 6,3,5:
				tipo_factura = tipoFacturaService.buscarPorId(2);
			
				factura.setTipo_factura(tipo_factura);
				break;
		}
		 
		log.info("Nueva Factura Creada: " + factura); 
		
		log.info("*** FACTURA " + factura.getTipo_factura().getCod_tipo_factura()); 
		
		factura.setFecha(new Date());
		
	
		log.info("Cliente: " + cliente.getRazon_social());
		
	

		for (int i = 0; i < itemId.length; i++) {
			if(itemId[i] != null) {
				ItemFactura linea = new ItemFactura();
				
			
				
				linea.setFkprocodigo(productoListaService.buscarPorId(itemId[i]));
				linea.setImporte(precio[i]);
				linea.setCantidad(cantidad[i]);
				linea.setTipo_iva(productoListaService.buscarPorId(itemId[i]).getFkidproductolista().getIva());
				linea.setTotal(linea.getImporte() * linea.getCantidad());
				

				factura.addItemFactura(linea);
			}
		}
	
		log.info("El subtotal de la factura es: " + subtotal_factura);
		
		log.info("El total de la factura es: " + total_factura);
		
		factura.setSubtotal(Double.valueOf(subtotal_factura));
		factura.setTotal(Double.valueOf(total_factura));
		factura.setDescripcion("-");
		
		factura.setDescripcion_importe(
				
				"RECIBIMOS (" + Convertir(String.valueOf(total_factura), "PESOS", "PESOS", "CENTAVOS", "CENTAVOS", "CON", true)
				+ ")"

				
				);
		
		
		Comprobante comprobante = new Comprobante();
		Cuenta_Corriente cuenta_corriente = new Cuenta_Corriente();
		
		
		if(!cliente.getRazon_social().equals("CONSUMIDOR FINAL")) {
			
			log.info("** CLIENTE NO CONSUMIDOR FINAL");
			
		
			
			
			
		
			
			List<Cuenta_Corriente> cuentas_corrientes_cliente = cuentaCorrienteService.buscarPorCliente(cliente);
			
			double ult_saldo = cuentas_corrientes_cliente.get(cuentas_corrientes_cliente.size() - 1).getSaldo();
			
			cuenta_corriente.setDebe(factura.getTotal());
			cuenta_corriente.setSaldo(ult_saldo + cuenta_corriente.getDebe());
			cuenta_corriente.setHaber(0);
			
			cuenta_corriente.setFecha(new Date());
			
			cuenta_corriente.setCliente(cliente);
			
			cuentaCorrienteService.guardar(cuenta_corriente);
			factura.setCuenta_corriente(cuenta_corriente);
			
			comprobante.setCuenta_corriente(cuenta_corriente);
		}else {
			log.info("** CLIENTE CONSUMIDOR FINAL");
			factura.setCuenta_corriente(null);
			comprobante.setCuenta_corriente(null);
		}
		
		comprobante.setComprobante(factura.getTipo_factura().getCod_tipo_factura() + " VENTA/" + cli_codigo);
		
		comprobante.setFecha(new Date());
	
		
		comprobanteService.guardar(comprobante);
		
		facturaService.guardar(factura);
		
		Venta venta = new Venta();
		venta.setFecha(new Date());
		
		ventaService.guardar(venta);
		//venta.setPago(pago);
		
		venta.setComprobante(comprobante);
		
		for (int i = 0; i < pagoId.length; i++) {
			if(pagoId[i] != null) {
			
				
				Pago pago = new Pago();
			    pago.setId_factura(factura);
			    pago.setSubtotal(subtotal[i]);
			    pago.setTotal(total[i]);
			    pago.setDescripcion(descripcion[i]);
			    Medio_Pago mp = medioPagoService.buscarPorNombre(medio_pago[i]);
			    
			    log.info("Medio de Pago: " + mp.getDescripcion());
			    
			    pago.setMedio_pago(mp);
			    pago.setFecha(new Date());
			    pago.setDescuento(0);
			    pago.setAprobado(false);
			    

				log.info("Medio de Pago: " + mp.getDescripcion());
				log.info("Subtotal Pago: " + subtotal[i]);
				log.info("Total Pago: " + total[i]);
				log.info("Descripción Pago: " + descripcion[i]);
				log.info("Interes Pago: " + interes[i]);
				log.info("Cuotas Pago: " + cuotas[i]);
			    
				//pago.setId_tipo_pago_lista_precio(tipoPagoListaPrecioService.buscarPorId(pagoId[i]));
		        //pago.setTotal(importe[i]);
				//pago.setImporte(importe[i]);
				pagoService.guardar(pago);
				
			
				
			
				
				Venta_Pago venta_pago = new Venta_Pago();
				
				venta_pago.setPago(pago);
				venta_pago.setVenta(venta);
				
				ventaPagoService.guardar(venta_pago);
				
				
				
			
			}
		}
		
		Comprobante_Factura comprobante_factura = new Comprobante_Factura();
		
		comprobante_factura.setComprobante(comprobante);
		comprobante_factura.setFactura(factura);
		
		comprobanteFacturaService.guardar(comprobante_factura);
		
		if(cliente.getCli_codigo() == 1) {
			return "redirect:/comprobantes";
		}
		
		return "redirect:/detalles/"+cliente.getCli_codigo();
	}
	
	@GetMapping("/detalles_factura/{id_factura}")
	public String detalles(Model model, RedirectAttributes redirAttrs, @PathVariable(name="id_factura") Long id_factura) {
		
		Factura factura = facturaService.buscarPorId(id_factura);
		
		if(factura == null) {
			redirAttrs.addFlashAttribute("error", "¡Error!, No se realizó la carga de datos correctamente");
			return "redirect:/facturacion";
		}
		
		double importe21 = 0, importe105 = 0;
		
		for (ItemFactura item : factura.getItems()) {
			if(Float.parseFloat(item.getFkprocodigo().getFkidproductolista().getIva()) >= 21) {
			
				importe21 += (item.getImporte() * item.getCantidad()) * 21 / 100;
			}else {
			
				importe105 += (item.getImporte() * item.getCantidad()) * 10.5 / 100;
			}
		}
		

		
		model.addAttribute("lineas", factura.getItems());
		model.addAttribute("pagos", factura.getPagos());
		model.addAttribute("iva21", importe21);
		model.addAttribute("iva105", importe105);
		model.addAttribute("subtotal", factura.getSubtotal());
		model.addAttribute("total", factura.getTotal());
		
		
		return "factura";
	}
	
	private final String[] UNIDADES = {"", "", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
	private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
	    "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
	    "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
	private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
	    "setecientos ", "ochocientos ", "novecientos "};
	
	public String Convertir(String numero, String etiquetaEnteroSingular,String etiquetaEnteroPlural, String etiquetaFlotanteSingular,String etiquetaFlotantePlural, String etiquetaConector, boolean mayusculas) {
	    String literal = "";
	    String parte_decimal = "";
	    //si el numero utiliza (.) en lugar de (,) -> se reemplaza
	    numero = numero.replace(".", ",");
	    //si el numero no tiene parte decimal, se le agrega ,00
	    if (numero.indexOf(",") == -1) {
	        numero = numero + ",00";
	    }
	    //se valida formato de entrada -> 0,00 y 999 999 999 999,00
	    if (Pattern.matches("\\d{1,12},\\d{1,2}", numero)) {
	        //se divide el numero 0000000,00 -> entero y decimal
	        String Num[] = numero.split(",");
	        //de da formato al numero decimal
	        if (Num[1].length()==1) {
	        	Num[1] += "0";
	        }                        
	        String d = getDecenas(Num[1]);
	        if (d!="") {
	        	if (etiquetaEnteroSingular!="") parte_decimal += " ";
	        	if (Integer.parseInt(Num[1])==1) {
	        		parte_decimal += etiquetaConector + " " + d + etiquetaFlotanteSingular;
	        	} else {
	        		parte_decimal += etiquetaConector + " " + d + etiquetaFlotantePlural;
	        	}
	        }
	        
	        //se convierte el numero a literal                       
			BigInteger parteEntera = new BigInteger(Num[0]);
	       
	        if (parteEntera.compareTo(new BigInteger("0")) == 0) {//si el valor es cero
	            literal = "cero ";
	        } else if (parteEntera.compareTo(new BigInteger("999999999")) == 1 ) {//si es billon
	            literal = getBillones(Num[0]);
	        } else if (parteEntera.compareTo(new BigInteger("999999")) == 1 ) {//si es millon
	            literal = getMillones(Num[0]);
	        } else if (parteEntera.compareTo(new BigInteger("999")) == 1 ) {//si es miles
	            literal = getMiles(Num[0]);
	        } else if (parteEntera.compareTo(new BigInteger("99")) == 1 ) {//si es centena
	            literal = getCentenas(Num[0]);
	        } else if (parteEntera.compareTo(new BigInteger("9")) == 1 ) {//si es decena
	            literal = getDecenas(Num[0]);
	        } else {//sino unidades -> 9
	            literal = getUnidades(Num[0]);
	        }
	        //devuelve el resultado en mayusculas o minusculas
	        
	        if (parteEntera.compareTo(new BigInteger("1")) == 0) {
	        	literal += etiquetaEnteroSingular;            	
	        } else {
	        	literal += etiquetaEnteroPlural;
	        }            
	        
	        if (mayusculas) {
	            return (literal + parte_decimal).toUpperCase();
	        } else {
	            return (literal + parte_decimal);
	        }
	    } else {//error, no se puede convertir
	        return literal = null;
	    }
	}

	/* funciones para convertir los numeros a literales */
	private String getUnidades(String numero) {// 1 - 9
	    //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
	    String num = numero.substring(numero.length() - 1);
	    return UNIDADES[Integer.parseInt(num)];
	}

	private String getDecenas(String num) {// 99 
		int n = Integer.parseInt(num); 
		if (n < 10) {//para casos como -> 01 - 09 
			return getUnidades(num); 
		} else if (n > 19) {//para 20...99 
			String u = getUnidades(num); 
			if (u.equals("")) { //para 20,30,40,50,60,70,80,90 
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8]; 
			} else { 
				if(n == 21) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 22) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 23) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 24) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 25) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 26) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 27) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;}
				if(n == 28) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;} 
				if(n == 29) {return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8].substring(0,5) + "i" + u;} 
				return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u; 
			} 
		} else {//numeros entre 11 y 19 
			return DECENAS[n - 10];
		} 
	}

	private String getCentenas(String num) {// 999 o 099
	    if (Integer.parseInt(num) > 99) {//es centena
	        if (Integer.parseInt(num) == 100) {//caso especial
	            return " cien ";
	        } else {
	            return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
	        }
	    } else {//por Ej. 099 
	        //se quita el 0 antes de convertir a decenas
	        return getDecenas(Integer.parseInt(num) + "");
	    }
	}

	private String getMiles(String numero) {// 999 999
	    //obtiene las centenas
	    String c = numero.substring(numero.length() - 3);
	    //obtiene los miles
	    String m = numero.substring(0, numero.length() - 3);
	    String n = "";
	    //se comprueba que miles tenga valor entero
	    if (Integer.parseInt(m) > 0) {
	        n = getCentenas(m);
	        return n + "mil " + getCentenas(c);
	    } else {
	        return "" + getCentenas(c);
	    }

	}

	private String getMillones(String numero) { //000 000 000        
	    //se obtiene los miles
	    String miles = numero.substring(numero.length() - 6);
	    //se obtiene los millones
	    String millon = numero.substring(0, numero.length() - 6);
	    String n = "";
	    if (Integer.parseInt(millon) > 0) {
	    	if (Integer.parseInt(millon) == 1) {
	    		n = getUnidades(millon) + "millon ";
	    	} else {
	    		n = getCentenas(millon) + "millones ";
	    	}
	    }
	    
	    return n + getMiles(miles);
	}

	private String getBillones(String numero) { //000 000 000 000        
	    //se obtiene los miles
	    String miles = numero.substring(numero.length() - 9);
	    //se obtiene los millones
	    String millon = numero.substring(0, numero.length() - 9);
	    String n = "";
	    if (Integer.parseInt(millon) == 1) {
	    	n = getUnidades(millon) + "billon ";
	    } else {
	    	n = getCentenas(millon) + "billones ";
	    }
	    
	    return n + getMillones(miles);
	}
	
	
	
}
