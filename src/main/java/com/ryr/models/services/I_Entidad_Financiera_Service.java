package com.ryr.models.services;

import java.util.List;

import com.ryr.models.entities.Entidad_Financiera;

public interface I_Entidad_Financiera_Service {
	
	public List<Entidad_Financiera> listar();
	
	public Entidad_Financiera buscarPorId(long id);
	
	public void guardar(Entidad_Financiera entidad_financiera);

}
