package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Comprobante;

public interface I_Comprobante_Service {
	
	public void guardar(Comprobante comprobante);

	public List<Comprobante> listar();
	
}
