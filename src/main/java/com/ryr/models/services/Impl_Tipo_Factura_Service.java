package com.ryr.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Factura;
import com.ryr.models.repo.I_Tipo_Factura_Repo;

@Service
public class Impl_Tipo_Factura_Service implements I_Tipo_Factura_Service {
	
	@Autowired
	private I_Tipo_Factura_Repo repo;

	@Override
	public Tipo_Factura buscarPorId(long id_tipo_factura) {
		// TODO Auto-generated method stub
		return repo.findById(id_tipo_factura).orElse(null);
	}

}
