package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Medio_Pago;

public interface I_Medio_Pago_Service {
	
	public List<Medio_Pago> listar();
	
	public Medio_Pago buscarPorId(long id_medio_pago);
	
	public Medio_Pago buscarPorNombre(String descripcion);

}
