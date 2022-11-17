package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Iva;
import com.ryr.models.repo.I_Tipo_Iva_Repo;

@Service
public class Impl_Tipo_Iva_Service implements I_Tipo_Iva_Service {

	@Autowired
	private I_Tipo_Iva_Repo repo;
	
	@Override
	public List<Tipo_Iva> listar() {
		// TODO Auto-generated method stub
		return (List<Tipo_Iva>) repo.findAll();
	}

}
