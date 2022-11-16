package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Plan_Pago;

public interface I_Plan_Pago_Repo extends CrudRepository<Plan_Pago, Long>{
	
	@Query("Select pl From Plan_Pago pl where pl.descripcion like %?1%")
	public List<Plan_Pago> buscarPorTerm(String term);

}
