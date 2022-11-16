package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Plan_Pago;

public interface I_Plan_Pago_Service {
	
	public List<Plan_Pago> listar();
	
	public Plan_Pago buscarPorId(long id);
	
	public List<Plan_Pago> buscarPorTerm(String term);
	
	public void guardar(Plan_Pago plan_pago);

}
