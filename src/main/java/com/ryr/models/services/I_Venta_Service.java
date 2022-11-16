package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Venta;

public interface I_Venta_Service {
	
	public List<Venta> listar();
	
	public Venta buscarPorId(long id);
	
	public void guardar(Venta venta);

}
