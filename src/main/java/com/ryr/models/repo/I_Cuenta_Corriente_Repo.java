package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Cuenta_Corriente;

public interface I_Cuenta_Corriente_Repo extends CrudRepository<Cuenta_Corriente, Long> {
	
	@Query("Select cc From Cuenta_Corriente cc where cc.cliente = ?1")
	public List<Cuenta_Corriente> buscarPorCliente(Cliente cliente); 

}
