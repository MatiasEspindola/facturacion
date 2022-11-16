package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Marca_Tarjeta;
import com.ryr.models.repo.I_Marca_Repo;

@Service
public class Impl_Marca_Tarjeta_Service implements I_Marca_Tarjeta_Service {

	@Autowired
	private I_Marca_Repo repo;
	
	@Override
	public List<Marca_Tarjeta> listar() {
		// TODO Auto-generated method stub
		return (List<Marca_Tarjeta>) repo.findAll();
	}

}
