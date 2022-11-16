package com.ryr.models.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ryr.models.entities.Cliente;
import com.ryr.models.entities.Lista_Precio_Cliente;

public interface I_Lista_Precio_Cliente_Repo extends CrudRepository<Lista_Precio_Cliente, Long>{

	
	
}
