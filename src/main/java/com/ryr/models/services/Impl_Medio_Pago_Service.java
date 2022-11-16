package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Medio_Pago;
import com.ryr.models.repo.I_Medio_Pago_Repo;

@Service
public class Impl_Medio_Pago_Service implements I_Medio_Pago_Service {

	@Autowired
	private I_Medio_Pago_Repo repo;
	
	@Override
	public List<Medio_Pago> listar() {
		// TODO Auto-generated method stub
		return (List<Medio_Pago>) repo.findAll();
	}

	@Override
	public Medio_Pago buscarPorId(long id_medio_pago) {
		// TODO Auto-generated method stub
		return repo.findById(id_medio_pago).orElse(null);
	}

	@Override
	public Medio_Pago buscarPorNombre(String descripcion) {
		// TODO Auto-generated method stub
		return repo.buscarPorNombre(descripcion);
	}

}
