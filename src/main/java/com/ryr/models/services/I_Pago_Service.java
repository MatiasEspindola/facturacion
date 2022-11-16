package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Pago;

public interface I_Pago_Service {

	public List<Pago> listarTodo();
	
	public void guardar(Pago pago);
	
}
