package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Venta_Pago;

public interface I_Venta_Pago_Service {
	
	public List<Venta_Pago> listar();
	
	public Venta_Pago buscarPorId(long id_venta_pago);
	
	public void guardar(Venta_Pago venta_pago);

}
