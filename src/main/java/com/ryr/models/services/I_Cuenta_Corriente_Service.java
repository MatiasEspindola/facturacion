package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Cuenta_Corriente;

public interface I_Cuenta_Corriente_Service {

	public void guardar(Cuenta_Corriente cuenta_corriente);
	
	public List<Cuenta_Corriente> buscarPorCliente(Cliente cliente);
	
}
