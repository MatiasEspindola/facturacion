package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Entidad_Financiera;
import com.ryr.models.repo.I_Entidad_Financiera_Repo;

@Service
public class Impl_Entidad_Financiera_Service implements I_Entidad_Financiera_Service {

	@Autowired
	private I_Entidad_Financiera_Repo repo;
	
	@Override
	public List<Entidad_Financiera> listar() {
		// TODO Auto-generated method stub
		return (List<Entidad_Financiera>) repo.findAll();
	}

	@Override
	public Entidad_Financiera buscarPorId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public void guardar(Entidad_Financiera entidad_financiera) {
		// TODO Auto-generated method stub
		 repo.save(entidad_financiera);
	}

}
