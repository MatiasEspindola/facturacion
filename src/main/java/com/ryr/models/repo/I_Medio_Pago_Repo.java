package com.ryr.models.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Medio_Pago;

public interface I_Medio_Pago_Repo extends CrudRepository<Medio_Pago, Long> {
	
	@Query("Select mp From Medio_Pago mp where mp.descripcion = ?1")
	public Medio_Pago buscarPorNombre(String descripcion);

}
