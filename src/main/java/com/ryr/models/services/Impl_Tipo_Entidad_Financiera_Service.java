package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Tipo_Entidad_Financiera;
import com.ryr.models.repo.I_Tipo_Entidad_Financiera_Repo;

@Service
public class Impl_Tipo_Entidad_Financiera_Service implements I_Tipo_Entidad_Financiera_Service {

	@Autowired
	private I_Tipo_Entidad_Financiera_Repo repo;
	
	@Override
	public List<Tipo_Entidad_Financiera> listar() {
		// TODO Auto-generated method stub
		return (List<Tipo_Entidad_Financiera>) repo.findAll();
	}

}
