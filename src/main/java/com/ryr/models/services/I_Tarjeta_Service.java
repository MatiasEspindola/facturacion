package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Tarjeta;

public interface I_Tarjeta_Service {
	
	public List<Tarjeta> listar();
	
	public Tarjeta buscarPorId(long id_tarjeta);
	
	public List<Tarjeta> buscarTarjetasDebito();
	
	public List<Tarjeta> buscarTarjetasCredito();
	
	public List<Tarjeta> agruparTarjetas();
	
	public void guardar(Tarjeta tarjeta);

}
