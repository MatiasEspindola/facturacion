package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Tarjeta;
import com.ryr.models.repo.I_Tipo_Tarjeta_Repo;

@Service
public class Impl_Tipo_Tarjeta_Service implements I_Tipo_Tarjeta_Service {

	@Autowired
	private I_Tipo_Tarjeta_Repo repo;
	
	@Override
	public List<Tipo_Tarjeta> listar() {
		// TODO Auto-generated method stub
		return (List<Tipo_Tarjeta>) repo.findAll();
	}

}
