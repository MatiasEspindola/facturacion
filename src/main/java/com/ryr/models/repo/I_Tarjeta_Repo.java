package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Tarjeta;

public interface I_Tarjeta_Repo extends CrudRepository<Tarjeta, Long> {
	
	@Query("Select t From Tarjeta t where t.tipo_tarjeta = 1")
	public List<Tarjeta> buscarTarjetasDebito();
	
	@Query("Select t From Tarjeta t where t.tipo_tarjeta = 2")
	public List<Tarjeta> buscarTarjetasCredito();
	
	@Query("Select t From Tarjeta t group by t.tipo_tarjeta")
	public List<Tarjeta> agruparTarjetas();

}
