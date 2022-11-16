package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Comprobante;
import com.ryr.models.repo.I_Comprobante_Repo;

@Service
public class Impl_Comprobante_Service implements I_Comprobante_Service {

	@Autowired
	private I_Comprobante_Repo repo;
	
	@Override
	public void guardar(Comprobante comprobante) {
		// TODO Auto-generated method stub
		repo.save(comprobante);
	}

	@Override
	public List<Comprobante> listar() {
		// TODO Auto-generated method stub
		return (List<Comprobante>) repo.findAll();
	}

}
