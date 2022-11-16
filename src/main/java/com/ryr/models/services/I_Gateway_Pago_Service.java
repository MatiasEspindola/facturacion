package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Gateway_Pago;

public interface I_Gateway_Pago_Service {
	
	public List<Gateway_Pago> listar();
	
	public Gateway_Pago buscarPorId(long id_gateway_pago);

}
