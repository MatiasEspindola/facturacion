package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Venta_Pago;
import com.ryr.models.repo.I_Venta_Pago_Repo;

@Service
public class Impl_Venta_Pago_Service implements I_Venta_Pago_Service {

	@Autowired
	private I_Venta_Pago_Repo repo;
	
	@Override
	public List<Venta_Pago> listar() {
		// TODO Auto-generated method stub
		return (List<Venta_Pago>) repo.findAll();
	}

	@Override
	public Venta_Pago buscarPorId(long id_venta_pago) {
		// TODO Auto-generated method stub
		return repo.findById(id_venta_pago).orElse(null);
	}

	@Override
	public void guardar(Venta_Pago venta_pago) {
		// TODO Auto-generated method stub
		repo.save(venta_pago);
	}

}
