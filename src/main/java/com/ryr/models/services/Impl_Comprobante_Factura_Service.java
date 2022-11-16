package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Comprobante_Factura;
import com.ryr.models.repo.I_Comprobante_Factura_Repo;

@Service
public class Impl_Comprobante_Factura_Service implements I_Comprobante_Factura_Service {

	@Autowired
	private I_Comprobante_Factura_Repo repo;
	
	@Override
	public List<Comprobante_Factura> listar() {
		// TODO Auto-generated method stub
		return (List<Comprobante_Factura>) repo.findAll();
	}

	@Override
	public Comprobante_Factura buscarPorId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void guardar(Comprobante_Factura comprobante_factura) {
		// TODO Auto-generated method stub
		repo.save(comprobante_factura);
	}

}
