package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Cuenta_Corriente;
import com.ryr.models.repo.I_Cuenta_Corriente_Repo;

@Service
public class Impl_Cuenta_Corriente_Service implements I_Cuenta_Corriente_Service {
	
	@Autowired
	private I_Cuenta_Corriente_Repo repo;

	@Override
	public void guardar(Cuenta_Corriente cuenta_corriente) {
		// TODO Auto-generated method stub
		repo.save(cuenta_corriente);
	}

	@Override
	public List<Cuenta_Corriente> buscarPorCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return repo.buscarPorCliente(cliente);
	}

}
