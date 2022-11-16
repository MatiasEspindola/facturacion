package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Comprobante_Factura;

public interface I_Comprobante_Factura_Service {
	
	public List<Comprobante_Factura> listar();
	
	public Comprobante_Factura buscarPorId(long id);
	
	public void guardar(Comprobante_Factura comprobante_factura);

}
