package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Pago;
import com.ryr.models.repo.I_Pago_Repo;

@Service
public class Impl_Pago_Service implements I_Pago_Service{

	@Autowired
	private I_Pago_Repo repo;

	@Override
	public List<Pago> listarTodo() {
		// TODO Auto-generated method stub
		return (List<Pago>) repo.findAll();
	}

	@Override
	public void guardar(Pago pago) {
		// TODO Auto-generated method stub
		repo.save(pago);
	}
	
}
