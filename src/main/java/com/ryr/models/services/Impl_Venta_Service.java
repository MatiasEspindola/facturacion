package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Venta;
import com.ryr.models.repo.I_Venta_Repo;

@Service
public class Impl_Venta_Service implements I_Venta_Service {

	@Autowired
	private I_Venta_Repo repo;
	
	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return (List<Venta>) repo.findAll();
	}

	@Override
	public Venta buscarPorId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void guardar(Venta venta) {
		// TODO Auto-generated method stub
		repo.save(venta);
	}

}
