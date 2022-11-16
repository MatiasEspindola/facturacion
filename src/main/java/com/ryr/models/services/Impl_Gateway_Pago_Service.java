package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Gateway_Pago;
import com.ryr.models.repo.I_Gateway_Pago_Repo;

@Service
public class Impl_Gateway_Pago_Service implements I_Gateway_Pago_Service {

	@Autowired
	private I_Gateway_Pago_Repo repo;
	
	@Override
	public List<Gateway_Pago> listar() {
		// TODO Auto-generated method stub
		return (List<Gateway_Pago>) repo.findAll();
	}

	@Override
	public Gateway_Pago buscarPorId(long id_gateway_pago) {
		// TODO Auto-generated method stub
		return repo.findById(id_gateway_pago).orElse(null);
	}

}
