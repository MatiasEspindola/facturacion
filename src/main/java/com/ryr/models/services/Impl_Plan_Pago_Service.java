package com.ryr.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryr.models.entities.Plan_Pago;
import com.ryr.models.repo.I_Plan_Pago_Repo;

@Service
public class Impl_Plan_Pago_Service implements I_Plan_Pago_Service {

	@Autowired
	private I_Plan_Pago_Repo repo;
	
	@Override
	public List<Plan_Pago> listar() {
		// TODO Auto-generated method stub
		return (List<Plan_Pago>) repo.findAll();
	}

	@Override
	public Plan_Pago buscarPorId(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Plan_Pago> buscarPorTerm(String term) {
		// TODO Auto-generated method stub
		return repo.buscarPorTerm(term);
	}

	@Override
	public void guardar(Plan_Pago plan_pago) {
		// TODO Auto-generated method stub
		repo.save(plan_pago);
	}

}
